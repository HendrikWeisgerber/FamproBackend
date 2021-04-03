package com.example.fampro.modules.user;

import com.example.fampro.modules.user.request.CreateUser;
import com.example.fampro.modules.user.request.UpdateUser;
import com.example.fampro.utils.exception.UserAlreadyExistException;
import com.example.fampro.utils.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        List<User> allUser = userRepository.findAll();
        return allUser;
    }

    @Override
    public User addUser(CreateUser user) {
        User alreadyExist = userRepository.findByEmail(user.getEmail());
        if (alreadyExist!=null){
            throw new UserAlreadyExistException("A user with this email adress already Exists");
        }
        User saveUser = new User(user);
        userRepository.save(saveUser);
        return saveUser;
    }

    @Override
    public User updateUser(UpdateUser update, String email) {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UserNotFoundException("A User with this email adress couldnt be found");
        }
        if (update.getFirstName()!=null){
            user.setFirstName(update.getFirstName());
        }
        if (update.getLastName()!=null){
            user.setLastName(update.getLastName());
        }
        user = userRepository.save(user);

        return user;
    }

    @Override
    public void deleteUser(String email) {
        User user= userRepository.findByEmail(email);
        userRepository.delete(user);
    }
}
