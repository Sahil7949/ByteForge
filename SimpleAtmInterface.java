import java.util.Scanner;

public class SimpleAtmInterface {
    private static final String USER_PIN = "1234";
    private static double balance = 1000.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your 4-digit PIN: ");
        String inputPin = scanner.nextLine();

        if (!inputPin.equals(USER_PIN)) {
            System.out.println("Invalid PIN. Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: ₹%.2f%n", balance);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("₹%.2f deposited successfully.%n", deposit);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdraw = scanner.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.printf("₹%.2f withdrawn successfully.%n", withdraw);
                    } else {
                        System.out.println("Invalid or insufficient funds.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

