package com.company.desoucheslautaro.service;

import com.company.desoucheslautaro.dto.PacienteDTO;

import java.util.List;

public interface IPacienteService {

    public PacienteDTO guardar(PacienteDTO pacienteDTO);
    public List<PacienteDTO> buscarTodos();
    public PacienteDTO buscarPorId(Long id);
    public PacienteDTO actualizar(PacienteDTO pacienteDTO);
    public void eliminarPorId(Long id);

}
