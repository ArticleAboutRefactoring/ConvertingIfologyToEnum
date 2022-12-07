package pl.training.movies.afterrefactor;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Rental {
    private final MovieType type;
    private final LocalDate startDate;

    public Rental(MovieType type, LocalDate startDate) {
        this.type = type;
        this.startDate = startDate;
    }

    boolean isNewRelease() {
        return type == MovieType.NEW_RELEASE;
    }

    long periodInDays() {
        return DAYS.between(LocalDate.now(), startDate);
    }

    public MovieType getType() {
        return type;
    }

}
