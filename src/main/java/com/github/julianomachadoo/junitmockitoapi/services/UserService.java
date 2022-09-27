package com.github.julianomachadoo.junitmockitoapi.services;

import com.github.julianomachadoo.junitmockitoapi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
