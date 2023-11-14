import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class BankAccount extends Account {
    public int bankNumber;
    public BankApi bankApi;

    public BankAccount(int mobileNumber, int bankNumber) {
        this.mobileNumber = mobileNumber;
        this.bankNumber = bankNumber;
    }

    public void setAccountType() {
        accountType = AccountType.BankAccount;
    }

    public void balanceEnquire() {
        bankApi.getBankBalance();
    }

    public void mobilenumberVerification(Account bank) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Write Your Bank account phone number");
        int phone = scanner.nextInt();

        // Assume OTP is sent to the provided mobile number (for simplicity, always considered as verified)
        System.out.print("Enter OTP sent to your mobile: ");
        int otp = scanner.nextInt();

        // Assume the OTP is always correct for simplicity
        bank.mobileNumber = phone;
        System.out.println("Mobile number verified successfully");
    }

    public boolean verifyBank() {
        return bankApi.verifyBank(bankNumber);
    }
}