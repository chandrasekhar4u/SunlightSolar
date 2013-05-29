/**
 * 
 */
package main.java.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import main.hibernate.hbm.UserVO;
import main.java.dao.IUserDAO;

/**
 * @author kakarlac
 *
 */
public class UserDAO extends BaseDAO implements IUserDAO {
    
    private SessionFactory sessionFactory;

    @Override
    public void insertUser(UserVO userVO) {
	// TODO Auto-generated method stub
	
	sessionFactory.getCurrentSession().save(userVO);
	System.out.println("UserId is::::::::::::::::>"+userVO.getId());
	
    }

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void updateUser(UserVO userVO) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().update(userVO);
    }

    @Override
    public void deleteUser(UserVO userVO) {
	// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().delete(userVO);
    }

    @Override
    public UserVO getUserById(Integer id) {
	// TODO Auto-generated method stub
	UserVO vo=(UserVO) sessionFactory.getCurrentSession().get(UserVO.class, id);
	return vo;
    }

}
