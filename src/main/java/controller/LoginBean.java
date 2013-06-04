/**
 * 
 */
package main.java.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     * @param userId the userId to set
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
    
    
    
    public String addUser(){
	ConversationUtils.getCurrentBean();
	return NavigationConstants.ADD_USER;
    }
    
    

    public String actionSubmit() {
	if(userId!=null && password !=null){
	UserVO userVO=getUserService().getUserById(userId);
	System.out.println("UserVO===============>"+userVO);
	
	if(userVO!=null){
	if(userId!=null){
	    if(userId.compareTo(userVO.getId())!=0){
		logWarningMessage("Invalid User Name.");
		return null;
	    }
	}
	if(password!=null){
	    if(password.compareToIgnoreCase(userVO.getPassword())!=0){
		logWarningMessage("Invalid Password.");
		 return null;
	    }
	}
	}else{
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
