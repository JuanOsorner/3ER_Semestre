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

    /**
     * Endpoint público para que un familiar se registre por su cuenta.
     */
    @PostMapping("/registro")
    public ResponseEntity<FamiliarDTO> registrarNuevoFamiliar(@Valid @RequestBody RegistroFamiliarDTO registroDTO) {
        FamiliarDTO familiarCreado = familiarServicio.procesoDeRegistro(registroDTO);
        return new ResponseEntity<>(familiarCreado, HttpStatus.CREATED);
    }

    /**
     * Endpoint para registrar un familiar (posiblemente por un administrador).
     */
    @PostMapping
    public ResponseEntity<FamiliarDTO> registrarFamiliar(@Valid @RequestBody FamiliarDTO familiarDTO) {
        FamiliarDTO nuevoFamiliar = familiarServicio.registrarFamiliar(familiarDTO);
        return new ResponseEntity<>(nuevoFamiliar, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FamiliarDTO>> listarFamiliares() {
        List<FamiliarDTO> familiares = familiarServicio.listarTodos();
        return ResponseEntity.ok(familiares);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamiliarDTO> obtenerFamiliarPorId(@PathVariable Long id) {
        FamiliarDTO familiar = familiarServicio.buscarPorId(id);
        return ResponseEntity.ok(familiar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamiliarDTO> actualizarFamiliar(@PathVariable Long id, @Valid @RequestBody FamiliarDTO familiarDTO) {
        FamiliarDTO familiarActualizado = familiarServicio.actualizarFamiliar(id, familiarDTO);
        return ResponseEntity.ok(familiarActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFamiliar(@PathVariable Long id) {
        familiarServicio.eliminarFamiliar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/correo/{email}")
    public ResponseEntity<Map<String, Object>> verificarCorreo(@PathVariable String email) {
        boolean existe = familiarServicio.verificarCorreoExistente(email);
        String mensaje = existe ? "El correo ya está registrado." : "El correo está disponible.";
        Map<String, Object> response = new HashMap<>();
        response.put("existe", existe);
        response.put("mensaje", mensaje);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/estudiantes")
    public ResponseEntity<List<EstudianteAsociadoDTO>> verEstudiantesAsociados(@PathVariable Long id) {
        List<EstudianteAsociadoDTO> estudiantes = familiarServicio.verEstudiantesAsociados(id);
        return ResponseEntity.ok(estudiantes);
    }
}