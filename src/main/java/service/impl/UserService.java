/**
 * 
 */
package main.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.hibernate.hbm.UserVO;
import main.java.dao.IUserDAO;
import main.java.service.IUserService;

/**
 * @author kakarlac
 *
 */
public class UserService extends BaseService implements IUserService  {
    
    private IUserDAO userDAO;

    @Override
    public void insertUser(UserVO userVO) {
	userDAO.insertUser(userVO);	
    }

    /**
     * @param userDAO the userDAO to set
     */
    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void updateUser(UserVO userVO) {
	userDAO.updateUser(userVO);
	
    }

    @Override
    public void deleteUser(UserVO userVO) {
	userDAO.deleteUser(userVO);
	
    }

    @Override
    public UserVO getUserById(Integer id) {
	return userDAO.getUserById(id);	
    }

    @Override
    public List<UserVO> getUsers() {
	// TODO Auto-generated method stub
	return userDAO.getUsers();
    }

}
