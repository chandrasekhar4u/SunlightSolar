/**
 * 
 */
package main.java.service;

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
}
