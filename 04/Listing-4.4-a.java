public void run() {
  double balance;
  double transferAmount;
  for (int i = 0 ; i < transferCount; i++) {
    synchronized (synchronizerObject) {
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
