/**
 * 
 */
package main.java.service;

import java.util.List;

import main.hibernate.hbm.UserVO;

/**
 * @author kakarlac
 *
 */
public interface IUserService {
    void insertUser(UserVO userVO);
    void updateUser(UserVO userVO);
    void deleteUser(UserVO userVO);
    UserVO getUserById(Integer id);
    List<UserVO> getUsers();
}
