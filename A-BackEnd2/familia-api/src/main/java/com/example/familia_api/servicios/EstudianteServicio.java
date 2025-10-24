package com.example.familia_api.servicios;

import com.example.familia_api.modelos.Estudiante;
import com.example.familia_api.repositorios.IEstudianteRepositorio;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicio {

    private final IEstudianteRepositorio estudianteRepositorio;

    public EstudianteServicio(IEstudianteRepositorio estudianteRepositorio) {
        this.estudianteRepositorio = estudianteRepositorio;
    }

    public Estudiante buscarPorId(Long id) {
        return estudianteRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }
}
