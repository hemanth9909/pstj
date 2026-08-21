BANK MANAGEMENT SYSTEM
  class Bank {
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValidAccount(account1) || !isValidAccount(account2)) {
            return false;
        }

        if (balance[account1 - 1] < money) {
            return false;
        }

        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;

        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) {
            return false;
        }

        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account)) {
            return false;
        }

        if (balance[account - 1] < money) {
            return false;
        }

        balance[account - 1] -= money;
        return true;
    }
}
Input
["Bank","withdraw","transfer","deposit","transfer","withdraw"]
[[[10,100,20,50,30]],[3,10],[5,1,20],[5,20],[3,4,15],[10,50]]
Output
[null,true,true,true,false,false]
