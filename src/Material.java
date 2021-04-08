import java.time.LocalDate;

public abstract class Material implements Discount,NewPriceDiff {
    private String id;
    private String name;
    private LocalDate manufacturingDate;
    private int cost;

    public Material() {
    }
    public Material(String id, String name, LocalDate manufacturingDate, int cost){
        this.id = id;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.cost = cost;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public int getCost() {
        return cost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    abstract double getAmount();
    abstract LocalDate getExpiryDate();

    @Override
    public double getRealMoney() {
        if(this instanceof Meat){
            if(LocalDate.now().plusDays(5).isBefore(this.getManufacturingDate())){
                return this.getAmount()*0.7;
            } else
                if(LocalDate.now().plusDays(3).isBefore(this.getManufacturingDate())) {
                    return this.getAmount()*0.5;
                } else {
                    return this.getAmount()*0.9;
                }
        }
        else if(this instanceof CrispyFlour){
            if(LocalDate.now().plusMonths(4).isBefore(this.getManufacturingDate())) {
                return this.getAmount()*0.8;
            } else
            if(LocalDate.now().plusMonths(2).isBefore(this.getManufacturingDate())) {
                return this.getAmount()*0.6;
            } else {
                return this.getAmount()*0.95;
            }
        }
       return -1;
    }

    @Override
    public double getPriceDifferent() {
        return this.getAmount() - this.getRealMoney();
    }

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", cost=" + cost +
                '}';
    }
}

