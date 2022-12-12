package com.tu.travel.service;

import com.tu.travel.model.entities.UserRoleEntity;
import com.tu.travel.model.entities.enums.UserRoleEnum;

import java.util.List;

public interface UserRoleService {
    void initUserRoles();

    UserRoleEntity findRole(UserRoleEnum roleEnum);
}
