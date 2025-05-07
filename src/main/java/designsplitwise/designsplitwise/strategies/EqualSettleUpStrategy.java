package designsplitwise.designsplitwise.strategies;

import designsplitwise.designsplitwise.models.Expense;
import designsplitwise.designsplitwise.models.Transaction;

import java.util.List;

public class EqualSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUpStrategy(List<Expense> expenses) {
        return List.of();
    }
}
