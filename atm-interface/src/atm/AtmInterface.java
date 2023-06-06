package atm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class AtmInterface {
    public static void main(String[] args) throws InterruptedException {

        // to store transaction history
        ArrayList<String> transactionsHistories = new ArrayList<>();

        // database object to access Database class members
        Database database = new Database();

        // authenticate object to access Authenticate class member method like isUsernameExist() and isPasswordExist()
        Authenticate authenticate = new Authenticate();
        Withdraw withdraw = new Withdraw();
        Deposit deposit = new Deposit();
        Transfer transfer = new Transfer();
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "========================================="
        );
        System.out.println(
                "             Welcome to ATM             "
        );
        System.out.println(
                "========================================="
        );

        // taking username and password from user
        System.out.print(
                "Username: "
        );
        String username = scanner.nextLine();
        System.out.print(
                "Password: "
        );
        String password = scanner.nextLine();
        System.out.println(
                "*****************************************"
        );

        // authenticating the username and password
        if (
                authenticate.isUsernameExist(username, database.getUsername()) && authenticate.isPasswordExist(password, database.getPassword())
        ) {
            System.out.println("Access granted");
            while (true) {
                System.out.println(
                        "1 - Transactions History             " +
                                "4 - Transfer    "
                );
                System.out.println(
                        "2 - Withdraw                         " +
                                "5 - Quit    "
                );
                System.out.println("3 - Deposit");
                System.out.println(
                        "******************************************"
                );
                System.out.print("Option: ");
                int choice = scanner.nextInt();
                StringBuilder transactions = new StringBuilder();
                switch (choice) {
                    case 1 -> {
                        if(transactionsHistories.size() == 0){
                            System.out.println("You have done 0 transaction today");
                            break;
                        }
                        for (String th : transactionsHistories) {
                            System.out.println(th);
                            System.out.println();
                        }
                    }
                    case 2 -> {
                        System.out.print("Enter amount: ");
                        long amount = scanner.nextLong();
                        if(amount > database.getBalance()){
                            System.out.println("Insufficient balance");
                            break;
                        }
                        long withdrawMoney = withdraw.withdrawMoney(amount, database.getBalance());
                        System.out.print("Transaction is being processed . ");
                        Thread.sleep(1000);
                        System.out.print(". . ");
                        Thread.sleep(1000);
                        System.out.print(". . ");
                        Thread.sleep(1000);
                        System.out.println(". .");
                        System.out.println("Please collect your case...");
                        database.setBalance(withdrawMoney);

                        // set transaction history
                        transactions.append("Type: withdraw " + "amount: ").append(amount).append(" date: ").append(LocalDate.now()).append(" time: ").append(LocalTime.now());

                        // add to transactions History arraylist
                        transactionsHistories.add(transactions.toString());

                        // print new line
                        System.out.println();

                    }
                    case 3 -> {
                        System.out.print("Enter amount: ");
                        long amount = scanner.nextLong();
                        long depositMoney = deposit.depositMoney(amount, database.getBalance());

                        // delay for 4 seconds
                        System.out.print("Transaction is being processed . ");
                        Thread.sleep(1000);
                        System.out.print(". . ");
                        Thread.sleep(1000);
                        System.out.print(". . ");
                        Thread.sleep(1000);
                        System.out.println(". .");
                        Thread.sleep(1000);
                        System.out.println("Successfully deposit " + amount);
                        // set transaction history
                        transactions.append("Type: withdraw " + "amount: ").append(amount).append(" date: ").append(LocalDate.now()).append(" time: ").append(LocalTime.now());

                        // add to transactions History arraylist
                        transactionsHistories.add(transactions.toString());

                        // print new line
                        System.out.println();
                    }
                    case 4 -> {
                        System.out.print("Enter amount to transfer: ");
                        long amount = scanner.nextLong();
                        if(amount > database.getBalance()){
                            System.out.println("Insufficient balance");
                            break;
                        }
                        long totalAmount = database.getBalance();
                        totalAmount -= amount;
                        System.out.println(transfer.transferMoney());

                        // delay for 4 seconds
                        System.out.print("Transaction is being processed . ");
                        Thread.sleep(1000);
                        System.out.print(". . ");
                        Thread.sleep(1000);
                        System.out.print(". . ");
                        Thread.sleep(1000);
                        System.out.println(". .");
                        Thread.sleep(1000);
                        System.out.println("Successfully transferred " + amount);

                        // set transaction history
                        transactions.append("Type: withdraw " + "amount: ").append(amount).append(" date: ").append(LocalDate.now()).append(" time: ").append(LocalTime.now());

                        // add to transactions History arraylist
                        transactionsHistories.add(transactions.toString());

                        // print new line
                        System.out.println();

                    }
                    case 5 -> System.exit(5);
                    default -> System.out.println("Invalid");
                }
            }
        } else {
            System.out.println("Incorrect username or password");
        }
    }
}
