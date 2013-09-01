/**
 * 
 */
package main.java.dao;

import java.util.List;

import main.hibernate.hbm.UserVO;

/**
 * @author kakarlac
 *
 */
public interface IUserDAO {

    void insertUser(UserVO userVO);

    void updateUser(UserVO userVO);

    void deleteUser(UserVO userVO);

    UserVO getUserById(Integer id);

    List<UserVO> getUsers();

}
