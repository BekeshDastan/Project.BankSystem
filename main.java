package Project;

import java.util.Date;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank kaspi = new Bank();
        kaspi.setName("Kaspi");
        System.out.println("Welcome to the Bank System! ");
        System.out.println("This is menu of Kaspi bank system:");
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Show Account Info");
            System.out.println("4. Add  ATM");
            System.out.println("5. Deposit Money");
            System.out.println("6. ATM Withdraw Money");
            System.out.println("7. Delete ATM");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            int choice = 0;
            while (true) {
                try {
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 8) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid choice. Try again.");
                    sc.next();
                }
            }
            switch (choice) {
                case 1:
                    int account_number = getValidPositiveNumber(sc, "Enter Account Number: ");
                    int account_pin = getValidPositiveNumber(sc, "Enter Account Pin-Code: ");
                    int account_balance = getValidPositiveNumber(sc, "Enter Account balance: ");
                    Account account = new Account(kaspi, account_number, account_pin, account_balance);
                    kaspi.addAccount(account);
                    System.out.println("Account Added Successfully!");
                    break;
                case 2:
                    System.out.println("Remove Account");
                    Account accToRemove = validateAccount(sc, kaspi);
                    if (accToRemove != null) {
                        kaspi.removeAccount(accToRemove);
                        System.out.println("Account removed!");
                        break;
                    }
                    break;

                case 3:
                    System.out.println("Show Account Info");
                    Account accShow = validateAccount(sc, kaspi);
                    if (accShow != null) {
                        System.out.println("Bank: " + kaspi.getName() + ", Number: " + accShow.getNumber() + ", Balance: " + accShow.getRemainder());
                    }
                    break;
                case 4:
                    System.out.println("Add ATM");
                    int atmID =getValidPositiveNumber(sc,"Enter ATM identification number: ");
                    sc.nextLine();
                    System.out.println("Enter ATM address: ");
                    String atmAddress = sc.nextLine();
                    ATM atm = new ATM(kaspi, atmAddress, atmID);
                    kaspi.addATM(atm);
                    System.out.println("ATM added!");
                    break;
                case 5:
                    System.out.println("Deposit Money");
                    Account accToDeposit = validateAccount(sc, kaspi);
                    if (accToDeposit != null) {
                        double moneyToDeposit=getValidPositiveNumber(sc,"Enter Amount to deposit money: ");
                        accToDeposit.replenishAccount(moneyToDeposit);
                        System.out.println("Account replenished!");
                        break;
                    }
                    break;
                case 6:
                    System.out.println("ATM Withdraw Money");
                    Account accToWithdraw = validateAccount(sc, kaspi);
                    double moneyWithDraw=getValidPositiveNumber(sc,"Enter Amount to withdraw money: ");
                    if (accToWithdraw != null) {
                        if (accToWithdraw.getRemainder() > moneyWithDraw) {
                            accToWithdraw.withdraw_from_account(moneyWithDraw);
                            System.out.println("Account withdrawn!");

                        }
                        else{
                            System.out.println("Insufficient Funds!");
                        }

                        break;
                    }
                    break;
                case 7:
                    System.out.println("Delete ATM");
                    int atmId = getValidPositiveNumber(sc, "Enter ATM identification number: ");
                    ATM atmToDelete = kaspi.getATM(atmId);
                    if (atmToDelete == null) {
                        System.out.println("ATM with the given ID does not exist!");
                    } else {
                        kaspi.removeATM(atmToDelete);
                        System.out.println("ATM deleted successfully!");
                    }
                    break;
                case 8:
                    System.out.println("Thank you for using the Bank System!");
                    return;
            }




        }
    }
    public static int getValidPositiveNumber(Scanner sc, String num) {
        System.out.println(num);
        int number = 0;
        while (true) {
            try{
                number =sc.nextInt();
                if (number > 0) {
                    return number;
                }
                else{
                    System.out.println("Number must be a positive number! Try again.");
                }
            }
            catch(Exception e){
                System.out.println("Invalid number. Try again.");
                num = sc.nextLine();
            }
        }
    }
    public static Account validateAccount(Scanner sc, Bank bank) {
        int accountNumber = getValidPositiveNumber(sc, "Enter Account Number: ");
        Account account = bank.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Account does not exist!");
            return null;
        }

        int enteredPin = getValidPositiveNumber(sc, "Enter PIN: ");
        if (enteredPin != account.getPinCode()) {
            System.out.println("Incorrect PIN!");
            return null;
        }

        return account;
    }

}

