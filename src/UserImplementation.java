import java.util.List;
import java.util.Scanner;

public  class UserImplementation implements UserServices{

    @Override
    public User verifyUser(User user, List<User> users) {
        for (User existingUser : users) {
            if (existingUser.username.equals(user.username) && existingUser.password.equals(user.password)) {
                return existingUser;  // Return the matching User object
            }
        }
        return null;  // User not found in the list
    }


    @Override
    public User register( List<User> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.next();
        User user = new User(username,password);


        System.out.println("Choose registration method:");

        System.out.println("1. Bank Account");
        System.out.println("2. Wallet Provider");
        int accountType = scanner.nextInt();


            if (accountType == 1) {
                System.out.println("Please enter your Bank Phone number");
                int phone = scanner.nextInt();
                System.out.println("Please enter your Bank number");
                int bankNumber = scanner.nextInt();
                user.account = new BankAccount(phone, bankNumber);
                user.account.accountServices = new BankAccServices(); // Initialize account services
                user.account.accountServices.setAccountType(user.account);
                user.account.accountServices.mobilenumberVerification(user.account, phone);
                if (user.account.accountServices.verify(user.account)) {
                    System.out.println("Bank account verified.");
                } else {
                    System.out.println("Bank account verification failed.");
                    // Handle failure, maybe re-run registration or exit
                }
            }
            else if (accountType == 2) {
                System.out.println("Please enter your Mobile number");
                int mobileNumber = scanner.nextInt();

                WalletProvider walletProvider = new VodaCash();
                if (walletProvider != null) {
                    user.account = new MobileAcc(mobileNumber);
                    user.account.accountServices = new mobilewalletservice(); // Initialize account services
                    user.account.accountServices.setAccountType(user.account);
                    user.account.accountServices.mobilenumberVerification(user.account, mobileNumber);
                    if (user.account.accountServices.verify(user.account)) {
                        System.out.println("Wallet account registered and verified.");
                    } else {
                        System.out.println("Wallet account registration and verification failed.");
                        // Handle failure, maybe re-run registration or exit
                    }
                } else {
                    System.out.println("Invalid wallet provider. Wallet account registration failed.");
                }
            }




        return user;
    }
    @Override
    public User login(List<User> users) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.next();

        User loginUserCredentials = new User(username, password);

        User loggedInUser = verifyUser(loginUserCredentials, users);

        if (loggedInUser != null) {
            System.out.println("Login successful!");
            return loggedInUser;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return null;
        }
    }


    @Override
    public void logout() {

    }
}
