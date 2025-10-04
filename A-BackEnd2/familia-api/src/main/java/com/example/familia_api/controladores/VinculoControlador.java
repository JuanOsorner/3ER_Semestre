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
        VinculoFamiliarEstudiante nuevoVinculo = vinculoServicio.crearVinculo(vinculoDTO);
        return new ResponseEntity<>(nuevoVinculo, HttpStatus.CREATED);
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<List<VinculoFamiliarEstudiante>> verVinculosPorEstudiante(@PathVariable Long id) {
        List<VinculoFamiliarEstudiante> vinculos = vinculoServicio.verVinculosPorEstudiante(id);
        return ResponseEntity.ok(vinculos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarVinculo(@PathVariable Long id) {
        vinculoServicio.eliminarVinculo(id);
        // Creamos una respuesta con un mensaje de éxito
        java.util.Map<String, String> response = new java.util.HashMap<>();
        response.put("mensaje", "Vínculo eliminado exitosamente.");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<VinculoDetalleDTO>> listarTodos() {
        return ResponseEntity.ok(vinculoServicio.listarTodosLosVinculos());
    }
}