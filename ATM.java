import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
public class ATM
{
    private double currentBalance;
    private String email;
    private String accountNumber;

    private HashMap<String, String> userID;

    public ATM ()
    {

    }
    public void openAccount (String inputEmail, double initialBalance) throws IOException
    {
        String accountNumber = "";

        currentBalance = initialBalance;
        for (int i = 0; i < 8; i++)
        {
            accountNumber = accountNumber + "" + (int)(Math.random() * 10);
        }
        this.accountNumber =  accountNumber;
        if (userID.isEmpty())
        {
            email = inputEmail;
            userID.put (email, accountNumber);
        }
        else if (userID.containsKey(email) == true)
        {
            throw new IOException ("This email is already in use");
            
        }
        else
        {
            email = inputEmail;
            userID.put (email, accountNumber);
        }

    }


    public void deposit (int depositAmount) 
    {
        currentBalance += depositAmount;
    
}
public void closeAccount(String inputID) throws IOException
{
    if (currentBalance != 0)
    {
        throw new IOException ("Need to withdraw current balance");
    }
    else
    {
        userID.remove(inputID, accountNumber);
    }
    
}
public double checkBalance ()
{
    return currentBalance;
}
public double withdraw (int withdrawAmount)
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

