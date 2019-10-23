public class ShowMenuText {

    public void showMenuText(String[] menu) {

        for (int i = 0; i < menu.length ; i++) {//creates options menu
            System.out.println((i+1)+" - "+menu[i]);
        }
        System.out.print("\nWhat do you want to do? ");

    }

    public void showMenuError(byte option){
        System.out.println("You have chosen incorrect option: "+option+"\n");
    }
}
