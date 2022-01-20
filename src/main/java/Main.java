import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to make a transaction? Y/N");
        boolean response = input.hasNext("Y");
        UserInterface ui = new UserInterface(response);


    } // end of main method

} // end of main.Main class
