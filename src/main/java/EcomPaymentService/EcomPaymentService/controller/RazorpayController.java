package EcomPaymentService.EcomPaymentService.controller;


import EcomPaymentService.EcomPaymentService.dtos.InitiatePaymentDto;
import EcomPaymentService.EcomPaymentService.service.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class RazorpayController {


    @Autowired
    private PaymentService paymentService;
    @PostMapping("/")
    public String initiateRazorpay(@RequestBody InitiatePaymentDto initiatePaymentDto) throws RazorpayException {

      return   paymentService.initiatePayment(initiatePaymentDto.getOrderId(),initiatePaymentDto.getAmount());

    }


}
