package br.com.dataprocessor.inputdata.builder;

import br.com.dataprocessor.inputdata.model.Item;
import br.com.dataprocessor.util.ProcessorUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ItemBuilder {

    public static List<Item> buildListItems(String data){
        data = ProcessorUtils.removeSquareBrackets(data);
        List<String> resultList = ProcessorUtils.splitLine(data, ',');

        return resultList.stream()
                    .map(ItemBuilder::buildItemModel)
                    .collect(Collectors.toList());
    }

    private static Item buildItemModel(String data){
        List<String> resultList = ProcessorUtils.splitLine(data, '-');

        return Item.builder()
                .idItem(Long.parseLong(resultList.get(0)))
                .quantity(Integer.parseInt(resultList.get(1)))
                .price(new BigDecimal(resultList.get(2)))
                .build();
    }


}
