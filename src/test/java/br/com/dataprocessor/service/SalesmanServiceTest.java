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
import stub.SalesmanStub;

@RunWith(MockitoJUnitRunner.class)
public class SalesmanServiceTest {

    @InjectMocks
    private SalesmanService salesmanService;

    @Test
    public void shouldReturnSalesman() {
        String lineSalesman = "001ç3245678865555çLaudelinoç40000.98";

        InputData inputData = salesmanService.extractSalesman(lineSalesman).apply(InputDataStub.build());
        InputData inputStub = InputDataStub.build();
        inputStub.getSalesmen().add(SalesmanStub.buildSalesman2());

        Assert.assertEquals(inputData, inputStub);
    }


    @Test
    public void shouldReturnWorstSalesman() {

        OutputData outputData = salesmanService
                .getWorstSalesman(SaleStub.buildListSaleStub()).apply(OutputStub.buildOutputModel());

        Assert.assertEquals(outputData.getNameWorstSalesman(), "Jonelson");

    }
}