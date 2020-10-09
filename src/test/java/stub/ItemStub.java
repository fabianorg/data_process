package stub;

import br.com.dataprocessor.inputdata.model.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemStub {

    public static List<Item> buildItemList(){
        return Arrays.asList(buildItemNumberOne(), buildItemNumberTwo(), buildItemNumberThree());
    }

    public static Item buildItemNumberOne(){
        return Item.builder()
                .price(new BigDecimal(10))
                .quantity(2)
                .idItem(1L)
                .build();
    }

    public static Item buildItemNumberTwo(){
        return Item.builder()
                .idItem(2L)
                .quantity(1)
                .price(new BigDecimal(12))
                .build();
    }

    private static Item buildItemNumberThree(){
        return Item.builder()
                .idItem(3L)
                .quantity(1)
                .price(new BigDecimal(2))
                .build();
    }

    public static List<Item> buildItemListOfSale04(){
        List<Item> items = new ArrayList<>();
        items.add(buildItemNumberFour());
        items.add(buildItemNumberFive());
        items.add(buildItemNumberSix());
        return items;

    }

    private static Item buildItemNumberFour(){
        return Item.builder()
                .idItem(1L)
                .quantity(10)
                .price(new BigDecimal(100))
                .build();

    }

    private static Item buildItemNumberFive(){
        return Item.builder()
                .idItem(2L)
                .quantity(30)
                .price(new BigDecimal(2.50))
                .build();
    }

    private static Item buildItemNumberSix(){
        return Item.builder()
                .idItem(3L)
                .quantity(40)
                .price(new BigDecimal(3.10))
                .build();
    }

    public static List<Item> buildItemListOfSale05(){
        List<Item> items = new ArrayList<>();
        items.add(buildItemNumberSeven());
        items.add(buildItemNumberNine());
        return items;
    }

    private static Item buildItemNumberSeven(){
        return Item.builder()
                .idItem(1L)
                .quantity(34)
                .price(new BigDecimal(10))
                .build();

    }

    private static Item buildItemNumberEight(){
        return Item.builder()
                .idItem(2L)
                .quantity(33)
                .price(new BigDecimal(1.50))
                .build();
    }

    private static Item buildItemNumberNine(){
        return Item.builder()
                .idItem(3L)
                .quantity(40)
                .price(new BigDecimal(3.10))
                .build();
    }
}
