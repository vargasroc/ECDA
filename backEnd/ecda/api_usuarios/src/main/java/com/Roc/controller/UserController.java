package com.Roc.controller;

import com.Roc.repository.UserRepository;
import com.Roc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Validar los datos recibidos
        if (user.getName() == null || user.getEmail() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest().build(); // Datos incompletos, devuelve una respuesta de error
        }

        // Crear una nueva instancia de la clase User con los datos recibidos
        User newUser = new User(user.getName(), user.getEmail(), user.getPassword());

        // Guardar el usuario utilizando el repositorio UserRepository
        User savedUser = userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser); // Devuelve una respuesta exitosa con el usuario registrado
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // Buscar el usuario por su ID en la base de datos utilizando el repositorio UserRepository
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build(); // El usuario no fue encontrado, devuelve una respuesta de error
        }

        return ResponseEntity.ok(user); // Devuelve una respuesta exitosa con el usuario encontrado
    }

    // Implementar otros métodos según tus necesidades

    // Por ejemplo, un método para actualizar los datos de un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        // Buscar el usuario por su ID en la base de datos utilizando el repositorio UserRepository
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return ResponseEntity.notFound().build(); // El usuario no fue encontrado, devuelve una respuesta de error
        }

        // Actualizar los datos del usuario con los nuevos datos recibidos
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

        // Guardar los cambios en el repositorio UserRepository
        User savedUser = userRepository.save(user);

        return ResponseEntity.ok(savedUser); // Devuelve una respuesta exitosa con el usuario actualizado
    }
}
