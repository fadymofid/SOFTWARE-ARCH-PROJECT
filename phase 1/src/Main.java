import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        UserServices userServices = new UserImplementation();

        // Dummy users for testing
        userList.add(new User("user1", "password1", new BankAccount(111, 123)));
        //userList.add(new User("user2", "password2", new MobileAcc(222, new VodaCash())));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    User registeredUser = userServices.register(userList);
                    if (registeredUser != null) {
                        userList.add(registeredUser);
                    } else {
                        System.out.println("Registration failed. Please try again.");
                    }
                    break;
                case 2:
                    User loggedInUser = userServices.login(userList);
                    if (loggedInUser != null) {
                        // Perform actions for the logged-in user
                        performUserActions(loggedInUser);
                    } else {
                        System.out.println("Login failed. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Instapay System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void performUserActions(User user) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Transfer to Wallet");
            System.out.println("2. Transfer to Another Instapay account");
            System.out.println("3. Inquire about balance");
            System.out.println("4. Pay bills");
            System.out.println("5. Logout");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    TransferToWallet transferToWallet = new TransferToWallet();
                    transferToWallet.Transfer(user, userList);
                    break;
                case 2:
                    TransferToInstaPay transferToInstaPay = new TransferToInstaPay();
                    transferToInstaPay.Transfer(user, userList);
                    break;
                case 3:
                    System.out.println(user.account.accountServices.balanceEnquire(user.account));
                    break;
                case 4:
                    // Implement bill payment logic
                    payBills(user.getAccount());
                    break;

                case 5:
                    System.out.println("Logging out");
                    return;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }
    }
    private static void payBills(Account account) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose bill type:");
        System.out.println("1. Electricity");
        System.out.println("2. Gas");
        System.out.println("3. Water");

        int billType = scanner.nextInt();

        Bills bill;
        switch (billType) {
            case 1:
                bill = new Bills();
                bill.amount = 100; // Set the amount for electricity bill
                Billsservices electricityService = new Electricity();
                electricityService.PayBills(account, bill);
                break;
            case 2:
                bill = new Bills();
                bill.amount = 80; // Set the amount for gas bill
                Billsservices gasService = new Gas();
                gasService.PayBills(account, bill);
                break;
            case 3:
                bill = new Bills();
                bill.amount = 50; // Set the amount for water bill
                Billsservices waterService = new Water();
                waterService.PayBills(account, bill);
                break;
            default:
                System.out.println("Invalid bill type. Please try again.");
                break;
        }
    }
}
