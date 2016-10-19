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
      transferFunds(fromAccount, toAccount, transferAmount);
  }
}

private void transferFunds(CustomerAccount account1,
    CustomerAccount account2, double transferAmount) {
  double balance;
  CustomerAccount holder = null;
  // We want to always synchronize first on the account with the
  // smaller account type value. If it turns out that the "second"
  // account actually has a larger type value, we'll simply
  // switch the two references and multiply the amount being
  // transferred by -1.
  if (account1.getAccountType() > account2.getAccountType()) {
    holder = account1;
    account1 = account2;
    account2 = holder;
    transferAmount *= -1;
  }
  synchronized (account1) {
    synchronized (account2) {
     balance = account1.getBalance();
     balance -= transferAmount;
     account1.setBalance(balance);
     balance = account2.getBalance();
     balance += transferAmount;
     account1.setBalance(balance);
    }
  }
}

}