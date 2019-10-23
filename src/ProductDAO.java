import java.util.List;

interface ProductDAO {
    List<Product> showAllProducts();
    void addProduct(Product product);
    void removeProduct(int id);
    void increaseQuantity(int id, int quantity);
    void decreaseQuantity(int id, int quantity);
    void setPrice(int id, float price);
    void setName(int id, String name);
    float productTotalValue(int id);
    float productsTotalValue();
}
