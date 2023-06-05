package atm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AtmInterface {
    public static void main(String[] args) {
        Database database = new Database();
        Authenticate authenticate = new Authenticate();
        Withdraw withdraw = new Withdraw();
        TransactionsHistory transactionsHistory = new TransactionsHistory();
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "---------welcome to ATM---------"
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
//        System.out.println("Username: " + username + " Password: " + password);

        // authenticating the username and password
        if(
        authenticate.isUsernameExist(username, database.getUsername()) && authenticate.isPasswordExist(password, database.getPassword())
        ){
            System.out.println("Access granted");
            while(true){
                System.out.println(
                        "1 - Transactions History    " +
                                "2 - Withdraw    " +
                                "3 - Deposit    " +
                                "4 - Transfer    " +
                                "5 - Quit    "
                );
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Amount: " + transactionsHistory.getAmount());
                        System.out.println("Date: " + transactionsHistory.getDate());
                        System.out.println("Time: " + transactionsHistory.getTime());
                    }
                    case 2 -> {
                        System.out.println("Enter amount: ");
                        long amount = scanner.nextLong();
                        long withdrawMoney = withdraw.withdrawMoney(amount, database.getBalance());
                        System.out.println("successfully withdraw " + amount);
                        database.setBalance(withdrawMoney);

                        // set transaction history
                        transactionsHistory.setAmount(amount);
                        transactionsHistory.setDate(LocalDate.now());
                        transactionsHistory.setTime(LocalTime.now());
                    }
                    case 3 -> System.out.println("deposit");
                    case 4 -> System.out.println("transfer");
                    case 5 -> System.exit(5);
                    default -> System.out.println("Invalid");
                }
            }
        }
        else {
            System.out.println("Incorrect username or password");
        }
    }
}