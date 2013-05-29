/**
 * 
 */
package main.java.controller;

import main.java.service.IUserService;

import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.conversation.ConversationBindingListener;
import org.apache.myfaces.orchestra.viewController.annotations.InitView;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author CHANDRA
 * 
 */
public class BaseController implements InitializingBean,
	ConversationBindingListener {
    
    private IUserService userService;

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
    public void onCreateView() {
	System.out.println("Inside InitView() method:::::::::::::::::");

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
	// TODO Auto-generated method stub

    }

    @InitBinder
    public void onCreateBean(ConversationBindingEvent ar0) {
	System.out.println("Inside onCreateBean() method:::::::::::::::::");
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
