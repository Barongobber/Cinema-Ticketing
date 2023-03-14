class Student extends Person {

    private String student_id;

    Student(){
        insertPersonInfo();
    }
    public void insertPersonInfo() {
        System.out.print("Please enter your Student ID => ");
        student_id = Transaction.scan.nextLine();
    }
    public String getIDNumber(){
        return student_id;
    }
    public void printPersonInfo() {
        System.out.println("==================Person-Info==================");
        System.out.print("Name: " + name);
        System.out.println(" - Student");
        System.out.println("StudentID: " + student_id);
        System.out.println("Ticket Price:" + getFinalPrice());
        System.out.println("===============================================");
        ticket.displayOrderInfo();
    }

}