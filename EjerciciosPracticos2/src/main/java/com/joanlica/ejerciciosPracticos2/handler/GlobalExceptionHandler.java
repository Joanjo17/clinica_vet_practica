/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joanlica.ejerciciosPracticos2.handler;

import com.joanlica.ejerciciosPracticos2.exception.ResourceNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author Joan
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

         @ExceptionHandler(ResourceNotFoundException.class)
         public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {

            Map<String, Object> body = new HashMap<>();

            body.put("message", ex.getMessage());

            return new ResponseEntity<>(body,HttpStatus.NOT_FOUND); //404
         }
        
        // Handler para las Validaciones
         @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, List<String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
            List<String> errores = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

            Map<String, List<String>> body = new HashMap<>();
            body.put("errores", errores);

            // Return a ResponseEntity to explicitly specify the response body and status
            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST); 
        }
        
        
         @ExceptionHandler(HttpMessageNotReadableException.class)
         public ResponseEntity<Object> handleJsonParseException(HttpMessageNotReadableException ex) {
            Map<String, Object> body = new HashMap<>();
            body.put("error", "El formato del JSON es incorrecto.");
            body.put("mensaje", "Asegúrate de que los nombres de los campos son correctos y el formato es válido.");

            // Puedes incluir un detalle más técnico si quieres (opcional)
            // body.put("detalle_tecnico", ex.getMostSpecificCause().getMessage());

            return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST); // Es un 400
         }
         
         // Inside your GlobalExceptionHandler.java
        @ExceptionHandler(NoHandlerFoundException.class)
        public ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex) {
            Map<String, Object> body = new HashMap<>();
            body.put("error", "Recurso no encontrado.");
            body.put("mensaje", "La ruta solicitada no existe en la API.");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
        
         // Handler genérico para cualquier otra excepción
         @ExceptionHandler(Exception.class)
         public ResponseEntity<Object> handleGenericException(Exception ex) {
            Map<String, Object> body = new HashMap<>();
            body.put("mensaje", "Ocurrió un error interno en el servidor.");
            body.put("detalles", "Por favor, contacte al administrador."); // Oculta el mensaje real
            body.put("Error_real_pruebas:", ex.getMessage());
            return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
         }
}