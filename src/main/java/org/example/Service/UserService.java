package org.example.Service;



import org.example.Model.User;
import org.example.Model.UserForms;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User userForms){
        User user = new User();
        user.setEmail(userForms.getEmail());
        user.setPassword(userForms.getPassword());
        user.setUsername(userForms.getUsername());
        return userRepository.save(user);
    }

    public Boolean existByEmail(String email){
        Optional<User> userObj = Optional.ofNullable(userRepository.getUserByEmail(email));
        if(!userObj.isEmpty())
            return true;
        return false;
    }

}
