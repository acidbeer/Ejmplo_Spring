package com.Ar.spring.ms.controllers;

import com.Ar.spring.ms.models.entity.UserEntity;
import com.Ar.spring.ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> saveClient(@RequestBody UserEntity cliente){

        return ResponseEntity.ok(userService.crearCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getClients(){

        return ResponseEntity.ok(userService.consultarClientes().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> getClietById(@PathVariable Long id){

        return  ResponseEntity.ok(userService.consultarClienteById(id)).getBody();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateClient(@RequestBody UserEntity cliente,
                                                   @PathVariable Long id){

        return ResponseEntity.ok(userService.modificarClienteById(cliente, id)).getBody();

    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id){

        boolean ok = userService.eliminarClienteById(id);

        if (ok){
            return "User with id "+ id + " deleted!";
        }else{
            return "Error, we have a problem and can´t delete user with id : "+id;
        }
    }

}


