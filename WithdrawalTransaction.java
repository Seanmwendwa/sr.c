import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed = false;
    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    private boolean checkDepositAmount(int amt) {
        if (amt < 0) {
            return false;
        } else {
            return true;
        }
    }

    // Method to reverse the transaction
    public boolean reverse(BankAccount ba) {
        if (!reversed) {
            ba.setBalance(ba.getBalance() + getAmount());
            reversed = true;
            System.out.println("Reversal successful. New balance: $" + ba.getBalance());
            return true;
        }
        System.out.println("Reversal already applied.");
        return false;
    }

    // Method to print a transaction receipt or details
    public void printTransactionDetails() {
        System.out.println("Deposit Trasaction: " + this.toString());
    }


    public void apply(BankAccount ba) {
        try {
            double curr_balance = ba.getBalance();
            if (curr_balance >= getAmount()) {
                ba.setBalance(curr_balance - getAmount());
                System.out.println("Withdrew $" + getAmount() + ". New balance: $" + ba.getBalance());
            } else if (curr_balance > 0) {
                ba.setBalance(0);
                System.out.println("Partial withdrawal of $" + curr_balance + " made. Account balance is now $0.");
                throw new InsufficientFundsException("Remaining amount $" + (getAmount() - curr_balance) + " not withdrawn.");
            } else {
                throw new InsufficientFundsException("Insufficient funds. Withdrawal amount exceeds balance.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Transaction complete.");
        }
    }

}

