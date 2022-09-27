package com.github.julianomachadoo.junitmockitoapi.resources;

import com.github.julianomachadoo.junitmockitoapi.domain.User;
import com.github.julianomachadoo.junitmockitoapi.domain.dto.UserDTO;
import com.github.julianomachadoo.junitmockitoapi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok()
                .body(service.findAll()
                                .stream()
                                .map( x -> mapper.map(x, UserDTO.class))
                                    .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create (@RequestBody UserDTO user) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(service.create(user).getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update (@PathVariable Integer id,
                                           @RequestBody UserDTO obj) {
        obj.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(obj), UserDTO.class));
    }
}
