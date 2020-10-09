package br.com.dataprocessor.service;

import br.com.dataprocessor.inputdata.builder.CustomerBuilder;
import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.type.IdentifierEnum;

import java.util.function.Function;

public class CustomerService {

    public Function<InputData, InputData> extractCustomer(String data){
        return (InputData inputData) -> {
            if (data.startsWith(IdentifierEnum.CUSTOMER.identifier)){
                inputData
                        .getCustomers()
                        .add(CustomerBuilder.build(data));
            }
            return inputData;
        };
    }

}
