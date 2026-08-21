Constraint-Driven Solution Design
public class Main {

    static class Bank {
        long[] balance;

        Bank(long[] balance) {
            this.balance = balance;
        }

        boolean valid(int account) {
            return account >= 1 && account <= balance.length;
        }

        boolean transfer(int account1, int account2, long money) {
            if (!valid(account1) || !valid(account2)) {
                return false;
            }

            if (balance[account1 - 1] < money) {
                return false;
            }

            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;

            return true;
        }

        boolean deposit(int account, long money) {
            if (!valid(account)) {
                return false;
            }

            balance[account - 1] += money;
            return true;
        }

        boolean withdraw(int account, long money) {
            if (!valid(account)) {
                return false;
            }

            if (balance[account - 1] < money) {
                return false;
            }

            balance[account - 1] -= money;
            return true;
        }
    }

    public static void main(String[] args) {

        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});

        System.out.println(bank.withdraw(3, 10));
        System.out.println(bank.transfer(5, 1, 20));
        System.out.println(bank.deposit(5, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));
    }
}
