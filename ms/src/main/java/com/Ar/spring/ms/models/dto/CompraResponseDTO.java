package com.Ar.spring.ms.models.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompraResponseDTO  {

    private Long id;
    private int cantidad;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaCompra;

    private String productoNombre;
    private Double precioUnitario;
    private Double precioTotal;

    private String username;
    private String userNombre;

}
