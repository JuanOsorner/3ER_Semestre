package com.example.familia_api.controladores;

import com.example.familia_api.modelos.dto.ConsultaDTO;
import com.example.familia_api.servicios.ConsultaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaControlador {

    @Autowired
    private ConsultaServicio consultaServicio;

    // post recibe del cuerpo de la peticion json por eso requestBody
    @PostMapping
    public ResponseEntity<?> registrarConsulta(@RequestBody ConsultaDTO consultaDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(consultaServicio.registrarConsulta(consultaDTO.getVinculoId(), consultaDTO.getObservaciones()));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    // Get recibe de la url, por eso path
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
