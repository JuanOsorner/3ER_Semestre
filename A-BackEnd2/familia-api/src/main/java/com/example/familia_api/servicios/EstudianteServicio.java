package com.example.familia_api.servicios;

import com.example.familia_api.modelos.Estudiante;
import com.example.familia_api.modelos.dto.EstudianteDTO;
import com.example.familia_api.modelos.mapas.IMapaEstudiante;
import com.example.familia_api.repositorios.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {

    @Autowired
    private IEstudianteRepositorio estudianteRepositorio;

    @Autowired
    private IMapaEstudiante mapaEstudiante;

    public EstudianteDTO guardarEstudiante(Estudiante datosEstudiante) throws Exception {
        try {
            return mapaEstudiante.toDto(estudianteRepositorio.save(datosEstudiante));
        } catch (Exception error) {
            throw new Exception("Error al guardar el estudiante: " + error.getMessage());
        }
    }

    public EstudianteDTO buscarEstudiantePorId(Integer id) throws Exception {
        try {
            Optional<Estudiante> estudianteEncontrado = estudianteRepositorio.findById(id);
            if (estudianteEncontrado.isPresent()) {
                return mapaEstudiante.toDto(estudianteEncontrado.get());
            } else {
                throw new Exception("Estudiante no encontrado");
            }
        } catch (Exception error) {
            throw new Exception("Error al buscar el estudiante: " + error.getMessage());
        }
    }

    public List<EstudianteDTO> buscarTodosLosEstudiantes() throws Exception {
        try {
            return mapaEstudiante.toDtoList(estudianteRepositorio.findAll());
        } catch (Exception error) {
            throw new Exception("Error al buscar todos los estudiantes: " + error.getMessage());
        }
    }
}
