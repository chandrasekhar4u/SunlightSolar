/**
 * 
 */
package main.java.dao.impl;

import java.util.List;

import main.hibernate.hbm.UserVO;
import main.java.dao.IUserDAO;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<UserVO> getUsers() {
	// TODO Auto-generated method stub
	return (List<UserVO>)sessionFactory.getCurrentSession().createQuery("FROM main.hibernate.hbm.UserVO").list();
    }

}
