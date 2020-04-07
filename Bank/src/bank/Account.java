package bank;

/**
 *
 * @author lenka.wrnatova
 */
public class Account {

    //data
    private double accountBalance;

    //konstruktory
    public Account(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Account() {
        this.accountBalance = 0.0;
    }

    //metody
    public double getAccountBalance() {
        return accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" + "accountBalance=" + accountBalance + '}';
    }

    /**
     * vklad penez na ucet
     *
     * @param amount castka, kterou chcete vlozit
     */
    public void depositMoney(double amount) {
        this.accountBalance += amount;
    }

    /**
     * vyber penez z uctu
     *
     * @param amount castka, kterou chcete vybrat
     */
    public void withdrawMoney(double amount) {
        if (amount > this.accountBalance) {
            throw new IllegalArgumentException("prekrocen limit");
//            System.out.println("Prekrocen limit, zustatek na uctu je "+this.accountBalance);
        } else {
            this.accountBalance -= amount;
        }
    }

    public double showAccountBalance() {
        return this.accountBalance;
    }

}
