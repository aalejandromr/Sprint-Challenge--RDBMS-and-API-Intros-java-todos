package com.lambdaschool.javatodos.repository;

import com.lambdaschool.javatodos.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
