import java.util.HashMap;
import java.security.SecureRandom;

public class ClientAccountManagement {
    // Key: Integer ACCOUNT_NUMBER, Value: Arraylist ACCOUNTS
    private Integer PIN;
    private boolean pinIsEntered = false;
    public boolean IS_PIN_SETUP = false;
    public static HashMap<Integer, Account> listOfAccounts = new HashMap<Integer, Account>();
    private SecureRandom sr = new SecureRandom();

    public ClientAccountManagement(){
        // instantiating two accounts
        var account1 = new Account("David", "Santos", 1000.00, "Checking");
        var account2 = new Account("Melina", "Garcia", 2900.00, "Savings");

        // putting accounts into Hashmap listOfAccounts
        listOfAccounts.put(account1.getAccountNum(), account1);
        listOfAccounts.put(account2.getAccountNum(), account2);

    } // end of constructor

    //
    protected void createAccount(Account newlyCreatedAccount ){
       // accounts.add(newlyCreatedAccount);
        listOfAccounts.put(newlyCreatedAccount.getAccountNum(), newlyCreatedAccount);
        System.out.println("ACCOUNT ADDED TO HASHMAP");
        System.out.println(listOfAccounts);

    } // end of createAccount method

    // sets the PIN value for the account
    public void setPIN(int pinNumber){
        this.PIN = pinNumber;
    }

    // returns an account with a key
    public Account getAccount(Integer accountNumber){
        return listOfAccounts.get(accountNumber);
    }

    // TODO setup decyrption for PIN method here

    // returns whether the pin has been entered
    public boolean hasPINBeenEntered(){
        return pinIsEntered;
    }

    // views every account that is stored in the hashmap
    public void viewListOfAccounts(){
        if(listOfAccounts.isEmpty()){
            System.err.println("HashMap is Empty");
        } else {
            for(Account a: listOfAccounts.values()){
                a.accountInfo();
            } // prints all the accounts in
        }
        
    } // end of viewListOfAccounts




} // end of class
