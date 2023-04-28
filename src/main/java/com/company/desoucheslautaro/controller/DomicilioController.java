package com.company.desoucheslautaro.controller;

import com.company.desoucheslautaro.dto.DomicilioDTO;
import com.company.desoucheslautaro.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/domicilios")
@CrossOrigin(origins = "*")
public class DomicilioController {

    @Autowired
    IDomicilioService iDomicilioService;

    @PostMapping("/")
    public ResponseEntity<DomicilioDTO> guardar(@RequestBody DomicilioDTO domicilioDTO){
        DomicilioDTO domicilioDTOGuardado = iDomicilioService.guardar(domicilioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(domicilioDTOGuardado);
    }

    @GetMapping("/")
    public ResponseEntity<List<DomicilioDTO>> buscarTodos(){
        List<DomicilioDTO> lista = iDomicilioService.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<DomicilioDTO> buscarPorId(@PathVariable Long id){
        DomicilioDTO domicilioDTOEncontrado = iDomicilioService.buscarPorId(id);
        return ResponseEntity.ok(domicilioDTOEncontrado);
    }

    @PutMapping("/")
    public ResponseEntity<DomicilioDTO> actualizar(@RequestBody DomicilioDTO domicilioDTO){
        DomicilioDTO domicilioDTOActualizado = iDomicilioService.actualizar(domicilioDTO);
        return ResponseEntity.ok(domicilioDTOActualizado);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        iDomicilioService.eliminarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}