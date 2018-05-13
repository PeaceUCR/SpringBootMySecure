package com.example.mysecuredemo.init;

import com.example.mysecuredemo.entity.Role;
import com.example.mysecuredemo.entity.User;
import com.example.mysecuredemo.repo.RoleRepository;
import com.example.mysecuredemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Iterator;

//add some data to init
//no @Component, this will not call
@Component
public class appInit implements ApplicationListener<ContextRefreshedEvent> {

    private BCryptPasswordEncoder pe;
    private UserRepository urepo;
    private RoleRepository rrepo;

    @Autowired
    public void setRrepo(RoleRepository rrepo) {
        this.rrepo = rrepo;
    }
    @Autowired
    public void setPe(BCryptPasswordEncoder pe) {

        this.pe = pe;
    }
    @Autowired
    public void setUrepo(UserRepository urepo) {
        this.urepo = urepo;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Role role = new Role();
        role.setRole("USER");
        rrepo.save(role);
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        rrepo.save(adminRole);



        User user1 = new User();
        user1.setUsername("user1");
        user1.setUserEmail("user1@cdk.com");
        user1.setPassword("user1");
        user1.setEncryptedPassword(pe.encode("user1"));
        user1.addRole(role);
        urepo.save(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setUserEmail("user2@cdk.com");
        user2.setPassword("user2");
        user2.setEncryptedPassword(pe.encode("user2"));
        user2.addRole(role);
        urepo.save(user2);

        User user3 = new User();
        user3.setUsername("user3");
        user3.setUserEmail("user1@cdk.com");
        user3.setPassword("user1");
        user3.addRole(adminRole);
        urepo.save(user3);


        User user4 = new User();
        user4.setUsername("user4");
        user4.setUserEmail("user4@cdk.com");
        user4.setPassword("user4");
        user4.addRole(adminRole);
        urepo.save(user4);
        /*
        Iterator<User> list= urepo.findAll().iterator();
        while(list.hasNext()){
            System.out.println(list.next());
        }



        list= urepo.findByEmail("user1@cdk.com").iterator();
        while(list.hasNext()){
            System.out.println(list.next());
        }
        */
        //System.out.println(urepo.findByEmail("user1"));

        urepo.updateUserByEmail("user1@cdk.com", "userupdated");


        urepo.deleteUserByEmail("user1@cdk.com");
    }
}
