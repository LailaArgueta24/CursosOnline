package com.example.cursos.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cursos.models.User;
import com.example.cursos.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public void createUser(User user) {
        // Aquí iría la lógica para crear un usuario, como validar datos, encriptar la contraseña, etc.

        userRepository.save(user);
    }
    public void updateUser(User user) {
        // Aquí iría la lógica para actualizar un usuario, como validar datos, encriptar la contraseña si se ha cambiado, etc.

        userRepository.update(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}

