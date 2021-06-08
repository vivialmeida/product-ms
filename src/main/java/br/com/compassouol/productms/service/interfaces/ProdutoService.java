package br.com.compassouol.productms.service.interfaces;

import br.com.compassouol.productms.model.Product;

public interface ProdutoService {

      Product criarProduto(Product product);

      Product atualizarProduto(String awtImageData, Product product);
}
