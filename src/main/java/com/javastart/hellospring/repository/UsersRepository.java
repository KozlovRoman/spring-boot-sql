package com.javastart.hellospring.repository;

import com.javastart.hellospring.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByName(String name); // just a true name of method gives the opportunity
    // to avoid SQL query

    @Query("SELECT u FROM Users u WHERE u.email LIKE '%@gmail.com%'") // if it's not enough, we can write
        // our own query on the same language comparing SQL
    List<Users> findWhereEmailIsGmail();

    @Query(value = "SELECT * FROM users WHERE name LIKE '%roman%'", nativeQuery = true)
        // if it's not enough - we can write SQL query, and everything will work
    List<Users> findWhereNameStartsFromRoman();
}
