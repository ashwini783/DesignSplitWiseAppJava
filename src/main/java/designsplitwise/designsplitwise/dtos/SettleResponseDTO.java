package designsplitwise.designsplitwise.dtos;

import designsplitwise.designsplitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SettleResponseDTO {
    private List<Transaction> transaction;
    private ResponseStatus responseStatus;
    private String message;
}
