package com.company.desoucheslautaro.service.impl;

import com.company.desoucheslautaro.dto.DomicilioDTO;
import com.company.desoucheslautaro.entity.Domicilio;
import com.company.desoucheslautaro.entity.Odontologo;
import com.company.desoucheslautaro.repository.DomicilioRepository;
import com.company.desoucheslautaro.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Domicilio convertirDtoADomicilio(DomicilioDTO domicilioDTO){
        return objectMapper.convertValue(domicilioDTO, Domicilio.class);
    }

    public DomicilioDTO convertirDomicilioADTO(Domicilio domicilio){
        return objectMapper.convertValue(domicilio, DomicilioDTO.class);
    }

    @Override
    public DomicilioDTO guardar(DomicilioDTO domicilioDTO) {
        Domicilio domicilioGuardado = domicilioRepository.save(convertirDtoADomicilio(domicilioDTO));
        return convertirDomicilioADTO(domicilioGuardado);
    }

    @Override
    public List<DomicilioDTO> buscarTodos() {

        List<Domicilio> domicilios = domicilioRepository.findAll();
        List<DomicilioDTO> domicilioDTOS = new ArrayList<>();

        for (Domicilio domicilio: domicilios) {
            domicilioDTOS.add(
                    convertirDomicilioADTO(domicilio)
            );
        }

        return domicilioDTOS;

    }

    @Override
    public DomicilioDTO buscarPorId(Long id){
        return convertirDomicilioADTO(
                domicilioRepository.findById(id).get()
        );
    }

    @Override
    public DomicilioDTO actualizar(DomicilioDTO domicilioDTO) {
        eliminarPorId(domicilioDTO.getId());
        return guardar(domicilioDTO);
    }

    @Override
    public void eliminarPorId(Long id) {
        domicilioRepository.deleteById(id);
    }

}