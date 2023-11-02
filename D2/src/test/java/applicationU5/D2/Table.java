package applicationU5.D2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
@AllArgsConstructor
public class Table {
    private int tableId;
    private TableStatus stato;
    private int numeroPosti;


    public void changeTableStatus(){
        if(getStato() == TableStatus.OCCUPATO){
            this.stato = TableStatus.LIBERO;
        }else {
            this.stato = TableStatus.OCCUPATO;
        }
    }


    @Override
    public String toString() {
        return "table n." + tableId + " " + stato;
    }
}
