import java.util.Scanner;

class ExpenseTracker{
    public static void main(String[] args) {
        boolean check = true;

        while(check){
            System.out.println("1. Add an expense");
            System.out.println("2. Update an expense");
            System.out.println("3. Delete an expense");
            System.out.println("4. View all expenses");
            System.out.println("5. View expenses for specific month");
            System.out.println("6. Exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
        }
    }
}