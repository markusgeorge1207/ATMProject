import java.io.IOException;
public class ATMTester
{
    public static void main (String [] args) throws IOException
    {
        ATM newAccount = new ATM ();
        newAccount.deposit (10000);
        System.out.println (newAccount.checkBalance());
        newAccount.withdraw (5000);
        System.out.println (newAccount.checkBalance());
        ATM newAccount2 = new ATM ();
        newAccount2.openAccount ("mdessner1@hwemail.com", 10);
        newAccount.transfer (newAccount2, 2000);
        System.out.println (newAccount.checkBalance());
        System.out.println (newAccount2.checkBalance());
        newAccount.printAccount ("accountInfo.txt");
        newAccount2.printAccount ("account.txt");
        newAccount.closeAccount("mgeorge1@hwemail.com");
        newAccount2.closeAccount ("mdessner1@hwemail.com");
        newAccount.printAccount("noAccount.txt");
        newAccount.printAccount ("noAccount2.txt");
    }
}