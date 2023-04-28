package com.company.desoucheslautaro.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OdontologoDTO implements Serializable {

    private Long id;
    private String apellido;
    private String nombre;
    private Long matricula;

}
