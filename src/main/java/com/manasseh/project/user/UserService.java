package com.manasseh.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired UserRepository userRepository;

    public List<User> listAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User getOneUserById(Integer id) throws UserNotFoundException {
        Optional<User> userId = userRepository.findById(id);
        if (userId.isPresent()){
            return userId.get();
        }
        throw  new UserNotFoundException("user not found");
    }

    public void deleteUserById(Integer id){
        userRepository.deleteById(id);
    }
}
