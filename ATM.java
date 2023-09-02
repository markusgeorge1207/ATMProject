import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<String, Double> accounts;

    public ATM() {
        accounts = new HashMap<>();
    }
    public void openAccount(String userId, double amount) {
        if (!accounts.containsKey(userId)) {
            accounts.put(userId, amount);
        } else {
            throw new RuntimeException("User already exists.");
        }
    }
    public void closeAccount(String userId) {
        if (accounts.containsKey(userId)) {
            double balance = accounts.get(userId);
            if (balance == 0.0) {
                accounts.remove(userId);
            } else {
                throw new RuntimeException("Withdraw all funds before closing the account.");
            }
        } else {
            throw new RuntimeException("Account not found.");
        }
    }
    public double checkBalance(String userId) {
        if (accounts.containsKey(userId)) {
            return accounts.get(userId);
        } else {
            throw new RuntimeException("Account not found.");
        }
    }
    public double depositMoney(String userId, double amount) {
        if (accounts.containsKey(userId)) {
            double balance = accounts.get(userId);
            balance += amount;
            accounts.put(userId, balance);
            return balance;
        } else {
            throw new RuntimeException("Account not found.");
        }
    }
    public double withdrawMoney(String userId, double amount) {
        if (accounts.containsKey(userId)) {
            double balance = accounts.get(userId);
            if (balance >= amount) {
                balance -= amount;
                accounts.put(userId, balance);
                return amount;
            } else {
                throw new RuntimeException("Insufficient funds.");
            }
        } else {
            throw new RuntimeException("Account not found.");
        }
    }
    public boolean transferMoney(String fromAccount, String toAccount, double amount) {
        if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount)) {
            double fromBalance = accounts.get(fromAccount);
            double toBalance = accounts.get(toAccount);
    
            if (fromBalance >= amount) {
                fromBalance -= amount;
                toBalance += amount;
                accounts.put(fromAccount, fromBalance);
                accounts.put(toAccount, toBalance);
                return true;
            } else {
                throw new RuntimeException("Insufficient funds for transfer.");
            }
        } else {
            throw new RuntimeException("One or both accounts not found.");
        }
    }
    public void audit() {
    try (PrintWriter writer = new PrintWriter(new FileWriter("AccountAudit.txt"))) {
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            writer.println(entry.getKey() + ": " + entry.getValue());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}







    
    
    
    

    

    
}
