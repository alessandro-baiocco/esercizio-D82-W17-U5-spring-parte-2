package applicationU5.D2.entities;

import applicationU5.D2.enums.TableStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Table {
    private int tableId;
    private TableStatus stato;


    @Override
    public String toString() {
        return "table n." + tableId + " " + stato;
    }
}
