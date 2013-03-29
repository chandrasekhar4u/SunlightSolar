/**
 * 
 */
package main.java.controller;

/**
 * @author CHANDRA
 * 
 */
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub

    }

    public String actionSubmit() {
	return NavigationConstants.welcomeScreen;
    }

}
