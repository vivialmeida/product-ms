package br.com.compassouol.productms.service;

import br.com.compassouol.productms.model.Product;
import br.com.compassouol.productms.repository.ProdutoRepository;
import br.com.compassouol.productms.repository.ProdutoRepositoryTemplate;
import br.com.compassouol.productms.service.exception.ProductException;
import br.com.compassouol.productms.service.exception.ProductNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ProdutoServiceImplTest {
      @Mock
      ProdutoRepository produtoRepository;
      @Mock
      ProdutoRepositoryTemplate produtoRepositoryTemplate;
      @InjectMocks
      ProdutoServiceImpl produtoServiceImpl;

      @Before
      public void setUp() {
            MockitoAnnotations.openMocks(this);
      }

      @Test
      public void testCriarProduto() {
            when(produtoRepository.save(any())).thenReturn(new Product());
            Product result = produtoServiceImpl.criarProduto(new Product());
            Assert.assertNotNull(result);

      }

      @Test
      public void testAtualizarProduto() {
            when(produtoRepository.findById(anyString())).thenReturn(Optional.of(new Product()));
            produtoServiceImpl.atualizarProduto("id", new Product());
            verify(produtoRepository).findById(anyString());
            verify(produtoRepository).save(any());
      }

      @Test(expected = ProductException.class)
      public void testFailAtualizarProduto() {
             produtoServiceImpl.atualizarProduto("id", new Product());
      }

      @Test
      public void testBuscarProdutoPorId() {
            when(produtoRepository.findById(anyString())).thenReturn(Optional.of(new Product()));
            Product result =  produtoServiceImpl.buscarProdutoPorId("id");
            Assert.assertNotNull(result);

      }

      @Test(expected = ProductNotFoundException.class)
      public void testFailBuscarProdutoPorId() {
            produtoServiceImpl.buscarProdutoPorId("id");
      }

      @Test
      public void testBuscarProdutos(){
            when(produtoRepository.findAll()).thenReturn(Arrays.asList(new Product()));
            List<Product> result = produtoServiceImpl.buscarProdutos();
            Assert.assertEquals(Arrays.asList(new Product()), result);
            verify(produtoRepository).findAll();
      }

      @Test
      public void testExcluirProduto(){
            when(produtoRepository.existsById(anyString())).thenReturn(true);
            produtoServiceImpl.excluirProduto("id");
            verify(produtoRepository).existsById(anyString());
            verify(produtoRepository).deleteById(anyString());

      }

      @Test(expected = ProductNotFoundException.class)
      public void testFailExcluirProduto(){
            when(produtoRepository.existsById(anyString())).thenReturn(false);
            produtoServiceImpl.excluirProduto("id");
      }

      @Test
      public void testBuscarProdutosPorFiltros(){
            when(produtoRepositoryTemplate.recuperarProdutoPorFiltro(anyString(), any(), any())).thenReturn(Arrays.asList(new Product()));
            List<Product> result = produtoServiceImpl.buscarProdutosPorFiltros("q", new BigDecimal(0), new BigDecimal(0));
            Assert.assertEquals(Arrays.asList(new Product()), result);
      }
}

