package stub;

import br.com.dataprocessor.outputdata.model.OutputData;

public class OutputStub {

    public static OutputData buildOutputModel(){
        return OutputData.builder()
                .idBiggestSale(2L)
                .nameWorstSalesman("Jonelson")
                .customerQuantity(3)
                .salesmanQuantity(3)
                .build();
    }
}
