import java.util.Scanner;


public class UserInterface {

    private ClientAccountManagement cam = new ClientAccountManagement();
    public Scanner input = new Scanner(System.in);

    public UserInterface(boolean activeATM){
        boolean stillActive = activeATM;
        while(stillActive){
            System.out.println("What would you like to do?");
            System.out.println("1. Create account\n" +
                    "2. Withdraw account\n" +
                    "3. Deposit account\n" +
                    "4. Close account\n" +
                    "5. View all active accounts\n" +
                    "6. End ");
            int option = input.nextInt();
            switch(option){
                case 1:
                    creatingAccount();
                    break;
                case 2:
                    withdrawingAccount();
                    break;
                case 3:
                    depositingAccount();
                    break;
                case 4:
                    closingAccount();
                    break;
                case 5:
                    displayAllAccounts();
                case 6:
                    stillActive = false;
                    break;

            } // end of switch

        }
        input.close();
        System.out.println("Simulation Ended");
    } // end of constructor

    // TODO Complete closingAccount in the code
    private void closingAccount() {
    }

    // TODO run the function
    // TODO Create a test for it
    private void depositingAccount() {

        boolean doAnotherDeposit = true;

        while(doAnotherDeposit){
            System.out.println("Which account would you like to deposit");
            cam.viewListOfAccounts();
            Account accountSelected = cam.getAccount(input.nextInt());

            System.out.println(accountSelected.accountInfo());
            System.out.println("Enter the amount you would like to deposit");
            double depositAmount = input.nextDouble();

            accountSelected.deposit(depositAmount);
            System.out.println("Your current balance for account " + accountSelected.getAccountNum()
                    + " is: $" + accountSelected.getBalance());

            System.out.println("Would you like to make another deposit? Y/N");
            if (input.nextLine() == "N"){
                doAnotherDeposit = false;
            }
        } // while loop

    } // end of depositAccount

    //Withdraws a certain amount from a specific account and repeats the process
    // TODO Create a test for this class
    private void withdrawingAccount(){

        boolean doAnotherWithdraw = true;

        while(doAnotherWithdraw) {
            System.out.println("Select with account you want to withdraw from:");

            // prints every key-value pair
            cam.viewListOfAccounts();
            System.out.println("Enter the account number that you want to use:");
            Account accountSelected = cam.getAccount(input.nextInt()); //

            System.out.println(accountSelected.accountInfo());

            System.out.println("How much money do you want to withdraw?");
            accountSelected.withdraw(input.nextDouble());
            System.out.println("Your current balance for account " + accountSelected.getAccountNum()
                    + " is: $" + accountSelected.getBalance());

            System.out.println("Do you want to make an other withdraw? Y/N");
            if(!input.next().equals("N")){
                doAnotherWithdraw = false;
            }
        } // end of while



    } // end of withdrawingAccount

    // creating an account option one
    // Creates a single account, recursively if multiple
    public void creatingAccount(){

        Account newAccount = new Account();
        System.out.println("Select account type ");
        System.out.println("1. Checking\n2. Savings");
        int userResponse = input.nextInt(); //TODO put in a limit between integers 1 and 2
        if (userResponse == 1){
            newAccount.setAccountType("CHECKING");
        } else {
            newAccount.setAccountType("SAVINGS");
        } // end of else

        System.out.println("Enter your first name:");
        newAccount.setFirstName(input.next());

        System.out.println("Enter your last name:");
        newAccount.setLastName(input.next());

        // if there is no PIN setup, then
        if(cam.IS_PIN_SETUP) {
            System.out.println("Enter your create your PIN:");
            cam.setPIN(input.nextInt());
        }
        System.out.println("Enter your first deposit:");
        newAccount.setBalance(input.nextDouble());

        cam.createAccount(newAccount);

        System.out.println("Do you want to create another account?"); // Asks user if they want to create another account
        if(input.next().equals("Y")){
            creatingAccount();
        } else {
           cam.viewListOfAccounts();
        }


    } // end of creatingAccount

    // displays all accounts saved in CAM
    public void displayAllAccounts(){
        cam.viewListOfAccounts();
    }

} // end of class
