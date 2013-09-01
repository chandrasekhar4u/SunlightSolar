/**
 * 
 */
package main.java.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import main.java.service.IUserService;

import org.apache.commons.lang.NullArgumentException;
import org.apache.myfaces.orchestra.conversation.Conversation;
import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.conversation.ConversationBindingListener;
import org.apache.myfaces.orchestra.conversation.ConversationContext;
import org.apache.myfaces.orchestra.conversation.ConversationManager;
import org.apache.myfaces.orchestra.viewController.annotations.InitView;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.jsf.FacesContextUtils;

/**
 * @author CHANDRA
 * 
 */
public class BaseController implements InitializingBean,
	ConversationBindingListener {
    
    private IUserService userService;
    private String callingBean;

    /**
     * @return the userService
     */
    public IUserService getUserService() {
        return userService;
    }

    /**
     * @param userService the userService to set
     */
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @InitView
    public void initView() {
	System.out.println("Inside InitView() method:::::::::::::::::");
	try {
	    if (!isPostBack()) {
		tidyConversations();
		onCreateView();
	    }
	} catch (Exception e) {
	    // TODO: handle exception
	    logErrorMessage(e.getMessage());
	}

    }
    
    
    
    
    
    public void tidyConversations() {

        String currentBeanName = this.getCurrentBeanName();

        if ( currentBeanName == null ) {
            // we can only invalidate conversations if we know the current bean
            // name i.e. if sub-class has override getCurrentBeanName().
            //
            // TODO: make getCurrentBeanName abstract method.
            System.out.println( "WARNING *****: sub-class has not overriden getCurrentBeanName()" );
        }
        else {
            // invalidate all conversations except:
            //
            // - the current bean
            // - the "session" bean
            // - any parent beans
            //
            System.out.println( "current bean is \"" + currentBeanName
                    + "\" - checking conversations" );

            ArrayList<String> exclusions = new ArrayList<String>();
            if ( this.callingBean != null ) {
                exclusions.add( this.callingBean );
            }
            exclusions.add( currentBeanName );
            exclusions.add( "session" );

            invalidateAllConversationsExcept( exclusions );
        }
    }
    
    public static void invalidateAllConversationsExcept( ArrayList<String> exclusions ) {
        System.out.println( ">> invalidating conversations" );

        // get the current conversation context i.e. the context for the current tab
        //
        ConversationManager conversationManager = ConversationManager.getInstance();
        ConversationContext context = conversationManager.getCurrentConversationContext();

        @SuppressWarnings( "unchecked" )
        Iterator<Conversation> it = context.iterateConversations();

        while ( it.hasNext() ) {
            Conversation conversation = it.next();
            String name = conversation.getName();
            System.out.print( name + " ... " );

            if ( !exclusions.contains( name ) ) {
                System.out.println( "*** invalidating ***" );
                conversation.invalidate();
            }
            else {
                System.out.println( "keeping" );
            }
        }

        System.out.println( "<< complete" );
    }
    
    
    private String getCurrentBeanName() {
	// TODO Auto-generated method stub
	return null;
    }

    public void logErrorMessage( String message){
	logMessage( FacesMessage.SEVERITY_ERROR, message, message );
    }
    
    public void logWarningMessage(String message){
	logMessage(FacesMessage.SEVERITY_WARN, message, message);
    }
    
    public void logFatalMessage(String message){
	logMessage(FacesMessage.SEVERITY_FATAL, message, message);
    }
    public void loInfoMessage(String message){
	logMessage(FacesMessage.SEVERITY_INFO, message, message);
    }
    private void logMessage(Severity severity, String title, String message) {
	// TODO Auto-generated method stub
	FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage( null, new FacesMessage( severity, title, message ) );
    }

    public void onCreateView(){
	System.out.println("default onCreateView method::::::::::");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.myfaces.orchestra.conversation.ConversationBindingListener
     * #valueBound
     * (org.apache.myfaces.orchestra.conversation.ConversationBindingEvent)
     */
    @Override
    public void valueBound(ConversationBindingEvent arg0) {
	System.out.println("Inside valueBound() method:::::::::::::::::");
	onCreateBean(arg0);
	// TODO Auto-generated method stub

    }
    
    public void onDestroyBean( ConversationBindingEvent arg0 ) {
        System.out.println("default onDestroyBean called" );
    }
    
    

    @InitBinder
    public void onCreateBean(ConversationBindingEvent ar0) {
	System.out.println("Inside onCreateBean() method:::::::::::::::::");
    }
    
    protected boolean isPostBack() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        return facesContext.getRenderKit().getResponseStateManager().isPostback( facesContext );
    }
    
    /**
     * returns the backing bean for the given function - the bean will be
     * created if it doesn't currently exist.
     * 
     * @param <T>
     *            - inferred automatically - do not pass
     * @param functionId
     *            - the function id
     * @return the current or new instance of the backing bean
     */
    protected static <T extends BaseController> T getBeanInstance( String beanName ) {
        if ( beanName == null ) {
            throw new NullArgumentException( "beanName" );
        }

        // we know all page backing beans extend base controller so warnings are
        // suppressed
        @SuppressWarnings( "unchecked" )
        T controller = ( T ) FacesContextUtils.getWebApplicationContext(
            FacesContext.getCurrentInstance() ).getBean( beanName );

        return controller;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.myfaces.orchestra.conversation.ConversationBindingListener
     * #valueUnbound
     * (org.apache.myfaces.orchestra.conversation.ConversationBindingEvent)
     */
    @Override
    public void valueUnbound(ConversationBindingEvent arg0) {
	System.out.println("Inside valueUnbound() method:::::::::::::::::");
	onDestroyBean(arg0);
	// TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
	System.out
		.println("Inside afterPropertiesSet() method:::::::::::::::::");
	// TODO Auto-generated method stub

    }
}
