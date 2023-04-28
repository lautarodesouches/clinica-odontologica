package com.company.desoucheslautaro.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Turnos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Turno implements Serializable {

    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;
    @ManyToOne(targetEntity = Odontologo.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
    @ManyToOne(targetEntity = Paciente.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @Column
    private LocalDate fecha;

}
