package stub;

import br.com.dataprocessor.inputdata.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerStub {

    public static Customer buildCustomer1(){
        return Customer.builder()
                .name("Cliente 999")
                .businessArea("Rural")
                .cnpj("2345675434544999")
                .build();

    }

    public static Customer buildCustomer2(){
        return Customer.builder()
                .name("Cliente 888")
                .businessArea("Rural")
                .cnpj("2345675433444888")
                .build();

    }

    public static List<Customer> buildList(){
        List<Customer> customers = new ArrayList<>();
        customers.add(buildCustomer1());
        customers.add(buildCustomer2());
        return customers;
    }
}
