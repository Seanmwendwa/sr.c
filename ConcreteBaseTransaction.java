import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
public class ConcreteBaseTransaction extends BaseTransaction {

    public ConcreteBaseTransaction(int amount,@NotNull Calendar date) {
        super(amount, date);
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Amount: $" + getAmount());
    }

    @Override
    public void apply(BankAccount ba) {
        System.out.println("Applying base transaction. No specific logic here.");
    }
}
