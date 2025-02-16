import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ExpenseWriter {
    private static final String FILE_NAME = "expenses.csv";
    private List<Expense> expenses;
    
    ExpenseWriter(){
        expenses = new ArrayList<>();
        if(!Files.exists(Paths.get(FILE_NAME))){
            createEmptyFile();
        }
        readExpensesFromFile();
    }

    private void createEmptyFile(){
        try {
            Files.createFile(Paths.get(FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readExpensesFromFile(){
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            for(String line : lines){
                Expense expense = Expense.fromCSV(line);
                expenses.add(expense);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeExpensesToFile(){
        List<String> lines = new ArrayList<>();
        for(Expense expense : expenses){
            lines.add(expense.toCSV());
        }

        try {
            Files.write(Paths.get(FILE_NAME), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addExpense(String description, double amount){
        Expense expense = new Expense(description, amount);
        expenses.add(expense);
        writeExpensesToFile();
    }

    public void updateExpense(int id, String newDescription, double newAmount){
        for(Expense expense : expenses){
            if(expense.getId() == id){
                expense.setDescription(newDescription);
                expense.setAmount(newAmount);
                break;
            }
        }
        writeExpensesToFile();
    }

    public void deleteExpense(int id){
        for(Expense expense : expenses){
            if(expense.getId() == id){
                expenses.remove(expense);
                break;
            }
        }
        writeExpensesToFile();
    }

    public void viewAllExpenses(){
        for(Expense expense : expenses){
            System.out.println(expense);
        }
    }

    public void sumExpenses(){
        double sum = 0;
        for(Expense expense : expenses){
            sum += expense.getAmount();
        }
        System.out.println("Total expenses: " + sum);
    }

    public void viewExpensesForMonth(int month, int year){
        double sum1 = 0;
        for(Expense expense : expenses){
            if(expense.getDate().getMonthValue() == month && expense.getDate().getYear() == year){
                sum1 += expense.getAmount();
            }
        }
        System.out.println("Total expenses: " + sum1);

    }
}