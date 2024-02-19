package EcomPaymentService.EcomPaymentService.paymentGateway;

import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayImplementation implements Paymentgateway{

    @Autowired
    private RazorpayClient razorpayClient;

    @Override
    public String genaratePayemntLink(Long Orderid, Long amount) throws RazorpayException {

        JSONObject paymentLinkRequest=new JSONObject();

        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");


        paymentLinkRequest.put("reference_id","RP123434");
        paymentLinkRequest.put("expire_by", 1708342693);
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name", "Manoj");
        customer.put("contact","manojkumar");
        customer.put("email","balu88861@scaler.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Pradaan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
        paymentLinkRequest.put("callback_method","get");





        PaymentLink payment=razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.toString();
    }
}
