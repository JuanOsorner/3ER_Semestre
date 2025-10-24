package com.example.familia_api.controladores;

import com.example.familia_api.modelos.dto.AccesoPerfilDTO;
import com.example.familia_api.servicios.AnaliticasServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analiticas")
public class AnaliticasControlador {

    private final AnaliticasServicio analiticasServicio;

    public AnaliticasControlador(AnaliticasServicio analiticasServicio) {
        this.analiticasServicio = analiticasServicio;
    }

    @GetMapping("/accesos")
    public ResponseEntity<List<AccesoPerfilDTO>> listarTodosLosAccesos() {
        try {
            return ResponseEntity.ok(analiticasServicio.listarTodosLosAccesos());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
