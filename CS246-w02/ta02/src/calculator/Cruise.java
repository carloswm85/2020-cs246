package calculator;

public class Cruise implements Expense {

    private final Destination destiny;
    private float Cost = 0;

    public Cruise (Destination dName) {
        this.destiny = dName;
        this.setCost();
    }

    private void setCost() {
        if (this.destiny == Destination.Mexico)
            this.Cost = 1000.0f;
        else if (this.destiny == Destination.Europe)
            this.Cost = 2000.0f;
        else if (this.destiny == Destination.Japan)
            this.Cost = 3000.0f;
    }

    @Override
    public float getCost() {
            return this.Cost;
    }
}
