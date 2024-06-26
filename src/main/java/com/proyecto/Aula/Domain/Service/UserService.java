package com.proyecto.Aula.Domain.Service;



import com.proyecto.Aula.Domain.Dto.RequestDTO;
import com.proyecto.Aula.Domain.Dto.UserDTO;
import com.proyecto.Aula.Domain.Mapper.RequestMapper;
import com.proyecto.Aula.Domain.Mapper.UserMapper;
import com.proyecto.Aula.Persistence.Entity.Request;
import com.proyecto.Aula.Persistence.Entity.User;
import com.proyecto.Aula.Persistence.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO save(UserDTO userDTO) {
        userRepository.save(UserMapper.toEntity(userDTO));
        userDTO.setId(userDTO.getId());
        return userDTO;
    }
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDto);
    }
    public void update(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        userRepository.save(user);
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

}
