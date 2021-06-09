package br.com.compassouol.productms.repository;
import br.com.compassouol.productms.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepositoryTemplate {
      List<Product> recuperarProdutoPorFiltro(String q, BigDecimal min_price, BigDecimal max_price);


}
