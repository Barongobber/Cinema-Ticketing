class NonStudent extends Person {
    private String ID_number;

    NonStudent(){
        insertPersonInfo();
    }
    public void insertPersonInfo() {
        System.out.print("Please enter your ID number => ");
        ID_number = Transaction.scan.nextLine();
    }
    public String getIDNumber() {
        return ID_number;
    }
    public void printPersonInfo() {
        System.out.println("==================Person-Info==================");
        System.out.print("Name: " + name);
        System.out.println(" - NonStudent");
        System.out.println("ID Number: " + ID_number);
        System.out.println("Ticket Price:" + getFinalPrice());
        System.out.println("===============================================");
        ticket.displayOrderInfo();
    }
}