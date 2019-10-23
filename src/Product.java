public class Product {
    private float price;
    private int id, quantity;
    private String name;


    Product(int id, String name, float price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    int getId(){
        return this.id;
    }

    String getName(){
        return this.name;
    }

    int getQuantity(){
        return this.quantity;
    }

    float getPrice(){
        return this.price;
    }

    public String toString(){
        return String.format("Id: %3d\t\tProduct: %20s\t\tPrice: %10.2f\t\tQty: %5d",
                this.id,this.name,this.price,this.quantity);
    }
}
