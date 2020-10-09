package calculator;

public class Lodging implements Expense {
    private final Destination destination;
    private final float numberNights;

    public Lodging(Destination dest, float nights) {
        this.destination = dest;
        this. numberNights = nights;
    }

    @Override
    public float getCost() {
        if (this.destination == Destination.Mexico)
            return 100.0f * this.numberNights;
        if (this.destination == Destination.Europe)
            return 200.0f * this.numberNights * 1.1f;
        if (this.destination == Destination.Japan)
            return 300.0f * this.numberNights * 1.3f;
        else
            return 0f;
    }
}
