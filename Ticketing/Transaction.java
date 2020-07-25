import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Transaction {
    public static Scanner scan = new Scanner(System.in);
    static int scanFile(ArrayList<Item> i, String txt, int hold) throws FileNotFoundException {
        File inputFile = new File(txt);
        Scanner readSF = new Scanner(inputFile);
        String holdN;
        double holdP;
        int count = 0;

        while (readSF.hasNext()){
            holdN = readSF.next();
            holdP = Double.parseDouble(readSF.next());

            if (hold == 0) {
                i.add(new Movies(holdN, holdP));
            } else if (hold == 1) {
                i.add(new Food(holdN, holdP));
            }
            count++;
        }
        readSF.close();

        return count;
    }

    static Person newTrans(){
        System.out.println("===================XXICinema===================");
        System.out.print("Welcome to XXI cinema online booking\nMay i know your name please? => ");
        String holdName = scan.nextLine();
        Person p = new Person();
        int holdPromo;
        System.out.println("Hello " + holdName);
        do{
            System.out.print("Are you a Student (insert 1) or not (insert 0)? => ");
            holdPromo = scan.nextInt();
            scan.nextLine();
            if(holdPromo != 0 && holdPromo != 1){
                System.out.println("Sorry please enter either 1 or 0");
            }
        }while(holdPromo != 0 && holdPromo != 1);

        if(holdPromo == 1){
            p = new Student();
        }else if(holdPromo == 0){
            p = new NonStudent();
        }
        p.setName(holdName);
        p.setPromo(holdPromo);

        System.out.println("===============================================");
        return p;
    }

    static void showMenu(){
        System.out.println("====================Welcome====================");
        System.out.println("What would you like to do");
        System.out.println("1. Add movies");
        System.out.println("2. Add Food");
        System.out.println("3. Check Order");
        System.out.println("4. Clear Order");
        System.out.println("5. Checkout");
        System.out.println("6. Quit");
        System.out.println("===============================================");
        System.out.print("Your Choice => ");
    }

    static int choice(Person p, ArrayList<Item> i, int mL, int fL){
        int choice = scan.nextInt();
        scan.nextLine();
        int check = 0; 
        do{
            check = 0; 
            switch(choice){
                case 1:
                    p.addMoives(i, mL);
                    break;
                case 2:
                    p.addFood(i, fL);
                    break;
                case 3:
                    p.printPersonInfo();
                    break;
                case 4:
                    p.clearOrder(i);
                    break;
                case 5:
                    System.out.println("===================CheckOut===================");
                    p.printPersonInfo();
                    System.out.println("You will be redirected to Payment Gateway");
                    System.out.println("===============================================");
                case 6:
                    System.out.println("=====================Exit======================");
                    System.out.println("Thank you for using our system");
                    System.out.println("===============================================");
                    return 0;
                default:
                    check = 1;
            }
        }while(check == 1);

        return 1;
    }

    public static void main(String[] args)throws FileNotFoundException{
        ArrayList<Item> itemList = new ArrayList<Item>();
        int holdM = 0, holdF = 1;

        int MoviLen = scanFile(itemList, "movieList.txt", holdM); // number of title of Movie available
        int FoodLen = scanFile(itemList, "foodList.txt", holdF); // number of kind of Food available
        //int ItemLen = MoviLen + FoodLen;

        Person holdPer = newTrans();
        Ticket t = new Ticket();
        holdPer.setTicket(t);
        holdPer.printPersonInfo();
        
        int check = 1;

        while(check == 1){
            showMenu();
            check = choice(holdPer, itemList, MoviLen, FoodLen);
        }
    }
}