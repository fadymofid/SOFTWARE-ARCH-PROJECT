import java.util.Scanner;

public class Gas implements Billsservices{
    public String BillType="Gas";
    @Override
    public void PayBills(Account account,Bills bills) {
        System.out.println("Gas bill amount: " + bills.amount );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to pay this bill? (yes/no): ");
        String userInput = scanner.next().toLowerCase();

        if ("yes".equals(userInput)) {
            if (account.balance >= bills.amount) {
                // Deduct the billAmount from the account's balance
                account.balance -= bills.amount;
                System.out.println("Payment successful");
            } else {
                System.out.println("Insufficient balance. Payment failed.");
            }
        } else {
            System.out.println("Bill payment canceled");
        }
    }
}
