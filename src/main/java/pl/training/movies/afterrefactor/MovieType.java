package pl.training.movies.afterrefactor;



public enum MovieType {
    REGULAR(2, 2, 1.5),
    CHILDREN(3, 1.5, 1.5),
    NEW_RELEASE(0, 0, 3);

    private final int freeRentalPeriodInDays;
    private final double initialCost;
    private final double costPerDay;

    MovieType(int freeRentalPeriodInDays, double initialCost, double costPerDay) {
        this.freeRentalPeriodInDays = freeRentalPeriodInDays;
        this.initialCost = initialCost;
        this.costPerDay = costPerDay;
    }

    double getValueFor(long periodInDays) {
        return getInitialCost() + getValueForPeriod(periodInDays);
    }

    private double getValueForPeriod(long periodInDays) {
        return calculateDaysToPay(periodInDays) * getCostPerDay();
    }

    private long calculateDaysToPay(long periodInDays) {
        return periodInDays - getFreeRentalPeriodInDays();
    }

    public int getFreeRentalPeriodInDays() {
        return freeRentalPeriodInDays;
    }

    public double getInitialCost() {
        return initialCost;
    }

    public double getCostPerDay() {
        return costPerDay;
    }
}
