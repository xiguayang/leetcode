package TestDome.JAVA;


// Using JUnit4 Assert class write test cases
// . the deposit and withdraw methods will not accept negative numbers
// account cannot overstep its overdraft overdraftLimit
// the deposit and withdraw methods will deposit or withdraw correct amount 
// the withdraw and deposith methods return correct results



import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);
        
        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }
    
    @Test
    public void depositCannotHaveNegativeAmount(){
        Account account = new Account(20);
       
        Assert.assertEquals(account.deposit(-10),false);
       
    }
    
        
    @Test
    public void withdrawCannotHaveNegativeAmount(){
        Account account = new Account(20);
       
        Assert.assertEquals(account.withdraw(-10),false);
       
    }
    
    @Test
    public void accountCannotOverstepOverdraft(){
        Account account = new Account(20);
        account.deposit(10);
        Assert.assertEquals(account.withdraw(40),false);
    }
    
    @Test
    public void depositCorrectAmount(){
        Account account = new Account(20);
        account.deposit(10);
        Assert.assertEquals(account.getBalance(),10);
    }
    
    @Test
    public void withdrawCorrectAmount(){
        Account account = new Account(20);
        account.deposit(10);
        account.withdraw(20);
        Assert.assertEquals(account.getBalance(),-10);

    }

    @Test
    public void withdrawCorrect(){
        Account account = new Account(20);
        Assert.assertEquals(account.withdraw(10),true);
    }
    
    @Test
    public void depositCorrect(){
        Account account = new Account(20);
        Assert.assertEquals(account.deposit(10),true);
    }
    
}
