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
}