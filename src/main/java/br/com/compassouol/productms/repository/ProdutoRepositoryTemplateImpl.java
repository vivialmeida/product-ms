package br.com.compassouol.productms.repository;

import br.com.compassouol.productms.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ProdutoRepositoryTemplateImpl implements ProdutoRepositoryTemplate {

      private final MongoTemplate mongoTemplate;

      @Override
      public List<Product> recuperarProdutoPorFiltro(String q, BigDecimal min_price, BigDecimal max_price) {
            Query query = new Query();w
            Criteria criteria = new Criteria();

            if (Objects.nonNull(q)) {
                  criteria.orOperator(
                          criteria.where("name").is(q), criteria.where("description").is(q));
            }
            if (Objects.nonNull(min_price)) {
                  criteria.and("price").gte(min_price);
            }

            if (Objects.nonNull(max_price)) {
                  criteria.andOperator(Criteria.where("price").lte(max_price));
            }

            query.addCriteria(criteria);

            return mongoTemplate.find(query, Product.class);


      }

}
