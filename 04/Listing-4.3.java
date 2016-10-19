public class AccountManager {

  private CustomerAccount savings;
  private CustomerAccount checking;

  public final static int SAVINGS_ACCOUNT = 1;
  public final static int CHECKING_ACCOUNT = 2;

  public static void main(String[] args) {
    int transfers = 1000000;
    try {
      transfers = Integer.parseInt(args[0]);
    } catch (Exception e) {}
    AccountManager am = new AccountManager(transfers);
  }

  public AccountManager(int transfers) {
    savings = new CustomerAccount(SAVINGS_ACCOUNT, 1000);
    checking = new CustomerAccount(CHECKING_ACCOUNT, 1000);
    java.text.NumberFormat formatter =
        java.text.NumberFormat.getCurrencyInstance(
        java.util.Locale.US);
    System.out.println("Total balance before transfers: " +
        formatter.format(savings.getBalance() +
        checking.getBalance()));
    TransferManager tm1 = new TransferManager(checking,
        savings, transfers);
    TransferManager tm2 = new TransferManager(savings,
        checking, transfers);

    // Create two threads
    Thread t1 = new Thread(tm1);
    Thread t2 = new Thread(tm2);
    // Initiate execution of the threads
    t1.start();
    t2.start();
    // Wait for both threads to complete execution
    try {
      t1.join();
      t2.join();
    } catch (Exception e) {};
    System.out.println("Total balance after transfers: " +
        formatter.format(savings.getBalance() +
        checking.getBalance()));
    }

    class TransferManager implements Runnable {

      private CustomerAccount fromAccount;
      private CustomerAccount toAccount;
      private int transferCount;

      public TransferManager(CustomerAccount fromacct,
          CustomerAccount toacct, int transfers) {
        fromAccount = fromacct;
        toAccount = toacct;
        transferCount = transfers;
      }

      public void run() {
        double balance;
        double transferAmount;
        for (int i = 0 ; i < transferCount; i++) {
          balance = fromAccount.getBalance();
          transferAmount = (int)(balance * Math.random());
          balance -= transferAmount;
          fromAccount.setBalance(balance);
          balance = toAccount.getBalance();
          balance += transferAmount;
          toAccount.setBalance(balance);
       }
     }

  }

  class CustomerAccount {

    private int accountType;
    private double balance;

    public CustomerAccount(int type, double bal) {
      accountType = type;
      balance = bal;
    }

    public int getAccountType() {
      return accountType;
    }

    public double getBalance() {
      return balance;
    }

    public void setBalance(double newbal) {
      balance = newbal;
    }

  }

}
