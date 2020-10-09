package br.com.dataprocessor.inputdata.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    private Long idSale;
    private List<Item> items;
    private String salesmanName;
    private BigDecimal total;

}
