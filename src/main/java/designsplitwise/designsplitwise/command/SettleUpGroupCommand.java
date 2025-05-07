package designsplitwise.designsplitwise.command;

import designsplitwise.designsplitwise.controllers.SettleUpGroupController;
import designsplitwise.designsplitwise.dtos.SettleResponseDTO;
import designsplitwise.designsplitwise.dtos.SettleUpGroupRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SettleUpGroupCommand implements Command {
    @Autowired
    private SettleUpGroupController settleUpGroupController;
//    @Autowired
//    public SettleUpGroupCommand(SettleUpGroupController settleUpGroupController) {
//        this.settleUpGroupController = settleUpGroupController;
//    }
    @Override
    public void execute(String input) {
      String[] words = input.split(" ");
      Integer groupId = Integer.parseInt(words[1]);

        SettleUpGroupRequestDTO request=new SettleUpGroupRequestDTO();
        request.setGroupId(groupId);
        SettleResponseDTO response=settleUpGroupController.settleUpGroup(request);
        System.out.println(response.getMessage());
    }

    @Override
    public boolean matches(String input) {
        String[] words = input.split(" ");
        return words[0].equals("SettleUpGroup") && words.length == 2;
    }
}
