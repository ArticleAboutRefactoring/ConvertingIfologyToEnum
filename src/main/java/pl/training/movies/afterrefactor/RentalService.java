package pl.training.movies.afterrefactor;

import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class RentalService {
    private final LoyaltyPointsCalculator loyaltyPointsCalculator;

    public RentalService(LoyaltyPointsCalculator loyaltyPointsCalculator) {
        this.loyaltyPointsCalculator = loyaltyPointsCalculator;
    }

    public Statement createStatement(List<Rental> rentals) {
        double totalValue = getTotalValue(rentals);
        int loyaltyPoints = getLoyaltyPoints(rentals);

        return new Statement(totalValue, loyaltyPoints);
    }

    private double getTotalValue(List<Rental> rentals) {
        return rentals.stream()
                .mapToDouble(getValueFor())
                .sum();
    }

    private static ToDoubleFunction<Rental> getValueFor() {
        return rental -> rental.getType().getValueFor(rental.periodInDays());
    }

    private int getLoyaltyPoints(List<Rental> rentals) {
        return rentals.stream()
                .mapToInt(getPoints())
                .sum();
    }

    private ToIntFunction<Rental> getPoints() {
        return rental -> loyaltyPointsCalculator.getPoints(rental.isNewRelease(), rental.periodInDays());
    }

}
