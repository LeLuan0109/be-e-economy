package com.da.be_ttcs.cofiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "E-commerce api in Java Spring boot",
                version = "1.0.0",
                description = "Ứng dụng E để training"
        ),
        servers = {
                @Server(url = "http://localhost:8092", description = "Local Development Server"),
        }
)

@Configuration
public class OpenApiConfig {

}
