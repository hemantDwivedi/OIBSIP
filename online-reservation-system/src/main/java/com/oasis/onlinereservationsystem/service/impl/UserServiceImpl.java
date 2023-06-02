package com.oasis.onlinereservationsystem.service.impl;

import com.oasis.onlinereservationsystem.dto.UserDto;
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
    private ModelMapper modelMapper;
    @Override
    public UserDto create(UserDto userDto) {
        User user = modelMapper.mapper().map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.mapper().map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public UserDto update(Integer id, UserDto userDto) {
        return null;
    }

    @Override
    public boolean isUsernameAndPasswordExist(String username, String password) {
        User user = userRepository.getByUsernameAndPassword(username, password);
        return user != null;
    }
}