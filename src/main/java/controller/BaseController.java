/**
 * 
 */
package main.java.controller;

import org.apache.myfaces.orchestra.conversation.ConversationBindingListener;
import org.apache.myfaces.orchestra.viewController.annotations.InitView;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author CHANDRA
 * 
 */
public abstract class BaseController implements InitializingBean,
	ConversationBindingListener {

    @InitView
    public void initView() {
	System.out.println("Inside InitView() method:::::::::::::::::");

    }
}
