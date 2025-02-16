import java.time.LocalDate;

public class Expense {
    private int id;
    private static int lastId = 0;
    private String description;
    private double amount;
    private LocalDate date;

    public Expense(String description, double amount) {
        this.id = ++lastId;
        this.description = description;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense [amount=" + amount + ", description=" + description + ", id=" + id + "]";
    }

    public String toCSV(){
        return id + "," + description + "," + amount + "," + date;
    }

    public Expense fromCSV(String csv){
        String[] values = csv.split(",");
        int id = Integer.parseInt(values[0]);
        String description = values[1];
        double amount = Double.parseDouble(values[2]);
        LocalDate date = LocalDate.parse(values[3]);

        Expense expense = new Expense(description, amount);
        expense.id = id;
        expense.date = date;
        return expense;
    }
}
