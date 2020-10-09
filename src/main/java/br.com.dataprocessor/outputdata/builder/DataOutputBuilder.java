package br.com.dataprocessor.outputdata.builder;

import br.com.dataprocessor.outputdata.model.OutputData;

public class DataOutputBuilder {

    private static final String SEPARATOR = "ç";

    public static String buildStringToSave(OutputData outputData){
        StringBuilder sb = new StringBuilder();
        sb.append(outputData.getCustomerQuantity().toString()).append(SEPARATOR);
        sb.append(outputData.getSalesmanQuantity()).append(SEPARATOR);
        sb.append(outputData.getIdBiggestSale()).append(SEPARATOR);
        sb.append(outputData.getNameWorstSalesman());
        return sb.toString();
    }
}
