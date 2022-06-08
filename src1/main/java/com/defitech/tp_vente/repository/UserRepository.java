package com.defitech.tp_vente.repository;

import com.defitech.tp_vente.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}