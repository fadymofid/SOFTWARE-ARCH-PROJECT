import java.util.Scanner;

public class Water implements Billsservices {
    public String BillType="Water";
    @Override
    public void PayBills(Account account,Bills bills) {
        System.out.println("Water bill amount: " + bills.amount + " pounds");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to pay this bill? (yes/no): ");
        String userInput = scanner.next().toLowerCase();

        if ("yes".equals(userInput)) {
            if (account.balance >= bills.amount) {

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
