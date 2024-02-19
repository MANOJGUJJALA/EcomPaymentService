package EcomPaymentService.EcomPaymentService.dtos;

import lombok.Data;

@Data
public class InitiatePaymentDto {

    private Long orderId;
    private Long amount;
}
