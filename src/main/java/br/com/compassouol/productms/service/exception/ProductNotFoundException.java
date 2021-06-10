package br.com.compassouol.productms.service.exception;

public class ProductNotFoundException extends RuntimeException {
      public ProductNotFoundException(String message) {
            super(message);
      }
}
