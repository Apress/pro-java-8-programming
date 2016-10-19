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
     synchronized (fromAccount) {
       balance = fromAccount.getBalance();
       transferAmount = (int)(balance * Math.random());
       balance -= transferAmount;
       fromAccount.setBalance(balance);
       synchronized (toAccount) {
         balance = toAccount.getBalance();
         balance += transferAmount;
         toAccount.setBalance(balance);
       }
     }
    }
  }

}
