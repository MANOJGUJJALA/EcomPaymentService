package EcomPaymentService.EcomPaymentService.service;

import EcomPaymentService.EcomPaymentService.paymentGateway.Paymentgateway;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired

    private Paymentgateway paymentgateway;



    public String initiatePayment(Long OrderId, Long amount) throws RazorpayException {

      return   paymentgateway.genaratePayemntLink(OrderId,amount);

    }

}
