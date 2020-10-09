package calculator;

public class Dining implements Expense {
    private final Destination destination;
    private final float numberNights;

    public Dining (Destination dest, float nights) {
        this.destination = dest;
        this.numberNights = nights;
    }

    @Override
    public float getCost() {
        if (this.destination == Destination.Mexico)
            return 10.0f * this.numberNights;
        if (this.destination == Destination.Europe)
            return 20.0f * this.numberNights;
        if (this.destination == Destination.Japan)
            return 30.0f * this.numberNights;
        else
            return 0;
    }
}
