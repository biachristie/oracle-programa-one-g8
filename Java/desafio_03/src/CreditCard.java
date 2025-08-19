import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double creditLimit;
    private double balance;
    private List<Purchase> purchases;

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
        this.balance = creditLimit;
        this.purchases = new ArrayList<>();
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public boolean isAPurchase(Purchase p) {
        if (this.balance > p.getPrice()) {
            this.balance -= p.getPrice();
            this.purchases.add(p);
            return true;
        }

        return false;
    }
}
