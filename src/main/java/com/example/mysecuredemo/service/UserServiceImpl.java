package com.example.mysecuredemo.service;

import com.example.mysecuredemo.entity.User;
import com.example.mysecuredemo.repo.UserRepository;
import com.example.mysecuredemo.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService , UserDetailsService {

    private UserRepository urepo;

    @Autowired
    public UserServiceImpl(UserRepository urepo){
        this.urepo = urepo;
    }

    @Override
    public User findByEmail(String email) {
        return urepo.findByEmail(email);
    }

    //load by email
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User u = urepo.findByEmail(s);
        System.out.println(s);
        System.out.println(u);
        if(u == null){
            throw  new  UsernameNotFoundException(s);
        }

        return new UserDetailsImpl(u);
    }
}
