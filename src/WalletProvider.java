public interface WalletProvider {
    public boolean verify(int num);
    public void provide();
    public void setwallet();

    public void setwalletBalance(double balance);
    public double getwalletBalance();
    public String getwallet();
}
