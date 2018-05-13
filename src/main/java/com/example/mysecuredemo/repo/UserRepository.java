package com.example.mysecuredemo.repo;

import com.example.mysecuredemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//https://stackoverflow.com/questions/40382741/what-exactly-is-the-difference-between-jparepository-and-crudrepository-using-sp?rq=1
//crud vs jap repo

public interface UserRepository extends JpaRepository<User, Long> {
    //https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    //some default you can use, some crud by custom props need to add manual
    //find by name
    List<User> findByUsername(String name);


    //NonUniqueResultException
    //some time may find multiple with same email, may need to return Iterable
    //must keep the email unique
    User findByEmail(String email);

    //https://stackoverflow.com/questions/11881479/how-do-i-update-an-entity-using-spring-data-jpa?noredirect=1&lq=1
    //update
    //transactional need on the update/delete query
    @Transactional
    @Modifying//@Modifying(clearAutomatically = true)
    @Query("update User u set u.username = :newname where u.email = :email")
    int updateUserByEmail(@Param("email") String email,@Param("newname") String name);


    //https://stackoverflow.com/questions/31127309/spring-boot-hibernate-jpa-no-transactional-entitymanager-available
    @Transactional
    void deleteUserByEmail(String email);

    //exists not work please find find then try
}
