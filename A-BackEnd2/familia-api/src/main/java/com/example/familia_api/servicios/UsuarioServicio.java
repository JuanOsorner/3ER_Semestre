package com.example.familia_api.servicios;

import com.example.familia_api.modelos.Estudiante;
import com.example.familia_api.modelos.Familiar;
import com.example.familia_api.modelos.Usuario;
import com.example.familia_api.modelos.dto.UsuarioDTO;
import com.example.familia_api.modelos.mapas.IMapaEstudiante;
import com.example.familia_api.modelos.mapas.IMapaFamiliar;
import com.example.familia_api.modelos.mapas.IMapaUsuario;
import com.example.familia_api.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServicio {

    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    @Autowired
    private IMapaUsuario mapaUsuario;

    @Autowired
    private IMapaEstudiante mapaEstudiante;

    @Autowired
    private IMapaFamiliar mapaFamiliar;

    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioServicio() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Método auxiliar para mapear la entidad Usuario a su DTO específico con el rol correcto
    private UsuarioDTO mapUsuarioToDtoWithRole(Usuario usuario) {
        if (usuario instanceof Estudiante) {
            return mapaEstudiante.toDto((Estudiante) usuario);
        } else if (usuario instanceof Familiar) {
            return mapaFamiliar.toDto((Familiar) usuario);
        } else {
            // Para un Usuario base (si existiera o si no es Estudiante/Familiar)
            // El rol aquí sería null, ya que IMapaUsuario lo ignora.
            return mapaUsuario.toDto(usuario);
        }
    }

    public UsuarioDTO guardarUsuario(Usuario datosUsuario) throws Exception {
        try {
            datosUsuario.setContra(passwordEncoder.encode(datosUsuario.getContra()));
            Usuario savedUser = usuarioRepositorio.save(datosUsuario);
            return mapUsuarioToDtoWithRole(savedUser);
        } catch (Exception error) {
            throw new Exception("Error al guardar el usuario: " + error.getMessage());
        }
    }

    public UsuarioDTO buscarUsuarioPorId(Integer id) throws Exception {
        try {
            Optional<Usuario> usuarioEncontrado = usuarioRepositorio.findById(id);
            if (usuarioEncontrado.isPresent()) {
                return mapUsuarioToDtoWithRole(usuarioEncontrado.get());
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception("Error al buscar el usuario: " + error.getMessage());
        }
    }

    public List<UsuarioDTO> buscarTodosLosUsuarios() throws Exception {
        try {
            return usuarioRepositorio.findAll().stream()
                    .map(this::mapUsuarioToDtoWithRole) // Usar el método auxiliar para mapear con rol
                    .collect(Collectors.toList());
        } catch (Exception error) {
            throw new Exception("Error al buscar todos los usuarios: " + error.getMessage());
        }
    }
}
