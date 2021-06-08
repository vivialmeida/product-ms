package br.com.compassouol.productms.controller;

import br.com.compassouol.productms.model.Product;
import br.com.compassouol.productms.service.interfaces.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@Validated
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProdutoController {

      private final ProdutoService produtoService;

      @PostMapping
      public ResponseEntity<Product> criarProduto(@Valid @RequestBody Product product) {
            return ResponseEntity.created(null).body(produtoService.criarProduto(product));
      }

      @PutMapping("{id}")
      public ResponseEntity<Product> atualizarProduto(@PathVariable String id,
                                                      @RequestBody Product product) {
            return ResponseEntity.ok().body(produtoService.atualizarProduto(id, product));
      }

      @GetMapping("{id}")
      public ResponseEntity<Product> buscarProdutoPorId(@PathVariable String id) {
            return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
      }

      @GetMapping
      public ResponseEntity<List<Product>> buscarProdutos() {
            return ResponseEntity.ok(produtoService.buscarProdutos());
      }

      @DeleteMapping("{id}")
      public ResponseEntity<Void> excluirProduto(@PathVariable String id) {
            produtoService.excluirProduto(id);
            return ResponseEntity.ok().build();
      }

      @GetMapping("search")
      public ResponseEntity<List<Product>> buscarProdutosPorFiltros(@RequestParam(value = "q", required = false) String q,
                                                          @RequestParam(value = "min_price", required = false) BigDecimal min_price,
                                                          @RequestParam(value = "max_price", required = false) BigDecimal max_price) {
            return ResponseEntity.ok().body(produtoService.buscarProdutosPorFiltros(q, min_price, max_price));

      }

}
