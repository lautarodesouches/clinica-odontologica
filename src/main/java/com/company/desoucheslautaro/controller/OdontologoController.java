package com.company.desoucheslautaro.controller;

import com.company.desoucheslautaro.dto.OdontologoDTO;
import com.company.desoucheslautaro.exception.BadRequestException;
import com.company.desoucheslautaro.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/odontologos")
@CrossOrigin(origins = "*")
public class OdontologoController {

    @Autowired
    IOdontologoService iOdontologoService;

    @PostMapping("/")
    public ResponseEntity<?> guardar(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        OdontologoDTO odontologoDTOGuardado = iOdontologoService.guardar(odontologoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(odontologoDTOGuardado);
    }

    @GetMapping("/")
    public ResponseEntity<List<OdontologoDTO>> buscarTodos(){
        List<OdontologoDTO> lista = iOdontologoService.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<OdontologoDTO> buscarPorId(@PathVariable Long id) throws BadRequestException {
        OdontologoDTO odontologoDTOEncontrado = iOdontologoService.buscarPorId(id);
        return ResponseEntity.ok(odontologoDTOEncontrado);
    }

    @GetMapping("/matricula/{id}/")
    public ResponseEntity<OdontologoDTO> buscarPorMatricula(@PathVariable Long id) throws BadRequestException {
        OdontologoDTO odontologoDTOEncontrado = iOdontologoService.buscarPorMatricula(id);
        return ResponseEntity.ok(odontologoDTOEncontrado);
    }

    @PutMapping("/")
    public ResponseEntity<?> actualizar(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        OdontologoDTO odontologoActualizado = iOdontologoService.actualizar(odontologoDTO);
        return ResponseEntity.ok(odontologoActualizado);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        iOdontologoService.eliminarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}