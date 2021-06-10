package br.com.compassouol.productms.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

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
      @Min(0) @Field(targetType = FieldType.DECIMAL128)
      private BigDecimal price;

}
