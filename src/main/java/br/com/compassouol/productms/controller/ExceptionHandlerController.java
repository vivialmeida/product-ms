package br.com.compassouol.productms.controller;

import br.com.compassouol.productms.model.handler.ValidationErrorHandler;
import br.com.compassouol.productms.service.exception.ProductException;
import br.com.compassouol.productms.service.exception.ProductNotFoundException;
import com.mongodb.MongoException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@RestController
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {

      @ExceptionHandler(MethodArgumentNotValidException.class)
      public ResponseEntity<ValidationErrorHandler> handlerValidacaoArgumentoInvalido(MethodArgumentNotValidException e, HttpServletRequest request) {

            ValidationErrorHandler err = this.geraValidationErrorHandler(HttpStatus.BAD_REQUEST, e);
            err.setMessage("Campos inválidos: ");
            List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();
            fieldErrorList.forEach(f -> err.setMessage(err.getMessage().concat("Campo: " + f.getField() + " | Mensagem: " + f.getDefaultMessage())));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
      }

      @ExceptionHandler(ConstraintViolationException.class)
      public ResponseEntity<ValidationErrorHandler> handlerValidacaoConstraintViolada(ConstraintViolationException e) {

            ValidationErrorHandler err = this.geraValidationErrorHandler(HttpStatus.BAD_REQUEST, e);
            err.setMessage("Campos inválidos: ");

            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            violations.forEach(f -> err.setMessage(err.getMessage().concat("Propriedade: " + f.getPropertyPath().toString() + " | Mensagem: " + f.getMessage())));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
      }

      @ExceptionHandler(NullPointerException.class)
      public ResponseEntity<ValidationErrorHandler> handlerNullPointer(NullPointerException e) {
            ValidationErrorHandler err = this.geraValidationErrorHandler(HttpStatus.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
      }

      @ExceptionHandler(MongoException.class)
      public ResponseEntity<ValidationErrorHandler> handlerBD(SQLException e) {
            ValidationErrorHandler err = this.geraValidationErrorHandler(HttpStatus.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
      }

      @ExceptionHandler(Exception.class)
      public ResponseEntity<ValidationErrorHandler> handlerAll(Exception e) {
            ValidationErrorHandler err = this.geraValidationErrorHandler(HttpStatus.INTERNAL_SERVER_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
      }

      @ExceptionHandler(ProductException.class)
      public ResponseEntity<ValidationErrorHandler> handlerValidacaoNegocio(ProductException e) {
            ValidationErrorHandler err = this.geraValidationErrorHandler(HttpStatus.NOT_FOUND, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
      }

      @ExceptionHandler(ProductNotFoundException.class)
      public ResponseEntity<Void> handlerValidacaoNaoEncontrado(ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }

      private ValidationErrorHandler geraValidationErrorHandler(HttpStatus httpStatus, Exception e) {
            return new ValidationErrorHandler(
                    httpStatus.value(),
                    e.getMessage());
      }

}