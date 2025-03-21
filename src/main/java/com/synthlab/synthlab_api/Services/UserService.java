package com.synthlab.synthlab_api.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.synthlab.synthlab_api.Entities.User;
import com.synthlab.synthlab_api.Repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);

        user.setNombre(userDetails.getNombre());
        user.setApellidoPaterno(userDetails.getApellidoPaterno());
        user.setApellidoMaterno(userDetails.getApellidoMaterno());
        user.setCorreo(userDetails.getCorreo());
        user.setPassword(userDetails.getPassword());
        user.setFechaNacimiento(userDetails.getFechaNacimiento());
        user.setCreatedAt(userDetails.getCreatedAt());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
