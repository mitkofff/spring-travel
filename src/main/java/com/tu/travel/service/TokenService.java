package com.tu.travel.service;

import com.tu.travel.exception.GetDaysException;
import com.tu.travel.model.services.DayServiceModel;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface TokenService {
    public String generateToken(Authentication authentication);
}
