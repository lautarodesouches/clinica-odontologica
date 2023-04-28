package com.company.desoucheslautaro.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PacienteDTO implements Serializable {

    private Long id;
    private String apellido;
    private String nombre;
    private String email;
    private Integer dni;
    private LocalDate fechaIngreso;

}
