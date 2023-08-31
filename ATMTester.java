public class ATMTester
{
    public static void main (String [] args)
    {
        ATM newAccount = new ATM ("mgeorge1@hwemail.com", 0);
        newAccount.deposit (10000);
        System.out.println (newAccount.checkBalance());
        newAccount.withdraw (5000);
        System.out.println (newAccount.checkBalance());
        ATM newAccount2 = new ATM ("mdessner1@hwemail.com", 0);
        newAccount.transfer (newAccount2, 2000);
        System.out.println (newAccount.checkBalance());
        System.out.println (newAccount2.checkBalance());
        newAccount.printAccount ("accountInfo.txt");
        newAccount2.printAccount ("account.txt");
    }
}