package br.com.compassouol.productms.service.interfaces;

import br.com.compassouol.productms.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoService {

      Product criarProduto(Product product);

      Product atualizarProduto(String id, Product product);

      Product buscarProdutoPorId(String id);

      List<Product> buscarProdutos();

      void excluirProduto(String id);

      List<Product> buscarProdutosPorFiltros(String q, BigDecimal min_price, BigDecimal max_price);
}
