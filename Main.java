import java.util.Calendar;
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500);
        Calendar date = Calendar.getInstance();

        DepositTransaction deposit = new DepositTransaction(200, date);
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(100, date);

        System.out.println("Initial Balance: $" + account.getBalance());

        // Test Deposit
        deposit.apply(account);

        // Test Withdrawal
        withdrawal.apply(account);

        // Test Reversal
        withdrawal.reverse(account);

        // Test Insufficient Funds
        WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(1000, date);
        largeWithdrawal.apply(account);
    }
}
