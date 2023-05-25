/*----------------------------------------------------------------         
                  OASIS INFOBYTE  
                JAVA DEVELOPEMENT INTERNSHIP
                  SIDDHIKA MUNDADA
	            TASK #3 :- ATM INTERFACE
 ----------------------------------------------------------------*/
 import java.util.Scanner; 
 import java.util.HashMap; 
 import java.util.Map;

 class ATM { private double balance;
 
 public double getBalance() {
     return balance;
 }
 
 public void setBalance(double balance) {
     this.balance = balance;
 }
 }
 
 interface AtmOperationInterface { public void viewBalance(); public void withdraw_Amount(double withdraw_Amount); public void deposit_Amount(double deposit_Amount ); public void viewMiniStatement(); }
 
 class AtmOperation implements AtmOperationInterface{ ATM atm = new ATM(); Map<Double,String> ministmt=new HashMap<>(); @Override public void viewBalance() { System.out.println("Available Balance is : "+atm.getBalance());
 
 }
 
 @Override
 public void withdraw_Amount(double withdraw_Amount) {
     if(withdraw_Amount%500==0) {
         if (withdraw_Amount <= atm.getBalance()) {
             ministmt.put(withdraw_Amount, " Amount Withdrawn");
             System.out.println("Collect the Cash " + withdraw_Amount);
             atm.setBalance(atm.getBalance() - withdraw_Amount);
             viewBalance();
         } else {
             System.out.println("Insufficient Balance !!");
         }
     }
     else {
         System.out.println("Please enter the amount in multipal of 500 !!");
     }
 
 }
 
 @Override
 public void deposit_Amount(double deposit_Amount) {
     ministmt.put(deposit_Amount," Amount Deposited !!");
     System.out.println(deposit_Amount+" Deposited Successfully !!");
     atm.setBalance(atm.getBalance()+deposit_Amount);
     viewBalance();
 
 }
 
 @Override
 public void viewMiniStatement() {
     for(Map.Entry<Double,String> m:ministmt.entrySet()){
         System.out.println(m.getKey()+""+m.getValue());
     }
 
 }
 }
 
 public class Task3 { public static void main(String[] args) { AtmOperationInterface operation = new AtmOperation(); int atmnumber=78945; int atmpin=720; 
    Scanner in = new Scanner(System.in); 
    System.out.println("Welcome to ATM Machine !!!"); 
    System.out.print("Enter The ATM Number : "); 
    int atmNumber = in.nextInt(); 
        System.out.print("Enter Pin: "); 
            int pin = in.nextInt();
 
     if((atmnumber==atmNumber)&&(atmpin==pin)){
         while(true){
             System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
             System.out.println("Enter Choice : ");
             int ch=in.nextInt();
             if(ch==1){
                 operation.viewBalance();
                 System.out.println();
 
             }
             else if(ch==2){
                 System.out.println("Enter amount to withdraw ");
                 double withdrawAmount=in.nextDouble();
                 operation.withdraw_Amount(withdrawAmount);
                 System.out.println();
             }
             else if(ch==3){
                 System.out.println("Enter Amount to Deposit :");
                 double depositAmount=in.nextDouble();
                 operation.deposit_Amount(depositAmount);
                 System.out.println();
 
             }
             else if(ch==4){
                 operation.viewMiniStatement();
                 System.out.println();
             }
             else if(ch==5){
                 System.out.println("Collect your ATM Card\n Thank you for using ATM Machine!!");
                 System.exit(0);
             }
             else
             {
                 System.out.println("Please enter correct choice!!");
             }
         }
     }
     else{
         System.out.println("Incorrect Atm Number or pin!!");
         System.exit(0);
     }
 
 
 }
 }
