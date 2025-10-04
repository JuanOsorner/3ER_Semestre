package com.example.familia_api.servicios;

import com.example.familia_api.ayudas.Rol;
import com.example.familia_api.modelos.Familiar;
import com.example.familia_api.modelos.Usuario;
import com.example.familia_api.modelos.VinculoFamiliarEstudiante;
import com.example.familia_api.modelos.dto.EstudianteAsociadoDTO;
import com.example.familia_api.modelos.dto.FamiliarDTO;
import com.example.familia.modelos.dto.RegistroFamiliarDTO;
import com.example.familia_api.modelos.mapas.IFamiliarMapa;
import com.example.familia_api.modelos.mapas.IVinculoMapa;
import com.example.familia_api.repositorios.IFamiliarRepositorio;
import com.example.familia_api.repositorios.IUsuarioRepositorio;
import com.example.familia_api.repositorios.IVinculoFamiliarEstudianteRepositorio;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FamiliarServicio {

    private final IFamiliarRepositorio familiarRepositorio;
    private final IFamiliarMapa familiarMapa;
    private final IVinculoFamiliarEstudianteRepositorio vinculoRepositorio;
    private final IVinculoMapa vinculoMapa;
    private final IUsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    // CONSTRUCTOR ACTUALIZADO: Acepta todas las dependencias necesarias
    public FamiliarServicio(IFamiliarRepositorio familiarRepositorio,
                            IFamiliarMapa familiarMapa,
                            IVinculoFamiliarEstudianteRepositorio vinculoRepositorio,
                            IVinculoMapa vinculoMapa,
                            IUsuarioRepositorio usuarioRepositorio,
                            PasswordEncoder passwordEncoder) {
        this.familiarRepositorio = familiarRepositorio;
        this.familiarMapa = familiarMapa;
        this.vinculoRepositorio = vinculoRepositorio;
        this.vinculoMapa = vinculoMapa;
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Procesa el registro de un nuevo familiar y su cuenta de usuario.
     * @param registroDTO DTO con los datos de registro.
     * @return El DTO del familiar creado.
     */
    @Transactional
    public FamiliarDTO procesoDeRegistro(RegistroFamiliarDTO registroDTO) {
        // 1. Validar que el correo no exista
        if (familiarRepositorio.findByCorreo(registroDTO.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está en uso.");
        }

        // 2. Crear y guardar la entidad Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCorreo(registroDTO.getCorreo());
        nuevoUsuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
        nuevoUsuario.setRol(Rol.FAMILIAR);
        Usuario usuarioGuardado = usuarioRepositorio.save(nuevoUsuario);

        // 3. Crear y guardar la entidad Familiar, vinculada al usuario
        Familiar nuevoFamiliar = new Familiar();
        nuevoFamiliar.setNombre(registroDTO.getNombre());
        nuevoFamiliar.setApellido(registroDTO.getApellido());
        nuevoFamiliar.setCorreo(registroDTO.getCorreo());
        nuevoFamiliar.setParentesco(registroDTO.getParentesco());
        nuevoFamiliar.setTelefono(registroDTO.getTelefono());
        nuevoFamiliar.setUsuario(usuarioGuardado);

        Familiar familiarGuardado = familiarRepositorio.save(nuevoFamiliar);

        // 4. Devolver el DTO del familiar creado
        return familiarMapa.familiarToFamiliarDTO(familiarGuardado);
    }

    public FamiliarDTO registrarFamiliar(FamiliarDTO familiarDTO) {
        if (familiarRepositorio.findByCorreo(familiarDTO.getCorreo()).isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }
        Familiar familiar = familiarMapa.familiarDTOToFamiliar(familiarDTO);
        Familiar familiarGuardado = familiarRepositorio.save(familiar);
        return familiarMapa.familiarToFamiliarDTO(familiarGuardado);
    }

    public List<FamiliarDTO> listarTodos() {
        return familiarMapa.toFamiliarDTOList(familiarRepositorio.findAll());
    }

    public FamiliarDTO buscarPorId(Long id) {
        Familiar familiar = familiarRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Familiar no encontrado con el id: " + id));
        return familiarMapa.familiarToFamiliarDTO(familiar);
    }

    public FamiliarDTO actualizarFamiliar(Long id, FamiliarDTO familiarDTO) {
        Familiar familiarExistente = familiarRepositorio.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Familiar no encontrado con el id: " + id));

        familiarExistente.setNombre(familiarDTO.getNombre());
        familiarExistente.setApellido(familiarDTO.getApellido());
        familiarExistente.setCorreo(familiarDTO.getCorreo());
        familiarExistente.setParentesco(familiarDTO.getParentesco());
        familiarExistente.setTelefono(familiarDTO.getTelefono());

        Familiar familiarActualizado = familiarRepositorio.save(familiarExistente);
        return familiarMapa.familiarToFamiliarDTO(familiarActualizado);
    }

    public void eliminarFamiliar(Long id) {
        if (!familiarRepositorio.existsById(id)) {
            throw new EntityNotFoundException("Familiar no encontrado con el id: " + id);
        }
        familiarRepositorio.deleteById(id);
    }

    public boolean verificarCorreoExistente(String correo) {
        return familiarRepositorio.findByCorreo(correo).isPresent();
    }

    public List<EstudianteAsociadoDTO> verEstudiantesAsociados(Long idFamiliar) {
        if (!familiarRepositorio.existsById(idFamiliar)) {
            throw new EntityNotFoundException("Familiar no encontrado con id: " + idFamiliar);
        }
        List<VinculoFamiliarEstudiante> vinculos = vinculoRepositorio.findByFamiliarId(idFamiliar);
        return vinculoMapa.toEstudianteAsociadoDTOList(vinculos);
    }
}