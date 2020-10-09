package br.com.dataprocessor.service;

import br.com.dataprocessor.inputdata.builder.SalesBuilder;
import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.inputdata.model.Sale;
import br.com.dataprocessor.outputdata.model.OutputData;
import br.com.dataprocessor.type.IdentifierEnum;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class SalesService {

    public Function<InputData, InputData> extractSales(String data){
        return (InputData inputData)-> {
            if (data.startsWith(IdentifierEnum.SALE.identifier)) {
                    inputData
                        .getSales()
                        .add(SalesBuilder.saleBuilder(data));
            }
            return inputData;
        };
    }

    public UnaryOperator<OutputData> getBiggestSale(List<Sale> sales){
        return (OutputData outputData) -> {
            outputData.setIdBiggestSale(getIdBiggestSale(sales));
            return outputData;
        };
    }

    private Long getIdBiggestSale(List<Sale> sales){
        return sales.stream()
                .max(Comparator.comparing(Sale::getTotal))
                .map(Sale::getIdSale)
                .get();

    }

}
