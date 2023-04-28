package com.company.desoucheslautaro.service.impl;

import com.company.desoucheslautaro.dto.OdontologoDTO;
import com.company.desoucheslautaro.entity.Odontologo;
import com.company.desoucheslautaro.exception.BadRequestException;
import com.company.desoucheslautaro.repository.OdontologoRepository;
import com.company.desoucheslautaro.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Odontologo convertirDtoAOdontologo(OdontologoDTO odontologoDTO){
        return objectMapper.convertValue(odontologoDTO, Odontologo.class);
    }

    public OdontologoDTO convertirOdontologoADto(Odontologo odontologo){
        return objectMapper.convertValue(odontologo, OdontologoDTO.class);
    }

    @Override
    public OdontologoDTO guardar(OdontologoDTO odontologoDTO) throws BadRequestException {

        Optional<Odontologo> odontologoEncontrado = odontologoRepository.buscarPorMatricula(odontologoDTO.getMatricula());

        if(odontologoEncontrado.isPresent()){
            if(!odontologoEncontrado.get().getId().equals(odontologoDTO.getId())) throw new BadRequestException("Matricula ya existente");
        }

        Odontologo odontologoGuardado = odontologoRepository.save(convertirDtoAOdontologo(odontologoDTO));
        return convertirOdontologoADto(odontologoGuardado);
    }

    @Override
    public List<OdontologoDTO> buscarTodos() {

        List<Odontologo> odontologos = odontologoRepository.findAll();
        List<OdontologoDTO> odontologosDTOS = new ArrayList<>();

        for (Odontologo odontologo: odontologos) {
            odontologosDTOS.add(
                    convertirOdontologoADto(odontologo)
            );
        }

        return odontologosDTOS;

    }

    @Override
    public OdontologoDTO buscarPorId(Long id) throws BadRequestException {

        Optional<Odontologo> odontologo = odontologoRepository.findById(id);

        if (odontologo.isEmpty()) throw new BadRequestException("No se encontro un odontologo con el id " + id);

        return convertirOdontologoADto(odontologo.get());

    }

    @Override
    public OdontologoDTO actualizar(OdontologoDTO odontologoDTO) throws BadRequestException {
        return guardar(odontologoDTO);
    }

    @Override
    public void eliminarPorId(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public OdontologoDTO buscarPorMatricula(Long matricula) throws BadRequestException {

        Optional<Odontologo> odontologo = odontologoRepository.buscarPorMatricula(matricula);

        if (odontologo.isEmpty()) throw new BadRequestException("No se encontro un odontologo con la matricula " + matricula);

        return convertirOdontologoADto(odontologo.get());

    }
}
