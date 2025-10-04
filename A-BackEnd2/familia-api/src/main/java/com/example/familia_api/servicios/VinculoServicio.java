package com.example.familia_api.servicios;

import com.example.familia_api.modelos.Estudiante;
import com.example.familia_api.modelos.Familiar;
import com.example.familia_api.modelos.VinculoFamiliarEstudiante;
import com.example.familia_api.modelos.dto.VinculoDetalleDTO;
import com.example.familia_api.modelos.dto.VinculoFamiliarEstudianteDTO;
import com.example.familia_api.modelos.mapas.IVinculoMapa;
import com.example.familia_api.repositorios.IEstudianteRepositorio;
import com.example.familia_api.repositorios.IFamiliarRepositorio;
import com.example.familia_api.repositorios.IVinculoFamiliarEstudianteRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VinculoServicio {

    private final IVinculoFamiliarEstudianteRepositorio vinculoRepositorio;
    private final IFamiliarRepositorio familiarRepositorio;
    private final IEstudianteRepositorio estudianteRepositorio;

    private final IVinculoMapa vinculoMapa;

    public VinculoServicio(IVinculoFamiliarEstudianteRepositorio vinculoRepositorio, IFamiliarRepositorio familiarRepositorio, IEstudianteRepositorio estudianteRepositorio, IVinculoMapa vinculoMapa) {
        this.vinculoRepositorio = vinculoRepositorio;
        this.familiarRepositorio = familiarRepositorio;
        this.estudianteRepositorio = estudianteRepositorio;
        this.vinculoMapa = vinculoMapa;
    }

    public VinculoFamiliarEstudiante crearVinculo(VinculoFamiliarEstudianteDTO dto) {
        // Validar existencia de familiar y estudiante antes de vincular
        Familiar familiar = familiarRepositorio.findById(dto.getIdFamiliar())
                .orElseThrow(() -> new EntityNotFoundException("Familiar no encontrado con id: " + dto.getIdFamiliar()));

        Estudiante estudiante = estudianteRepositorio.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new EntityNotFoundException("Estudiante no encontrado con id: " + dto.getIdEstudiante()));

        VinculoFamiliarEstudiante nuevoVinculo = new VinculoFamiliarEstudiante();
        nuevoVinculo.setFamiliar(familiar);
        nuevoVinculo.setEstudiante(estudiante);
        nuevoVinculo.setAutorizado(dto.getAutorizado());

        return vinculoRepositorio.save(nuevoVinculo);
    }

    public List<VinculoFamiliarEstudiante> verVinculosPorEstudiante(Long idEstudiante) {
        if (!estudianteRepositorio.existsById(idEstudiante)) {
            throw new EntityNotFoundException("Estudiante no encontrado con id: " + idEstudiante);
        }
        return vinculoRepositorio.findByEstudianteId(idEstudiante);
    }

    public void eliminarVinculo(Long idVinculo) {
        if (!vinculoRepositorio.existsById(idVinculo)) {
            throw new EntityNotFoundException("Vínculo no encontrado con id: " + idVinculo);
        }
        vinculoRepositorio.deleteById(idVinculo);
    }

    public List<VinculoDetalleDTO> listarTodosLosVinculos() {
        List<VinculoFamiliarEstudiante> vinculos = vinculoRepositorio.findAll();
        return vinculoMapa.toVinculoDetalleDTOList(vinculos);
    }
}