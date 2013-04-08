/**
 * 
 */
package main.java.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.viewController.annotations.ViewController;

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

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    public String actionSubmit() {

	if (userName == null) {
	    FacesContext.getCurrentInstance().addMessage("Message",
		    new FacesMessage("Invalid User Name."));
	}
	if (password == null) {
	    FacesContext.getCurrentInstance().addMessage("Message",
		    new FacesMessage("Invalid Password."));

	}
	return NavigationConstants.welcomeScreen;
    }

}
