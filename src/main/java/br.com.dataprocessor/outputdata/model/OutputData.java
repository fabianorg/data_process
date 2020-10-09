package br.com.dataprocessor.outputdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutputData {
    private Integer customerQuantity;
    private Integer salesmanQuantity;
    private Long idBiggestSale;
    private String nameWorstSalesman;
    private String fileName;
}
