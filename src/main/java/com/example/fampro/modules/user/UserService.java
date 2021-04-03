package com.example.fampro.modules.user;

import com.example.fampro.modules.user.request.CreateUser;
import com.example.fampro.modules.user.request.UpdateUser;
import com.example.fampro.utils.exception.UserAlreadyExistException;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User addUser(CreateUser user) throws UserAlreadyExistException;
    User updateUser(UpdateUser user, String email);
    void deleteUser(String email);
}
