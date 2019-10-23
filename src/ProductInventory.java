import java.util.Scanner;

public class ProductInventory {

    public static void main(String[] args){
        byte option;

        ShowMenuText menu = new ShowMenuText();
        Inventory inventory = new Inventory();

        String welcomeMsg = "\n!!!Welcome to Inventory Manager!!!\n";
        String qId = "Type product id: ";
        String qQty = "Type product quantity: ";
        String qPrice = "Type product price: ";
        String qName = "Type product name: ";

        //you can add new option below, do that in front of "exit" and keep "exit" last array entry
        String[] mainMenu = {"add/remove product", "check inventory","add/remove quantity", "check/set value", "exit"};
        String[] valMenu = {"whole inventory value", "specific product value","change product price",
                "change product name", "exit"};
        String[] productMenu = {"add product","remove product","exit"};
        String[] quantityMenu = {"add quantity","remove quantity","exit"};

        Scanner input = new Scanner(System.in);
        System.out.println(welcomeMsg);
        while(true){
            menu.showMenuText(mainMenu);
            option = input.nextByte();
            if(option==mainMenu.length){
                System.out.println("Closing.., bye!");
                input.close();
                break;
            }
            else if(option==1){

                while (true) {
                    System.out.println("You have chosen to "+mainMenu[0]+".");
                    menu.showMenuText(productMenu);
                    option = input.nextByte();
                    if(option==productMenu.length){
                        break;
                    }else if(option==1) {
                        System.out.print(qId);
                        int id = input.nextInt();
                        input.nextLine();
                        System.out.print(qName);
                        String name = input.nextLine();
                        System.out.print(qPrice);
                        float price = input.nextFloat();
                        System.out.print(qQty);
                        int quantity = input.nextInt();
                        inventory.addProduct(id,name,price,quantity);
                    }else if(option==2){
                        System.out.println(qId);
                        int id = input.nextInt();
                        inventory.removeProduct(id);
                    }else{
                        menu.showMenuError(option);
                    }
                }
            }
            else if(option==2){
                System.out.println("You have chosen to "+mainMenu[1]+".");
                System.out.println(inventory.showInventory());
            }
            else if(option==3){
                while (true){
                    menu.showMenuText(quantityMenu);
                    option = input.nextByte();
                    if(option==quantityMenu.length){
                        break;
                    }else if(option==1||option==2){
                        System.out.print(qId);
                        int id = input.nextInt();
                        System.out.print(qQty);
                        int quantity = input.nextInt();
                        if(option==1)
                            System.out.println(inventory.addQuantity(id,quantity));
                        if(option==2)
                            inventory.removeQuantity(id,quantity);
                    }
                    else menu.showMenuError(option);
                }
            }
            else if(option==4){
                System.out.println("You have chosen to "+mainMenu[2]+".");
                while(true) {
                    menu.showMenuText(valMenu);
                    option = input.nextByte();
                    if (option == valMenu.length) {
                        break;
                    } else if (option == 1) {
                        float sum=inventory.inventoryTotalValue();
                        System.out.println("Whole inventory value is equal to "+sum+"\n");
                    } else if (option == 2) {
                        System.out.print(qId);
                        int id = input.nextInt();
                        inventory.productTotalValue(id);
                    } else if (option == 3) {
                        System.out.print(qId);
                        int id = input.nextInt();
                        System.out.print(qPrice);
                        float price = input.nextFloat();
                        inventory.setPrice(id, price);
                    }else if(option == 4){
                        System.out.print(qId);
                        int id = input.nextInt();
                        input.nextLine();
                        System.out.print(qName);
                        String name = input.nextLine();
                        inventory.setName(id,name);
                    } else {
                        menu.showMenuError(option);
                    }
                }
            }
            else{
                menu.showMenuError(option);
            }
        }
    }
}
