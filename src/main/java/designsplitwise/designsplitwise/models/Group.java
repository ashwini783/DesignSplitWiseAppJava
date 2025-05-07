package designsplitwise.designsplitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="user_groups")
public class Group extends BaseModel{
    private String name;
    @ManyToMany
    private List<User> members;
    @ManyToOne
    private User admin;

    @OneToMany(mappedBy = "group") //in bidirectional relationShip in OneTOMany relationShip, extra table is created
    private List<Expense>expenses; //to save that extra table creation you have to tell this particular entry should actually
    //mapped to what colum in other table i.e  expenses is mapping to 'group' col in Expense class
    @Enumerated(EnumType.STRING)
    private StrategyType strategyType;
}
