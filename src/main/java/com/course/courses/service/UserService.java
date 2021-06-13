package com.course.courses.service;

import com.course.courses.model.User;
import com.course.courses.model.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

    void update(User user);

    boolean changePassword(User currentUser, String oldPassword, String newPassword);

    List<User> getAll();

    User findById(long id);

    void deleteById(long id);
}
