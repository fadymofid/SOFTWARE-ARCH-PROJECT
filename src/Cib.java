import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Cib implements BankApi {
    private List<Integer> validBankNumbers = new ArrayList<>();
    private String name;
    private double balance; // Change the data type to double

    public Cib() {
        validBankNumbers.add(123);
        validBankNumbers.add(456);
    }

    @Override
    public boolean verifyBank(int bankNumber) {
        return validBankNumbers.contains(bankNumber);
    }

    @Override
    public void setBank() {
        name = "Cib";
    }

    @Override
    public void setBankBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String getBank() {
        return name;
    }

    @Override
    public double getBankBalance() {
        return balance;
    }
}
