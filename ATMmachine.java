import java.util.*;

class ATM {
    float Balance;  // Stores the account balance
    int PIN = 1019;  // Default PIN for the ATM
    ArrayList<String> miniStatement = new ArrayList<>();  // Stores transaction history
    Scanner sc = new Scanner(System.in);  // Used for user input
    int pinAttempts = 0;  // Counts invalid PIN attempts

    // Simulate other accounts with account numbers and their balances
    HashMap<String, Float> accounts = new HashMap<>();

    // Constructor to add some sample accounts
    public ATM() {
        accounts.put("12345", 10000f);  // Add account number 12345 with ₹10,000 balance
        accounts.put("67890", 20000f);  // Add account number 67890 with ₹20,000 balance
    }

    // Method to check the user's PIN
    public void checkpin() {
        System.out.println("Please Enter Your PIN: ");
        int enteredpin = sc.nextInt();

        if (enteredpin == PIN) {  // If PIN is correct
            pinAttempts = 0;  // Reset the invalid PIN attempt counter
            menu();  // Show the menu
        } else {  // If PIN is incorrect
            pinAttempts++;  // Increase the attempt counter
            if (pinAttempts >= 3) {  // Exit after 3 invalid attempts
                System.out.println("Too many invalid attempts! Exiting...");
            } else {
                System.out.println("Invalid PIN! Attempts left: " + (3 - pinAttempts));
                checkpin();  // Prompt for PIN again
            }
        }
    }

    // Method to display the ATM menu options
    public void menu() {
        System.out.println("Enter Your Choice: \n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Mini Statement");
        System.out.println("5. PIN Change");
        System.out.println("6. Transfer Funds");
        System.out.println("7. Exit");

        int option = sc.nextInt();

        // Switch case to handle user's menu selection
        switch (option) {
            case 1 -> CheckBalance();  // Check balance
            case 2 -> DepositMoney();  // Deposit money
            case 3 -> WithdrawMoney();  // Withdraw money
            case 4 -> MiniStatement();  // Show mini statement
            case 5 -> PinChange();  // Change PIN
            case 6 -> transferFunds();  // Transfer funds
            case 7 -> exitATM();  // Exit
            default -> {
                System.out.println("Choose a Valid Option: ");  // Handle invalid input
                menu();  // Return to the menu
            }
        }
    }

    // Method to check and display the current balance
    public void CheckBalance() {
        System.out.println("Your account Balance is: " + Balance);
        menu();  // Return to the menu after showing balance
    }

    // Method to deposit money into the account
    public void DepositMoney() {
        System.out.println("Enter Deposit Amount: ");
        float amount = sc.nextFloat();
        Balance += amount;  // Update the balance
        miniStatement.add("Deposited: " + amount);  // Log the transaction
        System.out.println("Money Deposited successfully\n");
        menu();  // Return to the menu
    }

    // Method to withdraw money from the account
    public void WithdrawMoney() {
        System.out.println("Enter Withdrawal Amount:");
        float amount = sc.nextFloat();
        if (amount > Balance) {  // Check if there's enough balance
            System.out.println("Insufficient Balance! Please Check Balance and Retry.\n");
        } else {
            Balance -= amount;  // Deduct the amount from balance
            miniStatement.add("Withdrawn: " + amount);  // Log the transaction
            System.out.println("Withdrawal Successful!\n");
        }
        menu();  // Return to the menu
    }

    // Method to display the mini statement (last few transactions)
    public void MiniStatement() {
        System.out.println("Mini Statement:");
        if (miniStatement.isEmpty()) {
            System.out.println("No transactions yet.\n");  // Handle no transactions case
        } else {
            for (String transaction : miniStatement) {
                System.out.println(transaction);  // Print each transaction
            }
            System.out.println("\nCurrent Balance: " + Balance + "\n");  // Print current balance after listing transactions
        }
        menu();  // Return to the menu
    }

    // Method to change the user's PIN
    public void PinChange() {
        System.out.println("Enter Current PIN: ");
        int currentPin = sc.nextInt();
        if (currentPin == PIN) {  // Verify current PIN
            System.out.println("Enter New PIN: ");
            int newPin = sc.nextInt();
            System.out.println("Re-enter New PIN: ");
            int reenteredPin = sc.nextInt();

            if (newPin == reenteredPin) {  // Check if both entered PINs match
                PIN = newPin;  // Update the PIN
                System.out.println("PIN Changed Successfully!\n");
                checkpin();  // Return to PIN check after changing PIN
            } else {
                System.out.println("PINs do not match! Try Again.\n");
                PinChange();  // Restart the PIN change process
            }
        } else {
            System.out.println("Incorrect PIN! Try Again.\n");  // Handle incorrect current PIN
            menu();  // Return to the menu
        }
    }

    // Method to transfer funds to another account
    public void transferFunds() {
        System.out.println("Enter the account number to transfer to:");
        String accountNumber = sc.next();

        // Check if the account number exists in the simulated accounts
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Invalid account number! Please try again.");
            menu();
            return;
        }

        System.out.println("Enter amount to transfer:");
        float transferAmount = sc.nextFloat();

        // Check if the user has sufficient balance to transfer
        if (transferAmount > Balance) {
            System.out.println("Insufficient Balance! Transfer failed.\n");
        } else {
            // Deduct the transfer amount from the user's balance
            Balance -= transferAmount;
            
            // Add the transfer amount to the recipient's account balance
            float recipientBalance = accounts.get(accountNumber);
            accounts.put(accountNumber, recipientBalance + transferAmount);

            // Log the transaction in the mini statement
            miniStatement.add("Transferred: " + transferAmount + " to Account: " + accountNumber);
            System.out.println("Funds Transferred Successfully!\n");
        }
        menu();  // Return to the menu
    }

    // Method to exit the ATM program
    public void exitATM() {
        System.out.println("Thank you for using the ATM!");
    }
}

public class ATMmachine {
    public static void main(String[] args) {
        ATM obj = new ATM();  // Create ATM object
        obj.checkpin();  // Start by checking the user's PIN
    }
}
