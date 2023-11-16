interface AccountServices {
    void setAccountType(Account acc);

    double balanceEnquire(Account account);

    void mobilenumberVerification(Account account,int phone);

    boolean verify(Account account);

    void settransbalance(double amount, Account scc);
}