package com.company.desoucheslautaro.service.impl;

import com.company.desoucheslautaro.dto.PacienteDTO;
import com.company.desoucheslautaro.entity.Paciente;
import com.company.desoucheslautaro.repository.PacienteRepository;
import com.company.desoucheslautaro.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Paciente convertirDtoAPaciente(PacienteDTO pacienteDTO){
        return objectMapper.convertValue(pacienteDTO, Paciente.class);
    }

    public PacienteDTO convertirPacienteADto(Paciente domicilio){
        return objectMapper.convertValue(domicilio, PacienteDTO.class);
    }

    @Override
    public PacienteDTO guardar(PacienteDTO pacienteDTO) {
        Paciente pacienteGuardado = pacienteRepository.save(convertirDtoAPaciente(pacienteDTO));
        return convertirPacienteADto(pacienteGuardado);
    }

    @Override
    public List<PacienteDTO> buscarTodos() {

        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDTO> pacienteDTOS = new ArrayList<>();

        for (Paciente domicilio: pacientes) {
            pacienteDTOS.add(
                    convertirPacienteADto(domicilio)
            );
        }

        return pacienteDTOS;

    }

    @Override
    public PacienteDTO buscarPorId(Long id){
        return convertirPacienteADto(
                pacienteRepository.findById(id).get()
        );
    }

    @Override
    public PacienteDTO actualizar(PacienteDTO pacienteDTO) {
        eliminarPorId(pacienteDTO.getId());
        return guardar(pacienteDTO);
    }

    @Override
    public void eliminarPorId(Long id) {
        pacienteRepository.deleteById(id);
    }

}
