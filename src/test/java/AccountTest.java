import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void balanceWithdraw(){
        var account = new Account("Franklin", "Arias", 1900.51, "Checking"); // var infers the type of class it is
        account.withdraw(900.51);
        assertEquals(1000.00,account.getBalance());
    }

    @Test
    void overdraftAccount(){
        var account = new Account();
        account.setBalance(-2000.00);
        assertEquals(-1.0, account.withdraw(200));
    }

    @Test
    void depositAccountPositiveAmount(){
        var account = new Account();
        account.setBalance(1000);
        assertEquals(2000,account.deposit(1000));
    }

    @Test
    void depositAccountNegativeAmount(){
        var account = new Account();
        account.setBalance(-2000);
        assertEquals(-1000,account.deposit(1000));
    }

}