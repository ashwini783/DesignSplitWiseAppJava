package designsplitwise.designsplitwise.services;

import designsplitwise.designsplitwise.exceptions.GroupNotFoundException;
import designsplitwise.designsplitwise.models.Expense;
import designsplitwise.designsplitwise.models.Group;
import designsplitwise.designsplitwise.models.Transaction;
import designsplitwise.designsplitwise.repositories.GroupRepository;
import designsplitwise.designsplitwise.strategies.SettleUpStrategyFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Service
public class SettleUpGroupService {
    private GroupRepository groupRepository;

    @Autowired
    SettleUpGroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Transaction> settleUpGroup(Long groupId) throws GroupNotFoundException {
        //1.Get the group
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()){
          throw new GroupNotFoundException("Group Not Found For Given GroupId");
        }
        Group group = groupOptional.get();
        List<Expense>expenses=group.getExpenses();
        return SettleUpStrategyFactory.getSettleUpStrategy(group.getStrategyType()).settleUpStrategy(expenses);
    }
}
