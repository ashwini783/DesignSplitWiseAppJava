package designsplitwise.designsplitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="user_expenses")
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
    private int amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;
}