package pl.training.movies.torefactor;

public class Movie {
    public static final int REGULAR = 0;
    public static final int CHILDRENS = 2;
    public static final int NEW_RELEASE = 1;
    private String _title;
    private int CodePrice;

    public Movie(String title, int priceCode) {
        _title = title;
        CodePrice = priceCode;
    }

    public int getPriceCode() {
        return CodePrice;
    }

    public String getTitle() {
        return _title;
    }
}
