package com.proyecto.Aula.Controller;


import com.proyecto.Aula.Controller.models.AuthResponse;
import com.proyecto.Aula.Controller.models.RegisterRequest;
import com.proyecto.Aula.Domain.Dto.RequestDTO;
import com.proyecto.Aula.Domain.Service.AuthService;
import com.proyecto.Aula.Domain.Service.RequestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/request")
public class RequestController {
    @Autowired
    private RequestServices requestServices;

    @PostMapping("/save")
    public RequestDTO save(@RequestBody RequestDTO requestDTO){
        return requestServices.save(requestDTO);
    }

    @GetMapping("/get")
    public List<RequestDTO> get(){return requestServices.getAll();}

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RequestDTO requestDTO) {
        if(requestServices.existsById(id)) {
            requestDTO.setIdRequest(id);
            requestServices.update(requestDTO);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
