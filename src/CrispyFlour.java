import java.time.LocalDate;

public class CrispyFlour  extends Material{
    private double quantity;
    public CrispyFlour(){

    }

    public CrispyFlour(double quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    double getAmount() {
        return this.getQuantity()*this.getCost();
    }

    @Override
    LocalDate getExpiryDate() {
        return this.getManufacturingDate().plusYears(1);
    }
}
