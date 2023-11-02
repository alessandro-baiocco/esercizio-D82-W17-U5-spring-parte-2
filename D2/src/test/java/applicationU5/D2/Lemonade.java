package applicationU5.D2;


public class Lemonade extends MenuElement implements Drink {
    private String name;
    private double quantity;


    public Lemonade(int calories, double price , String name , double quantity) {
        super(calories, price);
        this.name = name;
        this.quantity = quantity;


    }

    @Override
    public String toString() {
        return  name + " " + quantity + "L " + super.toString();
    }
}
