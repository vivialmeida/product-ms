package br.com.compassouol.productms.service;

import br.com.compassouol.productms.model.Product;
import br.com.compassouol.productms.repository.ProdutoRepository;
import br.com.compassouol.productms.repository.ProdutoRepositoryTemplate;
import br.com.compassouol.productms.service.exception.ProductException;
import br.com.compassouol.productms.service.interfaces.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

      private final ProdutoRepository produtoRepository;
      private final ProdutoRepositoryTemplate produtoRepositoryTemplate;

      @Override
      public Product criarProduto(Product product) {
            return produtoRepository.save(product);

      }

      @Override
      public Product atualizarProduto(String id, Product product) {

            Optional<Product> productExistente = produtoRepository.findById(id);
            if (productExistente.isPresent()) {
                  product.setId(id);
                  return produtoRepository.save(product);

            }

            throw new ProductException(String.format("Produto com id %s não existe !", id));
      }

      @Override
      public Product buscarProdutoPorId(String id) {
            return  produtoRepository.findById(id).orElseThrow(() -> new ProductException(""));
      }

      @Override
      public List<Product> buscarProdutos() {
            return produtoRepository.findAll();
      }

      @Override
      public void excluirProduto(String id) {

            produtoRepository.deleteById(id);
      }

      @Override
      public List<Product> buscarProdutosPorFiltros(String q, BigDecimal min_price, BigDecimal max_price) {

           return produtoRepositoryTemplate.recuperarProdutoPorFiltro(q,min_price, max_price);

      }


}
