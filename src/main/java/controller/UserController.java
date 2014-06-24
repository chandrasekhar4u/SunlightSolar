/**
 * 
 */
package main.java.controller;

import java.util.List;

import main.hibernate.hbm.UserVO;

import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.viewController.annotations.ViewController;

/**
 * @author kakarlac
 *
 */
@ViewController(viewIds = { "/screens/addUser.xhtml" })
public class UserController extends BaseController {
    
    private static final String BEAN_NAME = "userBean";
    
    private UserVO userVO=new UserVO();
    
    private List<UserVO> userList;
    
    
    /**
     * @return the userVO
     */
    public UserVO getUserVO() {
        return userVO;
    }

    /**
     * @param userVO the userVO to set
     */
    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    @Override
    public void onCreateBean(ConversationBindingEvent ar0) {
        // TODO Auto-generated method stub
        super.onCreateBean(ar0);
    }
    
    /**
     * This is a helper method which is used to get 
     * a handle on the current instance of a bean. 
     * It’s primary use is for passing data from one bean to another 
     * @return UserController
     */
    public static UserController getCurrentInstance() {
        return getBeanInstance( BEAN_NAME );
    }
    
    @Override
    public void onCreateView() {
        // TODO Auto-generated method stub
        super.onCreateView();
    }
    
    public String submitUser(){
	getUserService().insertUser(getUserVO());
	return NavigationConstants.VIEW_USER;
    }
    
    public List<UserVO> getUserList() {
        return userList;
    }

    public void setUserList(List<UserVO> userList) {
        this.userList = userList;
    }

    public String showUsers(){
	setUserList(getUserService().getUsers());
	return NavigationConstants.SHOW_USER;
    }
    

}
