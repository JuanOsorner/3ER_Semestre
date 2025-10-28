package com.example.familia_api.controladores;

import com.example.familia_api.modelos.dto.ConsultaDTO;
import com.example.familia_api.servicios.ConsultaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consultas")
public class ConsultaControlador {

    @Autowired
    private ConsultaServicio consultaServicio;

    @PostMapping
    public ResponseEntity<?> registrarConsulta(@RequestBody Map<String, Object> requestBody) {
        try {
            Integer vinculoId = (Integer) requestBody.get("vinculoId");
            String observaciones = (String) requestBody.get("observaciones");

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(consultaServicio.registrarConsulta(vinculoId, observaciones));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarConsultas() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(consultaServicio.listarConsultas());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}/completa")
    public ResponseEntity<?> obtenerConsultaCompleta(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(consultaServicio.obtenerConsultaCompleta(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }
}
