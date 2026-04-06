package com.example.cursos.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API Cursos",
                version = "v1",
                description = "Documentacion de la API para gestion de cursos online",
                contact = @Contact(name = "Equipo", email = "319128411@pcpuma.acatlan.unam.mx")
        ),
        servers = {
                @Server(url = "http://localhost:8081", description = "Servidor local")
        }
)
public class OpenApiConfig {
}
