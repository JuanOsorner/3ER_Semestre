package com.example.familia_api.servicios;

import com.example.familia_api.modelos.AccesoPerfil;
import com.example.familia_api.modelos.Estudiante;
import com.example.familia_api.modelos.Familiar;
import com.example.familia_api.repositorios.AccesoPerfilRepositorio;
import org.springframework.stereotype.Service;

@Service
public class AccesoPerfilServicio {

    private final AccesoPerfilRepositorio accesoPerfilRepositorio;

    public AccesoPerfilServicio(AccesoPerfilRepositorio accesoPerfilRepositorio) {
        this.accesoPerfilRepositorio = accesoPerfilRepositorio;
    }

    public void registrarAcceso(Familiar familiar, Estudiante estudiante) {
        AccesoPerfil acceso = new AccesoPerfil(familiar, estudiante);
        accesoPerfilRepositorio.save(acceso);
    }
}
