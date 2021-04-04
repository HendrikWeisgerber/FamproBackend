package com.example.fampro.modules.user;

import com.example.fampro.modules.user.request.CreateUser;
import com.example.fampro.modules.user.request.UpdateUser;
import com.example.fampro.utils.exception.UserAlreadyExistException;
import com.example.fampro.utils.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User addUser(CreateUser user) throws UserAlreadyExistException;
    User updateUser(UpdateUser user, String email) throws UserNotFoundException;
    void deleteUser(String email) throws UserNotFoundException;

}
