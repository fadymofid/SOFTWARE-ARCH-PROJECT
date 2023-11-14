import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class User {
    public String username;
    public String password;
    Account account;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void register() {
        System.out.println("Choose registration method:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Bank Account");
        System.out.println("2. Wallet Provider");
        int accountType = scanner.nextInt();

        if (accountType == 1) {
            System.out.println("Please enter your Bank Phone number");
            int phone = scanner.nextInt();
            System.out.println("Please enter your Bank number");
            int bankNumber = scanner.nextInt();

            // Create BankAccount instance and set user's balance
            account = new BankAccount(phone, bankNumber);
            account.setAccountType();
            account.mobilenumberVerification(account);

            // Additional steps for bank verification
            if (((BankAccount) account).verifyBank()) {
                System.out.println("Bank account verified.");
            } else {
                System.out.println("Bank account verification failed.");
                return;
            }

        } else if (accountType == 2) {
            // Register using wallet provider (not implemented in this example)
        } else {
            System.out.println("Invalid registration method");
            return;
        }


    }
}