package com.example.familia_api.controladores;

import com.example.familia_api.modelos.VinculoFamiliarEstudiante;
import com.example.familia_api.modelos.dto.VinculoDetalleDTO;
import com.example.familia_api.modelos.dto.VinculoFamiliarEstudianteDTO;
import com.example.familia_api.servicios.VinculoServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vinculos")
public class VinculoControlador {

    private final VinculoServicio vinculoServicio;

    public VinculoControlador(VinculoServicio vinculoServicio) {
        this.vinculoServicio = vinculoServicio;
    }

    @PostMapping
    public ResponseEntity<VinculoFamiliarEstudiante> crearVinculo(@Valid @RequestBody VinculoFamiliarEstudianteDTO vinculoDTO) {
        try {
            VinculoFamiliarEstudiante nuevoVinculo = vinculoServicio.crearVinculo(vinculoDTO);
            return new ResponseEntity<>(nuevoVinculo, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<VinculoFamiliarEstudiante>> verVinculosPorEstudiante(@PathVariable Long id) {
        try {
            List<VinculoFamiliarEstudiante> vinculos = vinculoServicio.verVinculosPorEstudiante(id);
            return ResponseEntity.ok(vinculos);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVinculo(@PathVariable Long id) {
        try {
            vinculoServicio.eliminarVinculo(id);
            java.util.Map<String, String> response = new java.util.HashMap<>();
            response.put("mensaje", "Vínculo eliminado exitosamente.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<VinculoDetalleDTO>> listarTodos() {
        try {
            return ResponseEntity.ok(vinculoServicio.listarTodosLosVinculos());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}