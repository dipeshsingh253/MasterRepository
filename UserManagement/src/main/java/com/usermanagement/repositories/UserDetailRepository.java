package com.usermanagement.repositories;

import com.usermanagement.models.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,Integer> {
}
