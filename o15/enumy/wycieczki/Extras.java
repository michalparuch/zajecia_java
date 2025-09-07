package basics.o15.enumy.wycieczki;

public enum Extras {
    ALLINCLUSIVE(1000),
    INSURANCE (200),
    BREAKFAST(100),
    POOL(200),
    CAR_RENTAL(500);

    private final Integer price;

    Extras(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

}
