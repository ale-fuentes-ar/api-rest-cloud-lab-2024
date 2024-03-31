package edu.alejandro.service;

import edu.alejandro.domain.model.User;

public interface UserService {

    User findById(Long id);
    User create(User userToCreate);
}
