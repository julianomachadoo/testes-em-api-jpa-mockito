package com.github.julianomachadoo.junitmockitoapi.services;

import com.github.julianomachadoo.junitmockitoapi.domain.User;

public interface UserService {

    User findById(Integer id);
}
