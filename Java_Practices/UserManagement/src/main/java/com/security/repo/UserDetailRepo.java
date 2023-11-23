package com.security.repo;

import com.security.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailRepo extends JpaRepository<UserDetail,Long> {
}
