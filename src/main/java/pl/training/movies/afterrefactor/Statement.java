package pl.training.movies.afterrefactor;

public class Statement {
    double totalValue;
    int loyaltyPoints;

    public Statement(double totalValue, int loyaltyPoints) {
        this.totalValue = totalValue;
        this.loyaltyPoints = loyaltyPoints;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}
