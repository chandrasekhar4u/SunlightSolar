/**
 * 
 */
package main.java.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.viewController.annotations.ViewController;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.client.HttpServerErrorException;

/**
 * @author CHANDRA
 * 
 */
@ViewController(viewIds = { "/screens/welcome.xhtml", "/index.xhtml" })
public class LoginBean extends BaseController {

    private String userName;

    private String password;

    /**
     * @return the userName
     */
    public String getUserName() {
	return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName) {
	this.userName = userName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see main.java.controller.BaseController#onCreateView()
     */
    @Override
    public void onCreateView() {
	// TODO Auto-generated method stub
	super.onCreateView();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * main.java.controller.BaseController#onCreateBean(org.apache.myfaces.orchestra
     * .conversation.ConversationBindingEvent)
     */
    @Override
    public void onCreateBean(ConversationBindingEvent ar0) {
	// TODO Auto-generated method stub
	super.onCreateBean(ar0);
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    public String actionLogOut(){
	logOut();
	return null;
    }
    
    

    /**
     * 
     */
    public static void logOut() {

	FacesContext fc=FacesContext.getCurrentInstance();
	ExternalContext ec= fc.getExternalContext();
	HttpServletRequest request= (HttpServletRequest) ec.getRequest();
	HttpServletResponse response=(HttpServletResponse) ec.getResponse();
	request.getSession(false).invalidate();

	// re-direct to the application root e.g. /ProdisMoffatPlus
	// Spring security will automatically forward to the login page as 
	// the session has now been invalidated
	try {
	    String contextRoot = ec.getRequestContextPath();
	    System.out.println( "redirecting to context root - " + contextRoot );
	    response.sendRedirect( contextRoot );
	}
	catch ( IOException e ) {
	    System.out.println( "exception redirecting to logon page - " + e.toString() );
	}

	// tell JSF the response is complete
	fc.responseComplete();
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    public String actionSubmit() {
	FacesContext context=FacesContext.getCurrentInstance();
	if (userName == null) {
	    context.addMessage("Message",
		    new FacesMessage("Invalid User Name."));
	    return null;

	}
	if (password == null) {
	    context.addMessage("Message",
		    new FacesMessage("Invalid Password."));
	    return null;

	}
	if(userName!=null){
	    if(userName.compareToIgnoreCase("1234")!=0){
		context.addMessage("Message",
			    new FacesMessage("Invalid User Name."));
		return null;
	    }
	}
	if(password!=null){
	    if(password.compareToIgnoreCase("1234")!=0){
		context.addMessage("Message",
			    new FacesMessage("Invalid Password."));
		 return null;
	    }
	}

	return NavigationConstants.welcomeScreen;
    }

}
