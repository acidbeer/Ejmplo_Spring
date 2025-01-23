package com.Ar.spring.ms.service;

import com.Ar.spring.ms.models.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public UserEntity crearCliente(UserEntity cliente);


    public ResponseEntity<List<UserEntity>> consultarClientes();

    public ResponseEntity<Optional<UserEntity>> consultarClienteById(Long id);

    public ResponseEntity<UserEntity> modificarClienteById(UserEntity request, Long id);

    public boolean eliminarClienteById(Long id);
}

