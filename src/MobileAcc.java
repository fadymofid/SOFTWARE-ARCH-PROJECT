public class MobileAcc extends Account{
    public WalletProvider walletProvider;
    public mobilewalletservice mobilewalletservice;
    public void setAccountType(){
        accountType=AccountType.Walletaccount;
    };
    public MobileAcc(int mob ){
        this.mobileNumber = mob;
        this.walletProvider = new VodaCash();
        this.walletProvider.setwalletBalance(2000);
        balance= walletProvider.getwalletBalance();// Set the initial balance
    }
    public MobileAcc(){this.walletProvider = new VodaCash();}

    public WalletProvider getWalletProvider() {
        return walletProvider;
    }
}
