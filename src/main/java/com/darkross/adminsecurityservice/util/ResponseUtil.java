package com.darkross.adminsecurityservice.util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

public class ResponseUtil {

    /**
     * Construye una ResponseEntity.created(...) genérica para un recurso recién creado.
     * @param resourceId ID del recurso creado
     * @param <T> tipo de ID (Long, String, UUID, etc.)
     * @return ResponseEntity con el header Location
     */
    public static <T> ResponseEntity<Void> created(T resourceId) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(resourceId)
                .toUri();
        return ResponseEntity.created(location).build();
    }
}