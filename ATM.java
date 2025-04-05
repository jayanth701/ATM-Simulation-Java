import java.util.*;

class User {
    String name;
    String accountNumber;
    String pin;
    double balance;

    User(String name, String accountNumber, String pin, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }
}

public class ATM {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        // Sample user for testing
        users.put("123456", new User("Jayanth", "123456", "1234", 10000));

        System.out.println("Welcome to ATM Simulation System");
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();

        if (!users.containsKey(accNum)) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();
        User user = users.get(accNum);

        if (!user.pin.equals(pin)) {
            System.out.println("Incorrect PIN.");
            return;
        }

        int choice;
        do {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: Rs." + user.balance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    user.balance += deposit;
                    System.out.println("Amount Deposited Successfully.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw > user.balance) {
                        System.out.println("Insufficient Balance.");
                    } else {
                        user.balance -= withdraw;
                        System.out.println("Please collect your cash.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
