package application;

import entities.Account;
import exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);

        Account account;

        System.out.println("Account Data: ");

        System.out.print("Enter account number: ");
        int number = teclado.nextInt();

        System.out.print("Enter account holder: ");
        teclado.nextLine();
        String holder = teclado.nextLine();

        System.out.print("Enter limit withdraw: ");
        double limitWithdraw = teclado.nextDouble();
        teclado.nextLine();

        System.out.print("Is there an initial deposit (y/n)? ");
        char response = teclado.next().charAt(0);

        if (response == 'y' || response == 'Y') {

            System.out.println();
            System.out.print("Enter initial deposit value: ");
            double balance = teclado.nextDouble();

            account = new Account(number, holder, balance, limitWithdraw);
        } else {
            account = new Account(number, holder, limitWithdraw);
        }

        System.out.println();
        System.out.println(account);
        System.out.println();

        System.out.println("(1) Change Name");
        System.out.println("(2) Deposit");
        System.out.println("(3) Withdraw");
        System.out.println("(4) Change Limit Withdraw");
        System.out.println("(5) Leave");

        System.out.print("Enter option: ");
        int option = teclado.nextInt();


        while (option != 5) {

            if (option == 1) {

                System.out.println();
                System.out.print("Enter new name: ");
                teclado.nextLine();
                String name = teclado.nextLine();
                account.changeName(name);

                System.out.println();
                System.out.println("------------------------");
                System.out.println("Successfully Updated!");
                System.out.println("------------------------");

            } else if (option == 2) {

                System.out.println();
                System.out.print("Enter the amount to deposit: ");
                double amount = teclado.nextDouble();
                account.deposit(amount);

                System.out.println();
                System.out.println("------------------------");
                System.out.println("Deposit Done!");
                System.out.println("------------------------");

            } else if (option == 3) {

                System.out.println();
                System.out.print("Enter the amount to withdraw: ");

                try {
                    double amount = teclado.nextDouble();
                    account.withdraw(amount);

                    System.out.println();
                    System.out.println("------------------------");
                    System.out.println("Withdraw Done!");
                    System.out.println("------------------------");

                } catch (BusinessException e) {
                    System.out.println();
                    System.out.println("------------------------");
                    System.out.println(e.getMessage());
                    System.out.println("------------------------");
                }

            } else if (option == 4) {

                System.out.println();
                System.out.print("Enter the new limit to withdraw: ");
                double amount = teclado.nextDouble();
                account.changeLimitWithdraw(amount);

                System.out.println();
                System.out.println("------------------------");
                System.out.println("Limit Withdraw Changed!");
                System.out.println("------------------------");

            } else {
                System.out.println();
                System.out.println("------------------------");
                System.out.println("Invalid Option");
                System.out.println("------------------------");
                System.out.println();
            }
            System.out.println(account);

            System.out.println("");
            System.out.println("(1) Change Name");
            System.out.println("(2) Deposit");
            System.out.println("(3) Withdraw");
            System.out.println("(4) Change Limit Withdraw");
            System.out.println("(5) Leave");

            System.out.print("Enter option: ");
            option = teclado.nextInt();


        }
        System.out.println();
        System.out.println("------------");
        System.out.println("Bye Bye");
        System.out.println("------------");

    }
}
