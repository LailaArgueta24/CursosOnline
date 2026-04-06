package com.example.cursos.controllers;

import com.example.cursos.models.User;
import com.example.cursos.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Operaciones para consultar usuarios")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

        @Operation(summary = "Obtener usuario por ID", description = "Devuelve un usuario específico según su identificador")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado", content = @Content)
        })
    @GetMapping("/{id}")
        public User getUserById(
            @Parameter(description = "ID del usuario", example = "1") @PathVariable Long id
        ) {
        return userService.getUserById(id);
    }

        @Operation(summary = "Listar todos los usuarios", description = "Devuelve la lista completa de usuarios")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente",
                content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = User.class))))
        })
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
