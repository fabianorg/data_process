package br.com.dataprocessor.inputdata.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Data
@Builder
@AllArgsConstructor
public class InputData {
    private List<Customer> customers;
    private List<Sale> sales;
    private List<Salesman> salesmen;
    private String fileName;

    public InputData(){
        customers = new ArrayList<>();
        sales = new ArrayList<>();
        salesmen = new ArrayList<>();
    }
}
