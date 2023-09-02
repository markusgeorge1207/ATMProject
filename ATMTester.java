import java.io.IOException;
public class ATMTester
{
    public static void main (String [] args) throws IOException
    {
        ATM newAccount = new ATM ();
        newAccount.openAccount ("mgeorge", 120.0);
        newAccount.depositMoney ("mgeorge", 10000);
        System.out.println (newAccount.checkBalance("mgeorge"));
        newAccount.withdrawMoney ("mgeorge", 5000);
        System.out.println (newAccount.checkBalance("mgeorge"));
        ATM newAccount2 = new ATM ();
        newAccount2.openAccount ("mgeorge2@hwemail.com", 1000);
        newAccount.transferMoney ("mgeorge","mgeorge2@hwemail.com", 2000);
        System.out.println (newAccount.checkBalance("mgeorge"));
        System.out.println (newAccount2.checkBalance("mgeorge2@hwemail.com"));
        newAccount.audit ();
        newAccount2.audit ();
        newAccount.closeAccount("mgeorge");
        newAccount2.closeAccount ("mgeorge2@hwemail.com");
    }
}