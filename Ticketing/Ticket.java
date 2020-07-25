import java.util.*;

public class Ticket {
    double totalPrice;
    int totalItem;
    ArrayList<Item> ticketItemList;
    ArrayList<Integer> ItemQuantity;

    public Ticket(){
        totalPrice = 0;
        totalItem = 0;
        ticketItemList = new ArrayList<Item>();
        ItemQuantity = new ArrayList<Integer>();
    }
        
    public double getTotPrice (){ // return total price that would be bought
        double x=0;
        for (int i = 0; i < ticketItemList.size(); i++){
        x += ticketItemList.get(i).getPrice() * ItemQuantity.get(i);
        }
        totalPrice = x;
        return totalPrice;
    }
    
    public int getTotItem(){    // return total item that would be bought
        return ticketItemList.size();
    }
	public ArrayList<Item> getItems() {
		return ticketItemList;
    }

    public void showMoviesAir(ArrayList<Item> _i, int mL){
        System.out.println("================Movies Airing==================");
        for(int i = 0; i < mL; i++){
            System.out.println((i+1) + ". " + _i.get(i).getName() + " - RM " + _i.get(i).getPrice());
        }
        System.out.println("===============================================");
    }

    public void showFoodAvailable(ArrayList<Item> _i, int fL){
        int a = _i.size() - fL;
        int b=1;
        System.out.println("================Food Available================");
        for (int i= a ; i < _i.size(); i++){

            System.out.println((b) + ". "+ _i.get(i).getName() + " - RM "+ _i.get(i).getPrice());
            b++;
        }
        System.out.println("===============================================");
    }

	public void addMovies(ArrayList<Item> _i, int mL) {
        int choice;
        do{
            choice = Transaction.scan.nextInt();
            if(choice < 1 || choice > mL){ 
                choice = 0;
                System.out.println("Please enter the Movies number from the list");
        }}while(choice == 0);

        Item holdItem = _i.get(choice-1);
        int numItem = checkAvailability(holdItem);
        if(numItem != 0){
            ticketItemList.add(holdItem);
            holdItem.setQuantity(holdItem.getQuantity() - numItem);
            ItemQuantity.add(numItem);
        }
    }

	public void addFood(ArrayList<Item> _i, int fL){
        int choice;
        int a = _i.size() - fL;
        do{
            choice = Transaction.scan.nextInt();
            if(choice < 1 || choice > fL){
                choice = 0;
                System.out.println("Please enter the correct food based on the list");
            }
        } while(choice == 0);

        Item holdItem = _i.get(a+(choice-1));
        int numItem = checkAvailability(holdItem);
        if(numItem != 0){
            ticketItemList.add(holdItem);
            holdItem.setQuantity(holdItem.getQuantity() - numItem);
            ItemQuantity.add(numItem);
        }
    }

    public int checkAvailability(Item i){
        if(i.getQuantity() <= 0){ 
            System.out.println("Sorry " + i.getName() + " is sold out and not available");
            return 0; 
        }else{ System.out.println("Total number of " + i.getName() + " Available is " + i.getQuantity()); }
        int check = 0;
        while(check != 1){
            System.out.println("Please enter how much you wanted to buy " + i.getName());
            int choice = Transaction.scan.nextInt();
            if(i.getQuantity() - choice >= 0){
                check = 1;
                return choice;
            }else{ System.out.println("Sorry that's more than what we have in stock right now please try again");}
        }
        return 0;
    }

    public void displayOrderInfo() {
        
        double totalAll =0;
        System.out.println("===================YourOrder===================");
        if(ticketItemList == null || ticketItemList.size() == 0){
            System.out.println("                       -                       ");
        }else{
            for (int i = 0; i < ticketItemList.size(); i++) {
                if (ticketItemList.get(i) instanceof Movies) {
                    System.out.print("Movie: ");
                } else if (ticketItemList.get(i) instanceof Food) {
                    System.out.print("Food: ");
                }System.out.println(ticketItemList.get(i).getName() + " - " + ItemQuantity.get(i) + " - RM" + ItemQuantity.get(i) * ticketItemList.get(i).getPrice());
                totalAll += (ticketItemList.get(i).getPrice() * ItemQuantity.get(i));
            }
        }
        System.out.println("Total Order Price= " + totalAll);
        System.out.println("===============================================");
    }

	public void clearOrder(ArrayList<Item> _i){
        Item holdItemTicket;
        Item holdItemMain;
        for(int i = 0; i < ticketItemList.size(); i++){
            holdItemTicket = ticketItemList.get(i);
            holdItemMain = _i.get(_i.indexOf(holdItemTicket)); 
            holdItemMain.setQuantity(holdItemMain.getQuantity() + ItemQuantity.get(i));
        }
        ticketItemList = new ArrayList<Item>();
        ItemQuantity = new ArrayList<Integer>();
        System.out.println("Your order has been cleared");
	}
}
