
class  BankAccount extends Account {
    public int bankNumber;
    public BankApi bankApi;

    public BankAccount(int mobileNumber, int bankNumber) {
        this.mobileNumber = mobileNumber;
        this.bankNumber = bankNumber;
        this.bankApi = new Cib();
        this.bankApi.setBankBalance(2000);
        this.balance= bankApi.getBankBalance();// Set the initial balance

    }


    public BankAccount() {
        this.bankApi = new Cib();  // Initialize with the appropriate BankApi implementation
    }

}