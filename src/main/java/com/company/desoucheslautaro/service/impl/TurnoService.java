package com.company.desoucheslautaro.service.impl;

import com.company.desoucheslautaro.dto.TurnoDTO;
import com.company.desoucheslautaro.entity.Turno;
import com.company.desoucheslautaro.repository.TurnoRepository;
import com.company.desoucheslautaro.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Turno convertirDtoATurno(TurnoDTO turnoDTO){
        return objectMapper.convertValue(turnoDTO, Turno.class);
    }

    public TurnoDTO convertirTurnoADto(Turno turno){
        return objectMapper.convertValue(turno, TurnoDTO.class);
    }

    @Override
    public TurnoDTO guardar(TurnoDTO turnoDTO) {
        Turno turnoGuardado = turnoRepository.save(convertirDtoATurno(turnoDTO));
        return convertirTurnoADto(turnoGuardado);
    }

    @Override
    public List<TurnoDTO> buscarTodos() {

        List<Turno> turnos = turnoRepository.findAll();
        List<TurnoDTO> turnoDTOS = new ArrayList<>();

        for (Turno turno: turnos) {
            turnoDTOS.add(
                    convertirTurnoADto(turno)
            );
        }

        return turnoDTOS;

    }

    @Override
    public TurnoDTO buscarPorId(Long id){
        return convertirTurnoADto(
                turnoRepository.findById(id).get()
        );
    }

    @Override
    public TurnoDTO actualizar(TurnoDTO turnoDTO) {
        eliminarPorId(turnoDTO.getId());
        return guardar(turnoDTO);
    }

    @Override
    public void eliminarPorId(Long id) {
        turnoRepository.deleteById(id);
    }
    
}
