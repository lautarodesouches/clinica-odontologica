package com.company.desoucheslautaro.service;

import com.company.desoucheslautaro.dto.TurnoDTO;

import java.util.List;

public interface ITurnoService {

    public TurnoDTO guardar(TurnoDTO turnoDTO);
    public List<TurnoDTO> buscarTodos();
    public TurnoDTO buscarPorId(Long id);
    public TurnoDTO actualizar(TurnoDTO turnoDTO);
    public void eliminarPorId(Long id);

}
