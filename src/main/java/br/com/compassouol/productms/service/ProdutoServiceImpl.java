package br.com.compassouol.productms.service;

import br.com.compassouol.productms.model.Product;
import br.com.compassouol.productms.repository.ProdutoRepository;
import br.com.compassouol.productms.service.interfaces.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

      private final ProdutoRepository produtoRepository;

      @Override
      public Product criarProduto(Product product) {
            return produtoRepository.save(product);

      }

      @Override
      public Product atualizarProduto(String id, Product product) {
            product.setId(id);
            return produtoRepository.save(product);
      }
}
