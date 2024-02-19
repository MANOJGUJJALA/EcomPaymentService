package EcomPaymentService.EcomPaymentService.paymentGateway;

import com.razorpay.RazorpayException;

public interface Paymentgateway {

    String genaratePayemntLink(Long Orderid,Long amount) throws RazorpayException;
}
