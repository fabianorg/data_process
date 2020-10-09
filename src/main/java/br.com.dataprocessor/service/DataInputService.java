package br.com.dataprocessor.service;

import br.com.dataprocessor.inputdata.extractor.DataExtractor;
import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.util.ProcessorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataInputService {

    private SalesmanService salesmanService;
    private CustomerService customerService;
    private SalesService salesService;

    private static final Logger logger = LoggerFactory.getLogger(DataInputService.class);

    public DataInputService() {
        this.salesmanService = new SalesmanService();
        this.customerService = new CustomerService();
        this.salesService = new SalesService();

    }

    public InputData extractor(InputData inputData, String file){
        inputData.setFileName(ProcessorUtils.extractFileName(file));
        DataExtractor.extractDataFromFile(file)
                    .forEach(singleFile-> {
                        logger.info("Extraction file: "+file+": line: "+singleFile);
                        extractDataByIdentifier(singleFile, inputData);
                    });
        return inputData;
    }

    private void extractDataByIdentifier(String data, InputData inputData){
        salesmanService.extractSalesman(data)
                .andThen(customerService.extractCustomer(data))
                .andThen(salesService.extractSales(data))
                .apply(inputData);
    }

    public void clearList(InputData inputData){
        inputData.getCustomers().clear();
        inputData.getSales().clear();
        inputData.getSalesmen().clear();
    }
}
