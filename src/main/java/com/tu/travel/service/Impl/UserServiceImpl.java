package com.tu.travel.service.Impl;
import java.time.Instant;
import java.util.Arrays;

import com.tu.travel.model.entities.UserEntity;
import com.tu.travel.model.entities.enums.UserRoleEnum;
import com.tu.travel.model.services.UserServiceModel;
import com.tu.travel.repository.UserRepository;
import com.tu.travel.service.TokenService;
import com.tu.travel.service.UserRoleService;
import com.tu.travel.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
  //  private final TokenService tokenService;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           UserRoleService userRoleService,
                           ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        //this.tokenService = tokenService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userServiceModel.getPassword());
        userServiceModel.setPassword(encodedPassword);
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setUserRoles(Arrays.asList(userRoleService.findRole(UserRoleEnum.CLIENT)));
        //user.setCreated(Instant.now());
        //user.setUpdated(Instant.now());

        userRepository.save(user);
    }

    @Override
    public UserServiceModel findByEmailAndPassword(String email, String password) {
        UserServiceModel foundUser = userRepository
                .findByEmailAndPassword(email, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);

        return foundUser;
    }
}
