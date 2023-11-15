abstract class Account {
    AccountType accountType;
    public double balance;
    public int mobileNumber;
    Bills bills;
    Transactions transactions;
    AccountServices accountServices;
Account(){
}



         public AccountType getAccountType (){
         return  accountType;
         }
    public double getbalance (){
        return  balance;
    }

    public AccountServices getAccountServices() {
        return accountServices;
    }
}
