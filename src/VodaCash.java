import java.util.ArrayList;
import java.util.List;

public class VodaCash implements WalletProvider{
    private List<Integer> validNumbers = new ArrayList<>();
    public String name="Vodaphone Cash";
    public double balance;
    public VodaCash() {
        validNumbers.add(123);
        validNumbers.add(456);
    }

    @Override
    public boolean verify(int number) {
            return  validNumbers.contains(number);
    }

    @Override
    public void provide() {
    System.out.println("provid");
    }

    public void setwalletBalance(double balance) {
        this.balance = balance;
    }
    public void setwallet() {
        name = "Vodafonecash";
    }

    @Override
    public String getwallet() {
        return name;
    }

    @Override
    public double getwalletBalance() {
        return balance;
    }
}
