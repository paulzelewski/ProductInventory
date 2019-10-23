class Inventory {

    private ProductDAO productDAO = new MySqlManagerDAO();

    String showInventory(){
        //TODO: just temp
        if(!productDAO.showAllProducts().isEmpty()){
            productDAO.showAllProducts().forEach(
                    product -> System.out.println(product.toString())
            );
        }else {
            return "Inventory is empty";
        }
        return "DAO showAllProducts test ok";
    }

    String addProduct(int id,String name,float price, int quantity){
        productDAO.addProduct(new Product(id, name, price, quantity));
        return "DAO addProduct test success";
    }

    String removeProduct(int id){
        productDAO.removeProduct(id);
        return "DAO removeProduct test ok";
    }

    String addQuantity(int id, int quantity){
        productDAO.increaseQuantity(id, quantity);
        return "test add Qty ok";
    }

    String removeQuantity(int id,int quantity){
        productDAO.decreaseQuantity(id, quantity);
        return "test remove qty";
    }

    String setPrice(int id,float price){
        productDAO.setPrice(id, price);
        return "test setPrice ok";
    }

    String setName(int id,String name){
        productDAO.setName(id, name);
        return "test setPrice ok";
    }

    String productTotalValue(int id){
        //TODO: just temp
        System.out.println(productDAO.productTotalValue(id));
        return "DAO productTotalValue test";
    }

    float inventoryTotalValue(){
        return productDAO.productsTotalValue();
    }

}
