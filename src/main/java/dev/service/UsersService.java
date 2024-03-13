package dev.service;

import dev.dao.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsersService {
    ResponseEntity<List<User>> getUsers();
    ResponseEntity<User> getUserById(Integer id);
    ResponseEntity<User> create(User user);
    ResponseEntity<Void> delete(Integer id);
    ResponseEntity<User> edit(Integer id, User user);
}
