import java.util.Scanner;

public class Electricity implements Bills{
    public String BillType="Electricity";
    public int billAmount=20;
    @Override
    public void PayBills(Account account,Float billAmount) {
        System.out.println("Electricity bill amount: " + billAmount + " pounds");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to pay this bill? (yes/no): ");
        String userInput = scanner.next().toLowerCase();

        if ("yes".equals(userInput)) {
            if (account.balance >= billAmount) {
                // Deduct the billAmount from the account's balance
                account.balance -= billAmount;
                System.out.println("Payment successful");
            } else {
                System.out.println("Insufficient balance. Payment failed.");
            }
        } else {
            System.out.println("Bill payment canceled");
        }
    }
}

