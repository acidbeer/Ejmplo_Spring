package com.Ar.spring.ms.servicesImpl;

import com.Ar.spring.ms.models.entity.UserEntity;
import com.Ar.spring.ms.repositories.IUserRepository;
import com.Ar.spring.ms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserRepository iUserRepository;


    public UserEntity crearCliente(UserEntity cliente){
        logger.info("Inicial el servicio para crear usuario");

        return this.iUserRepository.save(cliente);

    }

    public ResponseEntity<List<UserEntity>> consultarClientes(){
        logger.info("Inicial el servicio para consultar clinetes");

        return ResponseEntity.ok(iUserRepository.findAll());
    }


    public ResponseEntity<Optional<UserEntity>> consultarClienteById(Long id){
        logger.info("Inicia el servicio para consulta de cliente por ID");

        return ResponseEntity.ok(iUserRepository.findById(id));
    }

    public ResponseEntity<UserEntity> modificarClienteById(UserEntity request, Long id){
        logger.info("Inicia el servicio para modificar cliente por ID");

        UserEntity clienteEnconrado=iUserRepository.findById(id).get();

        clienteEnconrado.setUsername(request.getUsername());
        clienteEnconrado.setPassword(request.getPassword());
        clienteEnconrado.setNombre(request.getNombre());
        clienteEnconrado.setCorreo(request.getCorreo());

        return ResponseEntity.ok(iUserRepository.save(clienteEnconrado));
    }

    public boolean eliminarClienteById(Long id){

        try {
            iUserRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
