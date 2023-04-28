package com.company.desoucheslautaro.controller;

import com.company.desoucheslautaro.dto.TurnoDTO;
import com.company.desoucheslautaro.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/turnos")
@CrossOrigin(origins = "*")
public class TurnoController {

    @Autowired
    ITurnoService iTurnoService;

    @PostMapping("/")
    public ResponseEntity<TurnoDTO> guardar(@RequestBody TurnoDTO turnoDTO){
        TurnoDTO turnoDTOGuardado = iTurnoService.guardar(turnoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoDTOGuardado);
    }

    @GetMapping("/")
    public ResponseEntity<List<TurnoDTO>> buscarTodos(){
        List<TurnoDTO> lista = iTurnoService.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}/")
    public ResponseEntity<TurnoDTO> buscarPorId(@PathVariable Long id){
        TurnoDTO turnoDTOEncontrado = iTurnoService.buscarPorId(id);
        return ResponseEntity.ok(turnoDTOEncontrado);
    }

    @PutMapping("/")
    public ResponseEntity<TurnoDTO> actualizar(@RequestBody TurnoDTO turnoDTO){
        TurnoDTO turnoDTOActualizado = iTurnoService.actualizar(turnoDTO);
        return ResponseEntity.ok(turnoDTOActualizado);
    }

    @DeleteMapping("/{id}/")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id){
        iTurnoService.eliminarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
}