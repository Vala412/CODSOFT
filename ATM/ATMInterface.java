package ATM;
import java.util.Scanner;

public class ATMInterface {

    private BankAccount account;

    public ATMInterface(BankAccount bankAccount){
        account = bankAccount;
    }

    public void display(){
        System.out.println("========================================");
        System.out.println("Welcome to ATM Interface");
        System.out.println("========================================");
        System.out.println("Please insert your card");
        System.out.println("========================================");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Exit");
        System.out.println("========================================");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            display();
            System.out.println("Select an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw: ");
                    double amount = sc.nextDouble();
                    if (account.withdraw(amount)){
                        System.out.println("Amount withdrawn successfully. Your balance: Rs. " + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Amount deposited successfully. Your balance: Rs. " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using ATM Interface.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
    public static void main(String[] args){
        BankAccount account = new BankAccount(10000);
        ATMInterface atm = new ATMInterface(account);
        atm.run();
    }
}

class  BankAccount{
        private double balance;

        public BankAccount(double balance){
            this.balance = balance;
        }

        public double getBalance(){
            return balance;
        }

        public void deposit(double amount){
            balance += amount;
        }

        public boolean withdraw(double amount){
            if (amount <= balance){
                balance -= amount;
                return true;
            }
            return false;
        }
    
}
