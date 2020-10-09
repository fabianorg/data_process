package br.com.dataprocessor.service;


import br.com.dataprocessor.outputdata.model.OutputData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import stub.InputDataStub;
import stub.OutputStub;
import stub.SaleStub;

import java.util.function.UnaryOperator;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataOutputServiceTest {

    @InjectMocks
    private DataOutputService dataOutputService;

    @Mock
    private SalesService salesService;

    @Mock
    private SalesmanService salesmanService;

    @Test
    public void shouldProcessToOutput(){

        when(salesService.getBiggestSale(SaleStub.buildListSaleOFFile()))
                .thenReturn(unaryOperatorMock());

        when(salesmanService.getWorstSalesman(SaleStub.buildListSaleOFFile())).thenReturn(unaryOperatorMock());

        dataOutputService.processOutput(OutputStub.buildOutputModel(), InputDataStub.build());

    }

    private UnaryOperator<OutputData> unaryOperatorMock(){
        return (OutputData outputData) -> OutputStub.buildOutputModel();
    }
}