package com.company.desoucheslautaro.service;

import com.company.desoucheslautaro.dto.DomicilioDTO;

import java.util.List;

public interface IDomicilioService {

    public DomicilioDTO guardar(DomicilioDTO domicilioDTO);
    public List<DomicilioDTO> buscarTodos();
    public DomicilioDTO buscarPorId(Long id);
    public DomicilioDTO actualizar(DomicilioDTO domicilioDTO);
    public void eliminarPorId(Long id);

}