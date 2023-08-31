import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class ATM
{
    private int currentBalance;
    private String email;
    private String accountNumber;

    public ATM (String inputEmail, int initialBalance)
    {
        String accountNumber = "";
        email = inputEmail;
        currentBalance = initialBalance;
        for (int i = 0; i < 8; i++)
        {
            accountNumber = accountNumber + "" + (int)(Math.random() * 10);
        }
        this.accountNumber =  accountNumber;

    }


    public void deposit (int depositAmount) 
    {
        currentBalance += depositAmount;
    
}
public int checkBalance ()
{
    return currentBalance;
}
public int withdraw (int withdrawAmount)
{
    currentBalance = currentBalance - withdrawAmount;
    return currentBalance;
}

public void transfer (ATM otherAccount, int transferAmount)
{
    withdraw (transferAmount);
    otherAccount.deposit (transferAmount);
}

public void printAccount (String outputFile)
{
    try (BufferedWriter writer = new BufferedWriter (new FileWriter (outputFile)))
    {
        StringBuilder sb = new StringBuilder();
        sb.append (email + "\n");
        sb.append (accountNumber + "\n");
        sb.append (currentBalance + "\n");

        writer.write (sb.toString());

        writer.close();

    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
}
}

