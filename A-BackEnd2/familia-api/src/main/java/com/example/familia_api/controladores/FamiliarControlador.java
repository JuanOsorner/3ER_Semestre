package com.example.familia_api.controladores;

import com.example.familia_api.modelos.dto.EstudianteAsociadoDTO;
import com.example.familia_api.modelos.dto.FamiliarDTO;
import com.example.familia.modelos.dto.RegistroFamiliarDTO;
import com.example.familia_api.servicios.FamiliarServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/familiares")
public class FamiliarControlador {

    private final FamiliarServicio familiarServicio;

    public FamiliarControlador(FamiliarServicio familiarServicio) {
        this.familiarServicio = familiarServicio;
    }

    @PostMapping("/registro")
    public ResponseEntity<FamiliarDTO> registrarNuevoFamiliar(@Valid @RequestBody RegistroFamiliarDTO registroDTO) {
        try {
            FamiliarDTO familiarCreado = familiarServicio.procesoDeRegistro(registroDTO);
            return new ResponseEntity<>(familiarCreado, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<FamiliarDTO> registrarFamiliar(@Valid @RequestBody FamiliarDTO familiarDTO) {
        try {
            FamiliarDTO nuevoFamiliar = familiarServicio.registrarFamiliar(familiarDTO);
            return new ResponseEntity<>(nuevoFamiliar, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FamiliarDTO>> listarFamiliares() {
        try {
            List<FamiliarDTO> familiares = familiarServicio.listarTodos();
            return ResponseEntity.ok(familiares);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiliarDTO> obtenerFamiliarPorId(@PathVariable Long id) {
        try {
            FamiliarDTO familiar = familiarServicio.buscarPorId(id);
            return ResponseEntity.ok(familiar);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliarDTO> actualizarFamiliar(@PathVariable Long id, @Valid @RequestBody FamiliarDTO familiarDTO) {
        try {
            FamiliarDTO familiarActualizado = familiarServicio.actualizarFamiliar(id, familiarDTO);
            return ResponseEntity.ok(familiarActualizado);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFamiliar(@PathVariable Long id) {
        try {
            familiarServicio.eliminarFamiliar(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/correo/{email}")
    public ResponseEntity<Map<String, Object>> verificarCorreo(@PathVariable String email) {
        try {
            boolean existe = familiarServicio.verificarCorreoExistente(email);
            String mensaje = existe ? "El correo ya está registrado." : "El correo está disponible.";
            Map<String, Object> response = new HashMap<>();
            response.put("existe", existe);
            response.put("mensaje", mensaje);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/estudiantes")
    public ResponseEntity<List<EstudianteAsociadoDTO>> verEstudiantesAsociados(@PathVariable Long id) {
        try {
            List<EstudianteAsociadoDTO> estudiantes = familiarServicio.verEstudiantesAsociados(id);
            return ResponseEntity.ok(estudiantes);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}