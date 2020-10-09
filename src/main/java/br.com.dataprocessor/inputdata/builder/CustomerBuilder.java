package br.com.dataprocessor.inputdata.builder;

import br.com.dataprocessor.inputdata.model.Customer;
import br.com.dataprocessor.util.ProcessorUtils;

import java.util.List;

public class CustomerBuilder {

    public static Customer build(String data){
        List<String> resultList = ProcessorUtils.splitLine(data, 'ç');
        return Customer.builder()
                .cnpj(resultList.get(1))
                .name(resultList.get(2))
                .businessArea(resultList.get(3))
                .build();
    }
}
