/**
 * 
 */
package main.java.controller;

import main.hibernate.hbm.UserVO;

import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.conversation.ConversationUtils;
import org.apache.myfaces.orchestra.viewController.annotations.ViewController;

/**
 * @author CHANDRA
 * 
 */
@ViewController(viewIds = { "/screens/welcome.xhtml", "/index.xhtml" })
public class LoginBean extends BaseController {

    private Integer userId;

    private String password;

    /**
     * @return the userId
     */
    public Integer getUserId() {
	return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(Integer userId) {
	this.userId = userId;
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

    public String actionLogOut() {
	logOut();
	return null;
    }

    /**
     * 
     */
    public static void logOut() {
	NavigationController.logOut();
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    public String addUser() {
	ConversationUtils.getCurrentBean();
	UserController userController = UserController.getCurrentInstance();
	userController.setUserVO(new UserVO());
	return NavigationConstants.ADD_USER;
    }

    public String actionSubmit() {
	if (userId != null && password != null) {
	    UserVO userVO = getUserService().getUserById(userId);
	    System.out.println("UserVO===============>" + userVO);

	    if (userVO != null) {
		if (userId != null) {
		    if (userId.compareTo(userVO.getId()) != 0) {
			logWarningMessage("Invalid User Name.");
			return null;
		    }
		}
		if (password != null) {
		    if (password.compareToIgnoreCase(userVO.getPassword()) != 0) {
			logWarningMessage("Invalid Password.");
			return null;
		    }
		}
	    } else {
		logWarningMessage("Invalid UserName/Password.");
		return null;
	    }
	}

	if (userId == null) {
	    logWarningMessage("Invalid User Name.");
	    return null;

	}
	if (password == null) {
	    logWarningMessage("Invalid Password.");
	    return null;

	}

	return NavigationConstants.welcomeScreen;
    }

}
