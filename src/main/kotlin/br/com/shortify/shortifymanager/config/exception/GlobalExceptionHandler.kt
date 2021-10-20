package br.com.shortify.shortifymanager.config.exception

import br.com.shortify.shortifymanager.dto.error.ErrorMessageResponse
import br.com.shortify.shortifymanager.dto.error.ErrorResponse
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [Exception::class])
    protected fun genericException(ex: Exception): ResponseEntity<ErrorResponse> {
        //todo do not expose generic exception messages
        return ResponseEntity
            .status(INTERNAL_SERVER_ERROR)
            .body(ErrorResponse(ErrorMessageResponse(ex.message ?: "Sorry, something wrong happened")))
    }
}
