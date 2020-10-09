package br.com.dataprocessor.service;


import br.com.dataprocessor.inputdata.model.InputData;
import br.com.dataprocessor.outputdata.model.OutputData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import stub.InputDataStub;
import stub.OutputStub;
import stub.SaleStub;

@RunWith(MockitoJUnitRunner.class)
public class SalesServiceTest {

    @InjectMocks
    private SalesService salesService;

    @Test
    public void shouldExtractSales(){
        String lineSale = "003ç04ç[1-10-100,2-30-2.50,3-40-3.10]çLaudelino";
        InputData inputData = InputDataStub.build();

        InputData inputDataReceived = salesService.extractSales(lineSale)
                .apply(inputData);

        Assert.assertEquals(inputData, inputDataReceived);
    }

    @Test
    public void shouldReturnBiggestSale(){
        OutputData outputData = OutputStub.buildOutputModel();
        OutputData outputDataReceived = salesService.getBiggestSale(SaleStub.buildListSaleOFFile())
                .apply(outputData);

        Assert.assertEquals(outputData, outputDataReceived);
    }
}