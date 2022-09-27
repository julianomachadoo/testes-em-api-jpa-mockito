package com.github.julianomachadoo.junitmockitoapi.resources;

import com.github.julianomachadoo.junitmockitoapi.domain.User;
import com.github.julianomachadoo.junitmockitoapi.domain.dto.UserDTO;
import com.github.julianomachadoo.junitmockitoapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {

        return ResponseEntity.ok().body(
                mapper.map(service.findById(id), UserDTO.class)
        );
    }
}
