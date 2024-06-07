package com.proyecto.Aula.Domain.Service;


import com.proyecto.Aula.Controller.models.AuthResponse;
import com.proyecto.Aula.Controller.models.RegisterRequest;
import com.proyecto.Aula.Domain.Dto.RequestDTO;
import com.proyecto.Aula.Domain.Mapper.RequestMapper;
import com.proyecto.Aula.Persistence.Entity.Request;
import com.proyecto.Aula.Persistence.Entity.Role;
import com.proyecto.Aula.Persistence.Entity.User;
import com.proyecto.Aula.Persistence.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestServices {
@Autowired
    private RequestRepository requestRepository;

public RequestDTO save(RequestDTO requestDTO) {
    Request request = requestRepository.save(RequestMapper.toEntity(requestDTO));
    requestDTO.setIdRequest(request.getIdRequest());
    return requestDTO;
}

public List<RequestDTO> getAll() {
    return requestRepository.findAll().stream().map(RequestMapper::toDTO).collect(Collectors.toList());
}
    public Optional<RequestDTO> findById(Long id) {
        return requestRepository.findById(id).map(RequestMapper::toDTO);
    }
}
