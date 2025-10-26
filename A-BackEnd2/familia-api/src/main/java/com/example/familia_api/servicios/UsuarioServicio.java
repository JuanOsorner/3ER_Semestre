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

    // Método auxiliar para mapear la entidad Usuario a su DTO específico
    // Esto es útil para que los mappers de subclase (Estudiante/Familiar) manejen sus propiedades específicas
    private UsuarioDTO mapUsuarioToDtoWithRole(Usuario usuario) {
        if (usuario instanceof Estudiante) {
            return mapaEstudiante.toDto((Estudiante) usuario);
        } else if (usuario instanceof Familiar) {
            return mapaFamiliar.toDto((Familiar) usuario);
        } else {
            // Para un Usuario base que no es Estudiante/Familiar, usar el mapper genérico
            return mapaUsuario.toDto(usuario);
        }
    }

    public UsuarioDTO guardarUsuario(Usuario datosUsuario) throws Exception {
        try {
            // El rol ya debe venir establecido en datosUsuario
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

    public UsuarioDTO loginUsuario(String correo, String contra) throws Exception {
        try {
            Optional<Usuario> usuarioOptional = usuarioRepositorio.findByCorreo(correo);
            if (usuarioOptional.isEmpty()) {
                throw new Exception("Credenciales inválidas: Usuario no encontrado.");
            }

            Usuario usuario = usuarioOptional.get();
            if (!passwordEncoder.matches(contra, usuario.getContra())) {
                throw new Exception("Credenciales inválidas: Contraseña incorrecta.");
            }

            // Si las credenciales son correctas, mapear y devolver el DTO con el rol
            return mapUsuarioToDtoWithRole(usuario);

        } catch (Exception error) {
            throw new Exception("Fallo en la autenticación: " + error.getMessage());
        }
    }
}
