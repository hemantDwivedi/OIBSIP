package com.oasis.onlinereservationsystem.service.impl;

import com.oasis.onlinereservationsystem.mapper.ModelMapper;
import com.oasis.onlinereservationsystem.model.User;
import com.oasis.onlinereservationsystem.repository.UserRepository;
import com.oasis.onlinereservationsystem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
   private UserRepository userRepository;
    @Override
    public boolean isUsernameAndPasswordExist(String username, String password) {
        User user = userRepository.getByUsernameAndPassword(username, password);
        return user != null;
    }
}