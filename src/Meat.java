import java.time.LocalDate;

public class Meat extends Material{
    private double weight;

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    double getAmount() {
        return this.getCost()*this.getWeight();
    }

    @Override
    LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusWeeks(7);
    }
}
