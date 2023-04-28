package com.company.desoucheslautaro.dto;

import com.company.desoucheslautaro.entity.Odontologo;
import com.company.desoucheslautaro.entity.Paciente;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TurnoDTO implements Serializable {

    private Long id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDate fecha;

}
