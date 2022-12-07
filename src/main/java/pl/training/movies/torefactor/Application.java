package pl.training.movies.torefactor;

public class Application {

    public static void main(String[] args) {
        ShopCustomer c = createShopCustomers();
        System.out.println(c.statement());
    }

    private static ShopCustomer createShopCustomers() {
        ShopCustomer c = new ShopCustomer("Adam Adamowski");
        c.addRental(new Rental(new Movie("film 1", 10), 1));
        c.addRental(new Rental(new Movie("film 2", 20), 2));
        c.addRental(new Rental(new Movie("film 3", 30), 3));

        return c;
    }

}
