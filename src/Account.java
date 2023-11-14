abstract class Account {
    AccountType accountType;
    public Float balance;
    public int mobileNumber;
    Bills bills;
    Transactions transactions;

    public void setAccountType() {
    }

    public abstract void balanceEnquire();

    public abstract void mobilenumberVerification(Account account);
}
