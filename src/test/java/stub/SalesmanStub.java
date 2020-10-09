package stub;

import br.com.dataprocessor.inputdata.model.Salesman;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalesmanStub {

    public static Salesman buildSalesman1(){
        return Salesman.builder()
                .cpf("1234567891444")
                .name("Jonelson II")
                .salary(new BigDecimal("50000"))
                .build();
    }

    public static Salesman buildSalesman2(){
        return Salesman.builder()
                .cpf("3245678865555")
                .name("Laudelino")
                .salary(new BigDecimal("40000.98"))
                .build();
    }

    public static List<Salesman> buildList(){
        List<Salesman> salesmen = new ArrayList<>();
        salesmen.add(buildSalesman1());
        salesmen.add(buildSalesman2());
        return salesmen;
    }
}