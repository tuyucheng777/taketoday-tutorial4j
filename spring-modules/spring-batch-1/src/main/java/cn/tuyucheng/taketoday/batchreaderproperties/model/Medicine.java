package cn.tuyucheng.taketoday.batchreaderproperties.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Medicine {
   private UUID id;
   private String name;
   private MedicineCategory type;
   private Timestamp expirationDate;
   private Double originalPrice;
   private Double salePrice;
}