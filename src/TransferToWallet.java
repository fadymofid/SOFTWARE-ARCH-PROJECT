import java.util.List;
import java.util.Scanner;

public class TransferToWallet implements Transactions{

    @Override

        public void Transfer (User sender , List<User> userlist ) {
            Scanner scanner = new Scanner(System.in);


            double amount;
            do {
                System.out.println("Enter the amount you want to transfer:");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid amount:");
                    scanner.next();
                }
                amount = scanner.nextDouble();
            } while (amount < 0);


            if (sender.getAccount().getbalance() < amount) {
                System.out.println("Insufficient funds. Transfer failed.");
                return;
            }

            System.out.println("Enter the username of the account you want to transfer to:");
            String receiverUsername = scanner.next();


            User receiver = findUserByUsername(receiverUsername, userlist);

            if (receiver == null) {
                System.out.println("Receiver not found. Transfer failed.");
                return;
            }
            double newamountincrease=receiver.getAccount().getbalance()+amount;
            double newamountdecrease=sender.getAccount().getbalance()-amount;

        if(sender.getAccount().getAccountType().toString().equals("BankAccount"))
        {
            sender.getAccount().getAccountServices().settransbalance(newamountdecrease,sender.getAccount());
            receiver.getAccount().getAccountServices().settransbalance(newamountincrease,receiver.getAccount());
        }
        if(sender.getAccount().getAccountType().toString().equals("Walletaccount"))
        {
            sender.getAccount().getAccountServices().settransbalance(newamountdecrease,sender.getAccount());
            receiver.getAccount().getAccountServices().settransbalance(newamountincrease,receiver.getAccount());
        }

    }

    private User findUserByUsername(String username ,List<User> userlist) {

        for (User user : userlist) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        // Return null if the user is not found
        return null;
    }
    }
