package com.ceiba.adn.carclick.infraestructura.excepcion;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionCarroNoRegistrado;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionClienteNoRegistrado;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionFechaFueraHorarioServicio;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionReservaNoRegistrada;
import com.ceiba.adn.carclick.dominio.excepcion.ExcepcionValidarCampo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {
	
	private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrio un error favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorError() {
        CODIGOS_ESTADO.put(ExcepcionCarroNoRegistrado.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionClienteNoRegistrado.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        CODIGOS_ESTADO.put(ExcepcionDuplicidad.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionFechaFueraHorarioServicio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionReservaNoRegistrada.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        CODIGOS_ESTADO.put(ExcepcionValidarCampo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        //en caso de tener otra excepcion matricularla aca
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if (codigo != null) {
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resultado;
    }
}
