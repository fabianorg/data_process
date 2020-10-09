package br.com.dataprocessor.service;

import br.com.dataprocessor.inputdata.model.Customer;
import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.inputdata.model.Salesman;
import br.com.dataprocessor.outputdata.File;
import br.com.dataprocessor.outputdata.builder.DataOutputBuilder;
import br.com.dataprocessor.outputdata.model.OutputData;

import java.io.IOException;
import java.util.List;
import java.util.function.UnaryOperator;

public class DataOutputService {

    private SalesService salesService;
    private SalesmanService salesmanService;

    public DataOutputService() {
        this.salesService = new SalesService();
        this.salesmanService = new SalesmanService();
    }

    public OutputData processOutput(OutputData outputData, InputData inputData){
            outputData.setFileName(inputData.getFileName());
            return getTotalCustomers(inputData.getCustomers())
                    .andThen(getTotalSalesman(inputData.getSalesmen()))
                    .andThen(salesService.getBiggestSale(inputData.getSales()))
                    .andThen(salesmanService.getWorstSalesman(inputData.getSales()))
                    .apply(outputData);
    }

    private UnaryOperator<OutputData> getTotalCustomers(List<Customer> customers){
        return (OutputData outputData) ->{
            outputData.setCustomerQuantity(customers.size());
            return outputData;
        };
    }

    private UnaryOperator<OutputData> getTotalSalesman(List<Salesman> salesmen){
        return (OutputData outputData) -> {
            outputData.setSalesmanQuantity(salesmen.size());
            return outputData;
        };
    }

    public OutputData save(OutputData outputData){
        try {
            File.save(DataOutputBuilder.buildStringToSave(outputData), outputData.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputData;
    }
}
