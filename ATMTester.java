import java.io.IOException;
public class ATMTester
{
    public static void main (String [] args) throws IOException
    {
        ATM newAccount = new ATM ();
        newAccount.openAccount ("mgeorge1", 120.0);
        newAccount.depositMoney ("mgeorge1", 10000);
        System.out.println (newAccount.checkBalance("mgeorge1"));
        newAccount.withdrawMoney ("mgeorge1", 5000);
        System.out.println (newAccount.checkBalance("mgeorge1"));
        newAccount.openAccount ("mgeorge2", 1000);
        newAccount.transferMoney ("mgeorge1","mgeorge2", 2000);
        System.out.println (newAccount.checkBalance("mgeorge1"));
        System.out.println (newAccount.checkBalance("mgeorge2"));
        newAccount.audit ();
        newAccount.audit ();
        newAccount.withdrawMoney ("mgeorge1", 3120);
        newAccount.withdrawMoney ("mgeorge2", 3000);
        newAccount.closeAccount("mgeorge1");
        newAccount.closeAccount ("mgeorge2");
    }
}