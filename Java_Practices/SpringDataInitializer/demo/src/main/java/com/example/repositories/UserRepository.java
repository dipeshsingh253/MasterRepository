package com.example.repositories;

import com.example.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    // basic select queries

//    @Query("SELECT u FROM User u")
//    List<User> findAllUserUsingJPQL();
//
//    @Query(
//            value = "SELECT * FROM users u",
//            nativeQuery = true
//    )
//    List<User> findAllUserUsingNative();
//
//
//    // pagination in queries
//
//    @Query(value = "SELECT u FROM User u ORDER BY id")
//    Page<User> findAllUsersWithPagination(Pageable pageable);


}


