package com.proyecto.Aula.Controller;

import com.proyecto.Aula.Domain.Dto.UserDTO;
import com.proyecto.Aula.Domain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/get")
    public List<UserDTO> get() {
        return userService.getAll();
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {
        Optional<UserDTO> userOptional = userService.findById(userDTO.getId());
        if(userOptional.isPresent()) {
            userService.save(userDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}


