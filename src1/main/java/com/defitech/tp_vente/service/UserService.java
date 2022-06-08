package com.defitech.tp_vente.service;

import com.defitech.tp_vente.modele.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
