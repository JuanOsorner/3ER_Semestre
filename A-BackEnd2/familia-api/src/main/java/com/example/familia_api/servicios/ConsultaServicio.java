package com.example.familia_api.servicios;

import com.example.familia_api.modelos.Consulta;
import com.example.familia_api.modelos.Vinculo;
import com.example.familia_api.modelos.dto.ConsultaDTO;
import com.example.familia_api.modelos.mapas.IMapaConsulta;
import com.example.familia_api.repositorios.IConsultaRepositorio;
import com.example.familia_api.repositorios.IVinculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServicio {

    @Autowired
    private IConsultaRepositorio consultaRepositorio;

    @Autowired
    private IVinculoRepositorio vinculoRepositorio;

    @Autowired
    private IMapaConsulta mapaConsulta;

    public ConsultaDTO registrarConsulta(Integer vinculoId, String observaciones) throws Exception {
        try {
            Vinculo vinculo = vinculoRepositorio.findById(vinculoId)
                    .orElseThrow(() -> new Exception("Vínculo no encontrado"));

            Consulta consulta = new Consulta(vinculo, observaciones);
            consultaRepositorio.save(consulta);

            return mapaConsulta.toDto(consulta);
        } catch (Exception error) {
            throw new Exception("Error al registrar la consulta: " + error.getMessage());
        }
    }

    public List<ConsultaDTO> listarConsultas() throws Exception {
        try {
            return mapaConsulta.toDtoList(consultaRepositorio.findAll());
        } catch (Exception error) {
            throw new Exception("Error al listar las consultas: " + error.getMessage());
        }
    }
}
