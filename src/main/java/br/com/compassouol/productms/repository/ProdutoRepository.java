package br.com.compassouol.productms.repository;

import br.com.compassouol.productms.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Product, String> {



}
