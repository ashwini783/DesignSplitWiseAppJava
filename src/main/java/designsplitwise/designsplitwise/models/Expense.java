package designsplitwise.designsplitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.*;
@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private int totalAmount;
    @OneToMany(mappedBy = "expense")
    private List<UserExpense>userExpense;
    @ManyToOne
    private Group group;
    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;


}