import java.util.Scanner;
 class mobilewalletservice implements AccountServices {
     public void setAccountType(Account acc) {
         acc.accountType = AccountType.Walletaccount;
     }
     public double balanceEnquire(Account account) {
         return account.balance;
     }
     public void mobilenumberVerification(Account wallet, int phone) {
         Scanner scanner = new Scanner(System.in);

         // Assume OTP is sent to the provided mobile number (for simplicity, always considered as verified)
         System.out.print("Enter OTP sent to your mobile: ");
         int otp = scanner.nextInt();

         // Assume the OTP is always correct for simplicity
         wallet.mobileNumber = phone;
         System.out.println("Mobile number verified successfully");
     }
     public boolean verify(Account account) {
         if (account instanceof MobileAcc) {
             // Bank-specific verification logic
             MobileAcc walletaccount = new MobileAcc(); // Creating a new instance here
             return  true;
         } else {
             return false;
         }
     }
     public void settransbalance(double amount, Account scc){
         scc.balance=amount;
     }

 }
