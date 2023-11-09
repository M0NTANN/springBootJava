package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.repository.UserReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserReposotory userReposotory;

    @Autowired
    public UserService(UserReposotory userReposotory) {
        this.userReposotory = userReposotory;
    }

    public User findById(Long Id){


        return userReposotory.getOne(Id);
    }

    public List<User> findAll(){
        return userReposotory.findAll();
    }

    public User saveUser(User user){
        return userReposotory.save(user);
    }

    public void deleteById(Long Id){
        userReposotory.deleteById(Id);
    }
}
