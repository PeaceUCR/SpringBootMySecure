package com.example.mysecuredemo.repo;

import com.example.mysecuredemo.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}

