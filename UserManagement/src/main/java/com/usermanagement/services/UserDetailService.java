package com.usermanagement.services;

import com.usermanagement.models.UserDetail;

public interface UserDetailService {

    void saveUserDetails(UserDetail userDetail);

    UserDetail getUserDetailsById(Integer id);

}
