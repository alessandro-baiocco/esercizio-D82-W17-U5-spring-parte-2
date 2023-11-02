package applicationU5.D2;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Order {

    private List<MenuElement> listaOrdine;
    private Table table;
    private OrderStatus stato;
    private double total;

    public Order(List<MenuElement> listaOrdine, Table table, OrderStatus stato , double total) {
        this.listaOrdine = listaOrdine;
        this.table = table;
        this.stato = stato;
        this.total = total;
    }

    @Override
    public String toString() {
        return "table n." + table +
                "listaOrdine=" + listaOrdine +
                "|" + stato + "|"
                + "totale = " + total;
    }
}
