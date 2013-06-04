/**
 * 
 */
package main.java.controller;

import main.hibernate.hbm.UserVO;

import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.viewController.annotations.ViewController;

/**
 * @author kakarlac
 *
 */
@ViewController(viewIds = { "/screens/addUser.xhtml" })
public class UserController extends BaseController {
    
    private UserVO userVO=new UserVO();
    
    
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
    
    @Override
    public void onCreateView() {
        // TODO Auto-generated method stub
        super.onCreateView();
    }
    
    public String submitUser(){
	getUserService().insertUser(getUserVO());
	return NavigationConstants.VIEW_USER;
    }
    

}
