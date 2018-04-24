package com.sapient.game.service;


import com.sapient.game.model.User;

import java.util.List;

/**
 * Created by Sourabh on 4/23/2018.
 */
public interface IUserService {

    User findById(int id);

    User findBySSO(String sso);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserBySSO(String sso);

    List<User> findAllUsers();

    boolean isUserSSOUnique(Integer id, String sso);
}
