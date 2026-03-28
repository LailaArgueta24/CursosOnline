package com.example.cursos.repositories;
import java.util.List;

import com.example.cursos.models.User;
public interface UserRepository {
    User save(User user);
    List<User> findAll();
    User findById(Long id);
    User update(User user);
    void deleteById(Long id);
}
