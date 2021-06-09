package br.com.compassouol.productms.controller;

import br.com.compassouol.productms.model.Product;
import br.com.compassouol.productms.service.interfaces.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class ProdutoControllerTest {

      @Mock
      ProdutoService produtoService;
      @InjectMocks
      ProdutoController produtoController;

      @Before
      public void setUp() {
            MockitoAnnotations.openMocks(this);
      }

      @Test
      public void testCriarProduto(){
            when(produtoService.criarProduto(any())).thenReturn(new Product());
            ResponseEntity<Product> result = produtoController.criarProduto(new Product());
            Assert.assertTrue(result.hasBody());
            Assert.assertEquals(ResponseEntity.created(URI.create("teste")).build().getStatusCode(), result.getStatusCode());

      }

      @org.junit.Test
      public void testAtualizarProduto(){
            when(produtoService.atualizarProduto(anyString(), any())).thenReturn(new Product());
            ResponseEntity<Product> result = produtoController.atualizarProduto("id", new Product());
            Assert.assertTrue(result.hasBody());
            Assert.assertEquals(ResponseEntity.ok().build().getStatusCode(), result.getStatusCode());      }

      @Test
      public void testBuscarProdutoPorId() {
            when(produtoService.buscarProdutoPorId(anyString())).thenReturn(new Product());
            ResponseEntity<Product> result = produtoController.buscarProdutoPorId("id");
            Assert.assertNotNull(result);
      }


      @Test
      public void testBuscarProdutos(){
            when(produtoService.buscarProdutos()).thenReturn(Arrays.asList(new Product()));
            ResponseEntity<List<Product>> result = produtoController.buscarProdutos();
            Assert.assertNotNull( result);
            verify(produtoService).buscarProdutos();
            Assert.assertEquals(ResponseEntity.ok().build().getStatusCode(), result.getStatusCode());
      }

      @Test
      public void testExcluirProduto() {
            ResponseEntity<Void> result = produtoController.excluirProduto("id");
            Assert.assertEquals(ResponseEntity.ok().build().getStatusCode(), result.getStatusCode());
            verify(produtoService).excluirProduto(anyString());
      }

      @Test
      public void testBuscarProdutosPorFiltros() {
            when(produtoService.buscarProdutosPorFiltros(anyString(), any(), any())).thenReturn(Arrays.<Product>asList(new Product()));
            ResponseEntity<List<Product>> result = produtoController.buscarProdutosPorFiltros("q", new BigDecimal(0), new BigDecimal(0));
            Assert.assertEquals(ResponseEntity.ok().build().getStatusCode(), result.getStatusCode());
            Assert.assertTrue(result.hasBody());
      }
}

