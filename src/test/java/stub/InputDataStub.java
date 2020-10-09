package stub;

import br.com.dataprocessor.inputdata.model.InputData;

public class InputDataStub {

    public static InputData build(){
        return InputData.builder()
                .customers(CustomerStub.buildList())
                .sales(SaleStub.buildListSaleOFFile())
                .salesmen(SalesmanStub.buildList())
                .build();
    }
}
