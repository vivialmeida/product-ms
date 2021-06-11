package br.com.compassouol.productms.model.handler;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValidationErrorHandler {

    private static final long serialVersionUID = 1L;

    @JsonProperty("status_code")
    private Integer statusCode;
    private String message;

    public ValidationErrorHandler(Integer status, String message) {
        this.statusCode = status;
        this.message = message;
    }

//    public void addFieldMessageErrorHandler(String fieldName, String message) {
//        fieldErrors.add(FieldMessageErrorHandler.builder()
//                .fieldName(fieldName)
//                .message(message)
//                .build());
//    }
}