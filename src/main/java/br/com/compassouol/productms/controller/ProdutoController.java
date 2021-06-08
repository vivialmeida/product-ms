package br.com.compassouol.productms.controller;

import br.com.compassouol.productms.model.Product;
import br.com.compassouol.productms.service.interfaces.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProdutoController {

      private final ProdutoService produtoService;

      @PostMapping
      public ResponseEntity<Product> criarProduto(@RequestBody Product product){
            return ResponseEntity.created(URI.create(product.getId())).body(produtoService.criarProduto(product));
      }

      @PutMapping("{id}")
      public ResponseEntity<Product> atualizarProduto(@PathVariable String id,
                                                      @RequestBody Product product){
            return ResponseEntity.created(URI.create(product.getId())).body(produtoService.atualizarProduto(id, product));
      }

}
