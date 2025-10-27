package com.example.familia_api.controladores;

import com.example.familia_api.modelos.Usuario;
import com.example.familia_api.modelos.dto.LoginRequestDTO;
import com.example.familia_api.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario datos) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(usuarioServicio.guardarUsuario(datos));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.buscarUsuarioPorId(id));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodosLosUsuarios() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.buscarTodosLosUsuarios());
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    // AQUI ESTAMOS USANDO REQUESTBODY PARA EXTRAER EL VALOR DEL CUERPO DE LA PETICIÓN
    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginRequestDTO loginRequest) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.loginUsuario(loginRequest.getCorreo(), loginRequest.getContra()));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED) // 401 para credenciales inválidas
                    .body(error.getMessage());
        }
    }
    // PATH SIRVE PARA EXTRAER EL VALOR DE LA URL DIRECTAMENTE
    @GetMapping("/correo/{correo}")
    public ResponseEntity<?> buscarUsuarioPorCorreo(@PathVariable String correo) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.buscarUsuarioPorCorreo(correo));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario datosParaActualizar) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.actualizarUsuario(id, datosParaActualizar));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("/correo/{correo}")
    public ResponseEntity<?> eliminarUsuarioPorCorreo(@PathVariable String correo) {
        try {
            usuarioServicio.eliminarUsuarioPorCorreo(correo);
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT) // 204 No Content es estándar para delete exitoso
                    .build();
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(error.getMessage());
        }
    }
}
