import java.util.Scanner;

class BankAccServices implements AccountServices {
    @Override
    public void setAccountType(Account acc) {
        acc.accountType = AccountType.BankAccount;
    }

    public double balanceEnquire(Account account) {
        return account.balance;
    }

    public void mobilenumberVerification(Account bank, int phone) {
        Scanner scanner = new Scanner(System.in);

        // Assume OTP is sent to the provided mobile number (for simplicity, always considered as verified)
        System.out.print("Enter OTP sent to your mobile: ");
        int otp = scanner.nextInt();

        // Assume the OTP is always correct for simplicity
        bank.mobileNumber = phone;
        System.out.println("Mobile number verified successfully");
    }


    public boolean verify(Account account) {
        if (account instanceof BankAccount) {
            // Bank-specific verification logic
            BankAccount bankAccount = new BankAccount(); // Creating a new instance here
            return  true;
        } else {
            return false;
        }
    }

    @Override
    public void settransbalance(double amount,Account scc) {
        scc.balance=amount;
    }
}