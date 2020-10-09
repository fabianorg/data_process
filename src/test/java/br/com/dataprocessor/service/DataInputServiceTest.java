package br.com.dataprocessor.service;


import br.com.dataprocessor.inputdata.model.InputData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import stub.InputDataStub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataInputServiceTest {

    @InjectMocks
    private DataInputService dataInputService;

    @Mock
    private SalesmanService salesmanService;

    @Mock
    private CustomerService customerService;

    @Mock
    private SalesService salesService;

    @Test
    public void shouldClearLists(){
        InputData inputData = InputDataStub.build();

        dataInputService.clearList(inputData);

        Assert.assertTrue(inputData.getCustomers().isEmpty());
        Assert.assertTrue(inputData.getSalesmen().isEmpty());
        Assert.assertTrue(inputData.getSales().isEmpty());

    }


    @Test
    public void shouldExtractDataFromFIle() {
        String file = "src/test/resources/fileIn";

        when(salesmanService.extractSalesman(any())).thenReturn(functionMock());
        when(customerService.extractCustomer(anyString())).thenReturn(functionMock());
        when(salesService.extractSales(anyString())).thenReturn(functionMock());

        InputData extractor = dataInputService.extractor(InputDataStub.build(), file);

        Assert.assertNotNull(extractor);

    }

    private Function<InputData, InputData> functionMock(){
        return (InputData input) -> InputDataStub.build();
    }

}