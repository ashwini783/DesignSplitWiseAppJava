package designsplitwise.designsplitwise.controllers;

import designsplitwise.designsplitwise.dtos.ResponseStatus;
import designsplitwise.designsplitwise.dtos.SettleResponseDTO;
import designsplitwise.designsplitwise.dtos.SettleUpGroupRequestDTO;
import designsplitwise.designsplitwise.exceptions.GroupNotFoundException;
import designsplitwise.designsplitwise.models.Transaction;
import designsplitwise.designsplitwise.services.SettleUpGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.*;
@Controller
public class SettleUpGroupController {
    SettleUpGroupService settleUpGroupService;

    @Autowired
    SettleUpGroupController(SettleUpGroupService settleUpGroupService) {
        this.settleUpGroupService = settleUpGroupService;
    }

    public SettleResponseDTO settleUpGroup(SettleUpGroupRequestDTO requestDTO){
        SettleResponseDTO responseDTO = new SettleResponseDTO();
        try{
            List<Transaction> transactions=settleUpGroupService.settleUpGroup(requestDTO.getGroupId());
            responseDTO.setTransaction(transactions);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Settle Up Group Successfully");
        }
        catch(Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILED);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
