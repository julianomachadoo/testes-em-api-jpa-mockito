package com.github.julianomachadoo.junitmockitoapi.repositories;

import com.github.julianomachadoo.junitmockitoapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
