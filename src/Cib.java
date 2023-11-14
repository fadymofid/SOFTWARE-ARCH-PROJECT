import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Cib implements BankApi {
    private List<Integer> validBankNumbers = new ArrayList<>();
    private String name;
    private float balance;

    public Cib() {
        // Populate the list of valid bank numbers
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
    public void setBankBalance() {
        balance = 200;
    }

    @Override
    public String getBank() {
        return name;
    }

    @Override
    public float getBankBalance() {
        return balance;
    }
}
