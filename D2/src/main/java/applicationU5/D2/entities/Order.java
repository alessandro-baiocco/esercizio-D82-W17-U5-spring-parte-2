package applicationU5.D2.entities;

import applicationU5.D2.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
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
                "listaOrdine=" + listaOrdine
                + "totale = " + total;
    }
}
