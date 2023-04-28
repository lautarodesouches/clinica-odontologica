package com.company.desoucheslautaro.controller;

import com.company.desoucheslautaro.dto.PacienteDTO;
import com.company.desoucheslautaro.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    IPacienteService iPacienteService;

    @PostMapping("/")
    public ResponseEntity<PacienteDTO> guardar(@RequestBody PacienteDTO pacienteDTO){
        PacienteDTO pacienteDTOGuardado = iPacienteService.guardar(pacienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteDTOGuardado);
    }

    @GetMapping("/")
    public ResponseEntity<List<PacienteDTO>> buscarTodos(){
        List<PacienteDTO> lista = iPacienteService.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Long id){
        PacienteDTO pacienteDTOEncontrado = iPacienteService.buscarPorId(id);
        return ResponseEntity.ok(pacienteDTOEncontrado);
    }

    @PutMapping("/")
    public ResponseEntity<PacienteDTO> actualizar(@RequestBody PacienteDTO pacienteDTO){
        PacienteDTO pacienteDTOActualizado = iPacienteService.actualizar(pacienteDTO);
        return ResponseEntity.ok(pacienteDTOActualizado);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        iPacienteService.eliminarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}