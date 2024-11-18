package projeto.listify.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDetails> handlerValidException(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(erro -> {
            String fieldName = ((FieldError) erro).getField();
            String messageError = erro.getDefaultMessage();
            erros.put(fieldName, messageError);
        });
        ExceptionDetails details = new ExceptionDetails(
                "Bad Request! Consult the documentation",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getClass().toString(),
                erros
        );
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ExceptionDetails> handlerDataAccessException(DataAccessException ex) {
        Map<String, String> details = new HashMap<>();
        details.put(ex.getCause().toString(), ex.getMessage());
        ExceptionDetails exceptionDetails = new ExceptionDetails(
                "Conflict! Consult the documentation",
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                ex.getClass().toString(),
                details
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDetails);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionDetails> handlerBusinessException(BusinessException ex) {
        Map<String, String> details = new HashMap<>();
        details.put(ex.getCause().toString(), ex.getMessage());
        ExceptionDetails exceptionDetails = new ExceptionDetails(
                "Bad Request! Consult the documentation",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getClass().toString(),
                details
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDetails);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionDetails> handlerIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> details = new HashMap<>();
        details.put(ex.getCause().toString(), ex.getMessage());
        ExceptionDetails exceptionDetails = new ExceptionDetails(
                "Bad Request! Consult the documentation",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getClass().toString(),
                details
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDetails);
    }
}
