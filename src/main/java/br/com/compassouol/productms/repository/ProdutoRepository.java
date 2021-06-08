package br.com.compassouol.productms.repository;

import br.com.compassouol.productms.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Product, String> {



}
