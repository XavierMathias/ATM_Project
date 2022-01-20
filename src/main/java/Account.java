import java.security.SecureRandom;

public class Account {

    private SecureRandom sr = new SecureRandom();
    private String firstName, lastName;
    private int accountNum;
    private double balance;
    private String accountType;

    public Account(String fn, String ln, double balance, String accountType){
        this.accountNum = sr.nextInt(7);
        this.balance = balance;
        this.firstName = fn;
        this.lastName = ln;
        this.accountType = accountType;
    } // end of constructor

    public Account(){
        this.accountNum = sr.nextInt(1000);
    }

    // returns the type of object's acccount
    public String getAccountType() {
        return accountType;
    }

    // Sets the type of account this object is
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // withdraws the account based on requested amount
    public double withdraw(double withdrawRequest){
        if (balance < 0){
            balance = balance - withdrawRequest;
            return -1.0;
        } else {
            balance = balance - withdrawRequest;
            return balance;
        } // end of if...else

    } // end of 

    public String accountInfo(){
        return "ACCOUNT NUMBER: " + accountNum
                + "\nmain.Account Number: " + accountNum
                + "\nName: " + firstName + " " + lastName
                + "\nBalance: " + balance;
    }

    // adds an deposit to the balance
    public double deposit(double depositAmount){
        balance += depositAmount;
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String toString(){
        return "\n\nACCOUNT NUMBER: " + accountNum
            + "\nFIRST NAME: " + firstName
            + "\nLAST NAME: " + lastName
            + "\nBALANCE: " + balance;
    }
}
