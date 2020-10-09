package br.com.dataprocessor.service;

import br.com.dataprocessor.inputdata.model.InputData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import stub.CustomerStub;
import stub.InputDataStub;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void shouldExtractCustomer(){
        String fileCustomer = "002ç2345675434544999çCliente 999çRural";

        InputData inputData = customerService.extractCustomer(fileCustomer).apply(InputDataStub.build());
        InputData inputDataStub = InputDataStub.build();
        inputDataStub.getCustomers().add(CustomerStub.buildCustomer1());

        Assert.assertEquals(inputData, inputDataStub);
    }
}