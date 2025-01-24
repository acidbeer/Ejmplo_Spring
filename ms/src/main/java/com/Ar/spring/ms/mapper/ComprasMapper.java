package com.Ar.spring.ms.mapper;

import com.Ar.spring.ms.models.dto.CompraResponseDTO;
import com.Ar.spring.ms.models.entity.ComprasEntity;
import com.Ar.spring.ms.models.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ComprasMapper {

    @Mapping(target = "id", source = "compra.id") // Especificamos que el id proviene de ComprasEntity
    @Mapping(target = "productoNombre", source = "producto.nombre")
    @Mapping(target = "precioUnitario", source = "producto.precio")
    @Mapping(target = "precioTotal", expression = "java(compra.getCantidad() * producto.getPrecio())")
    @Mapping(target = "username", source = "compra.usuarioId.username")
    @Mapping(target = "userNombre", source = "compra.usuarioId.nombre")

    CompraResponseDTO toCompraResponseDTO(ComprasEntity compra, ProductoEntity producto);

}
