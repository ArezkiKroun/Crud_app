package com.codecrud.crud.repository;

import com.codecrud.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
//JpaRepositiry contient toutes les méthodes pour évualuer