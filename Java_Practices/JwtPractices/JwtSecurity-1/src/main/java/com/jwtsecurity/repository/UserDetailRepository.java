package com.jwtsecurity.repository;

import com.jwtsecurity.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,Integer> {

}
