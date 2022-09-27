package com.github.julianomachadoo.junitmockitoapi.services.impl;

import com.github.julianomachadoo.junitmockitoapi.domain.User;
import com.github.julianomachadoo.junitmockitoapi.domain.dto.UserDTO;
import com.github.julianomachadoo.junitmockitoapi.repositories.UserRepository;
import com.github.julianomachadoo.junitmockitoapi.services.UserService;
import com.github.julianomachadoo.junitmockitoapi.services.exceptions.DataIntegrityViolationException;
import com.github.julianomachadoo.junitmockitoapi.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById (Integer id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll () {
        return repository.findAll();
    }

    @Override
    public User create (UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail (UserDTO obj) {
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
        }
    }

}
