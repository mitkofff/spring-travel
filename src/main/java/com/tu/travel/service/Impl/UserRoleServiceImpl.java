package com.tu.travel.service.Impl;

import com.tu.travel.model.entities.UserRoleEntity;
import com.tu.travel.model.entities.enums.UserRoleEnum;
import com.tu.travel.repository.UserRoleRepository;
import com.tu.travel.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initUserRoles() {
        if(userRoleRepository.count() == 0) {
            UserRoleEntity admin = new UserRoleEntity(UserRoleEnum.ADMIN);
            UserRoleEntity agent = new UserRoleEntity(UserRoleEnum.AGENT);
            UserRoleEntity client = new UserRoleEntity(UserRoleEnum.CLIENT);

            List<UserRoleEntity> roles = Arrays.asList(admin, agent, client);
            userRoleRepository.saveAll(roles);
        }
    }

    @Override
    public UserRoleEntity findRole(UserRoleEnum userRoleNameEnum) {
        return userRoleRepository
                .findByRole(userRoleNameEnum)
                .orElse(null);
    }
}
