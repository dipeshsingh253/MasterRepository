package com.usermanagement.services.impls;

import com.usermanagement.models.UserDetail;
import com.usermanagement.repositories.UserDetailRepository;
import com.usermanagement.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public void saveUserDetails(UserDetail userDetail) {

        userDetailRepository.save(userDetail);

    }

    @Override
    public UserDetail getUserDetailsById(Integer id) {
        return userDetailRepository.findById(id).orElseThrow();
    }
}
