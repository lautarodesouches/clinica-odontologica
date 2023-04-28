package com.company.desoucheslautaro.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DomicilioDTO implements Serializable {

    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

}