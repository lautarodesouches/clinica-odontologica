package com.company.desoucheslautaro.service;

import com.company.desoucheslautaro.dto.OdontologoDTO;
import com.company.desoucheslautaro.exception.BadRequestException;

import java.util.List;

public interface IOdontologoService {

    public OdontologoDTO guardar(OdontologoDTO odontologoDTO) throws BadRequestException;
    public List<OdontologoDTO> buscarTodos();
    public OdontologoDTO buscarPorId(Long id) throws BadRequestException;
    public OdontologoDTO actualizar(OdontologoDTO odontologoDTO) throws BadRequestException;
    public void eliminarPorId(Long id);
    public OdontologoDTO buscarPorMatricula(Long matricula) throws BadRequestException;

}
