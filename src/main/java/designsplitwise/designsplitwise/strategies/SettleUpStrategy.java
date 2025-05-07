package designsplitwise.designsplitwise.strategies;

import designsplitwise.designsplitwise.models.Expense;
import designsplitwise.designsplitwise.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    public List<Transaction> settleUpStrategy(List<Expense>expenses);
}
