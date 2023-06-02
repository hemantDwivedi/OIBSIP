package com.oasis.onlinereservationsystem.service;

import com.oasis.onlinereservationsystem.dto.UserDto;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto getUserById(Integer id);
    void deleteById(Integer id);
    UserDto update(Integer id, UserDto userDto);

    boolean isUsernameAndPasswordExist(String username, String password);
}
