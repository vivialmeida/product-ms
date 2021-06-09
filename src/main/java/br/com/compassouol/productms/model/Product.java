package br.com.compassouol.productms.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Document(collection = "product")
public class Product{

      @Id
      private String id;
      @NotEmpty
      private String name;
      @NotEmpty
      private String description;
      @Min(0)
      private BigDecimal price;

}
