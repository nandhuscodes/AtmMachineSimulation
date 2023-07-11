import java.util.Scanner;
class Bank{
    private int balance = 60000;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
class ATM{
    Bank bank = new Bank();
    int balance = bank.getBalance();
    void deposit(int depositAmount) throws InvalidAmountException{
        if(depositAmount<=0){
            throw new InvalidAmountException("Deposit amount zero or less than zero is not permitted");
        }else{
            System.out.println("Amount deposited successfully");
            balance += depositAmount;
            System.out.println("Your current account balance: "+balance);
        }
    }

    void withdraw(int withdrawAmount) throws InsufficientFundException,InvalidAmountException{
        if(withdrawAmount>balance){
            throw new InsufficientFundException("Your current balance is "+balance+". So please enter less than equal withdrawal amount");
        }else if(withdrawAmount<=0){
            throw new InvalidAmountException("Withdrawal amount zero or less than zero is not permitted");
        }else{
            System.out.println("Amount withdrawn successfully");
            balance-=withdrawAmount;
            System.out.println("Your current account balance: "+balance);
        }
    }
    void displayBalance(){
        System.out.println("Your current account balance: "+balance);
    }
}
public class AtmMachineSimulation {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATM atm = new ATM();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while(choice!=4){
            try{
                System.out.println("\n\t Choose one option to process\n1.) Deposit amount\n2.) Withdraw Amount\n3.) Account Balance\n4.) Exit\n");
                choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.print("Enter amount your amount to deposit: ");
                        atm.deposit(scanner.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter amount your amount to withdraw: ");
                        atm.withdraw(scanner.nextInt());
                        break;
                    case 3:
                        atm.displayBalance();
                        break;
                }
            } catch (InsufficientFundException | InvalidAmountException errorMessage){
                System.out.println(errorMessage);
            }
        }
    }
}
class InsufficientFundException extends Exception {
    public InsufficientFundException(String errorMessage) {
        super(errorMessage);
    }
}
class InvalidAmountException extends Exception {
    public InvalidAmountException(String errorMessage) {
        super(errorMessage);
    }
}