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
//
//      public List<String> recuperarProdutoPorFiltro(String q, BigDecimal min_price, BigDecimal max_price){
//            Query query = new Query();
//            if (Objects.nonNull(empresa.getFantasia())) {
//                  query.addCriteria(Criteria.where("fantasia").is(empresa.getFantasia()));
//            }
//            if (Objects.nonNull(empresa.getCnpj())) {
//                  query.addCriteria(Criteria.where("cnpj").is(empresa.getCnpj()));
//            }
//            query.fields().include("id");
//            List<Empresa> empresas = mongoTemplate.find(query, Empresa.class);
//
//            return empresas.stream().map(Empresa::getId)
//                    .collect(Collectors.toList());
//
//
//      }


      @Override
      public List<Product> recuperarProdutoPorFiltro(String q, BigDecimal min_price, BigDecimal max_price) {
//            Query query = new Query();
//            if (Objects.nonNull(q)) {
//                  query.addCriteria(Criteria.where("name").is(q).orOperator().);
//            }
//            if (Objects.nonNull(min_price)) {
//                  query.addCriteria(Criteria.where("price").gte(min_price));
//            }
//
//            if (Objects.nonNull(max_price)) {
//                  query.addCriteria(Criteria.where("price").lte(max_price));
//            }
//            List<Product> products = mongoTemplate.find(query, Product.class);
//
            return null;


      }

}


//        min_price	deverá bater o valor ">=" contra o campo price
//        max_price	deverá bater o valor "<=" contra o campo price