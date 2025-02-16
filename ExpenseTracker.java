import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

class ExpenseTracker{
    public static void main(String[] args) {
        boolean check = true;

        while(check){
            ExpenseWriter expenseWriter = new ExpenseWriter();
            System.out.println("1. Add an expense");
            System.out.println("2. Update an expense");
            System.out.println("3. Delete an expense");
            System.out.println("4. View all expenses");
            System.out.println("5. Sum all expenses");
            System.out.println("6. Sum expenses for specific month");
            System.out.println("7. Exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.println("Enter amount: ");
                    double amount = sc.nextDouble();
                    expenseWriter.addExpense(desc, amount);
                    break;
                
                case 2:
                    System.out.println("Enter expense id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new description: ");
                    String newDesc = sc.nextLine();
                    System.out.println("Enter new amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();
                    expenseWriter.updateExpense(id, newDesc, newAmount);
                    break;

                case 3:
                    System.out.println("Enter expense id: ");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    expenseWriter.deleteExpense(id1);
                    break;

                case 4:
                    expenseWriter.viewAllExpenses();
                    break;
                
                case 5:
                    expenseWriter.sumExpenses();
                
                case 6:
                    System.out.println("Enter month: ");
                    int month = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    expenseWriter.viewExpensesForMonth(month, year);
                    break;

                case 7:
                    expenseWriter.writeExpensesToFile();
                    check = false;
                    break;
                default:
                    break;
            }
        }
    }
}