package br.com.dataprocessor.inputdata.builder;

import br.com.dataprocessor.inputdata.model.Item;
import br.com.dataprocessor.inputdata.model.Sale;
import br.com.dataprocessor.util.ProcessorUtils;

import java.math.BigDecimal;
import java.util.List;

public class SalesBuilder {

    public static Sale saleBuilder(String data) {
        List<String> resultList = ProcessorUtils.splitLine(data, 'ç');

        return Sale.builder()
                .idSale(Long.parseLong(resultList.get(1)))
                .items(ItemBuilder.buildListItems(resultList.get(2)))
                .salesmanName(resultList.get(3))
                .total(getTotalSale(ItemBuilder.buildListItems(resultList.get(2))))
                .build();
    }

    private static BigDecimal getTotalSale(List<Item> items){
        return items.stream()
                .map(item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal::add)
                .get();
    }
}
