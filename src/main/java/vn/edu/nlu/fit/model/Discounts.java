package vn.edu.nlu.fit.model;

public class Discounts {
    private int id;
    private String name;
    private double amount;
    private double percent;
    private int status;

    public Discounts() {
    }

    public Discounts(int id, String name, double amount, double percent, int status) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.percent = percent;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Discounts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", percent=" + percent +
                ", status=" + status +
                '}';
    }
}
