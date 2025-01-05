package web.fram.side.common.handler.api;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatusCode;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionApi {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleBindException(final MethodArgumentNotValidException e) {
        final FieldError fieldError = e.getBindingResult().getFieldErrors().get(0);
        return ErrorResponse.builder(e, HttpStatusCode.valueOf(400), fieldError.toString())
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponse handleIllegalArgumentException(final IllegalArgumentException e) {
        return ErrorResponse.builder(e, HttpStatusCode.valueOf(400), e.getMessage())
                .build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handleEntityNotFoundException(final EntityNotFoundException e) {
        return ErrorResponse.builder(e, HttpStatusCode.valueOf(404), e.getMessage())
                .build();
    }
}
