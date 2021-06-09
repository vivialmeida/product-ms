package br.com.compassouol.productms.repository;

import br.com.compassouol.productms.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends MongoRepository<Product, String> {

      List<Product> findProductsByPriceBetween(String min, String max);




}
