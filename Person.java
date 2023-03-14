import java.util.*;
class Person {
    protected String name;
    protected int promo;
    protected Ticket ticket;

    Person(){
        name = null;
        promo = 0;
        ticket = null;
    }

    public void captureInfo(){ 
        System.out.print("Enter your name:");
        name = Transaction.scan.nextLine();
        System.out.print("Are you a student(1)? or Not(0):");
        promo = Transaction.scan.nextInt();
    }
    public void setName(String newName) {
        name = newName;
    }
    public void setPromo(int _promo){
        promo = _promo;
    }
    public String getName() {
        return name;
    }
    public double getPromo(){
        return promo;
    }
    public String getIDNumber(){
        return null;
    }
    public Ticket getTicket(){
        return ticket;
    }

    public void purchase() {
        
    }
    public void exchange() {

    }
    public void setTicket(Ticket t) {
        ticket = t;
    }
    public double getFinalPrice() {
        if(ticket == null || ticket.getItems() == null){
            return 0;
        }else{ 
            return ticket.getTotPrice() - promo * ticket.getTotPrice() / 10; // Promo 90% for Student 
        } 
    }
    public void printPersonInfo(){
        System.out.println("==================Person-Info==================");
        System.out.println("Name: " + name);
        System.out.println("Ticket Price: " + getFinalPrice());
        System.out.println("===============================================");
        ticket.displayOrderInfo();
    }

	public void addMoives(ArrayList<Item> i, int mL){
        System.out.println("==================Add-Movies===================");
        ticket.showMoviesAir(i, mL);
        ticket.addMovies(i, mL);
        System.out.println("===============================================");
	}

	public void addFood(ArrayList<Item> i, int fL){
        System.out.println("===================Add-Food====================");
        ticket.showFoodAvailable(i, fL);
        ticket.addFood(i, fL);
        System.out.println("===============================================");
	}

	public void clearOrder(ArrayList<Item> i){
        ticket.clearOrder(i);
	}
}