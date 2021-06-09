package br.com.compassouol.productms.controller;

import br.com.compassouol.productms.model.Product;
import br.com.compassouol.productms.service.interfaces.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Validated
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProdutoController {

      private final ProdutoService produtoService;

      @ApiOperation(value = "Esse endpoint é responsavél por criar um novo produto na base de dados")
      @ApiResponses(value = {
              @ApiResponse(code = 201, message = "Created"),
              @ApiResponse(code = 400, message = "Parâmetros incorretos"),
              @ApiResponse(code = 500, message = "Erro interno"),
      })
      @PostMapping
      public ResponseEntity<Product> criarProduto(@Valid @RequestBody Product product) {
            return ResponseEntity.created(null).body(produtoService.criarProduto(product));
      }

      @ApiOperation(value = "Esse endpoint deve atualizar um produto ja existente correspondente ao id informado")
      @ApiResponses(value = {
              @ApiResponse(code = 200, message = "Ok"),
              @ApiResponse(code = 400, message = "Parâmetros incorretos"),
              @ApiResponse(code = 500, message = "Erro interno"),
      })
      @PutMapping("{id}")
      public ResponseEntity<Product> atualizarProduto(@PathVariable String id,
                                                      @RequestBody Product product) {
            return ResponseEntity.ok().body(produtoService.atualizarProduto(id, product));
      }

      @ApiOperation(value = "Esse endpoint deve retornar um produto correspondente ao id informado")
      @ApiResponses(value = {
              @ApiResponse(code = 200, message = "Ok"),
              @ApiResponse(code = 400, message = "Parâmetros incorretos"),
              @ApiResponse(code = 500, message = "Erro interno"),
      })
      @GetMapping("{id}")
      public ResponseEntity<Product> buscarProdutoPorId(@PathVariable String id) {
            return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
      }

      @ApiOperation(value = "Esse endpoint deve retornar a lista de produtos cadastrado")
      @ApiResponses(value = {
              @ApiResponse(code = 200, message = "Ok"),
              @ApiResponse(code = 400, message = "Parâmetros incorretos"),
              @ApiResponse(code = 500, message = "Erro interno"),
      })
      @GetMapping
      public ResponseEntity<List<Product>> buscarProdutos() {
            return ResponseEntity.ok(produtoService.buscarProdutos());
      }

      @ApiOperation(value = "Esse endpoint deve deletar um registro de produto na base de dados")
      @ApiResponses(value = {
              @ApiResponse(code = 200, message = "Ok"),
              @ApiResponse(code = 400, message = "Parâmetros incorretos"),
              @ApiResponse(code = 500, message = "Erro interno"),
      })
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
