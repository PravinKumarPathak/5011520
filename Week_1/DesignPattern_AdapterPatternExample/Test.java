package AdapterPatternExample;

public class Test {
    public static void main(String[] args) {
        PaymentProcessor paytmGateway = new PaytmAdapter(new Paytm());
        PaymentProcessor phonepeGateway = new PhonePeAdapter(new PhonePe());

        double amount = 100.0;

        // Process payments using different payment gateways
        paytmGateway.processPayment(amount);
        phonepeGateway.processPayment(amount);
    }
}



interface PaymentProcessor {
    void processPayment(double amount);
}

class Paytm {
    public void makePayment(double amount) {
        // Paytm-specific payment processing logic
        System.out.println("Paid $" + amount + " via Paytm.");
    }
}

class PhonePe {
    public void charge(double amount) {
        // PhonePe-specific payment processing logic
        System.out.println("Charged $" + amount + " using PhonePe.");
    }
}

class PaytmAdapter implements PaymentProcessor {
    private Paytm paymentGateway;

    public PaytmAdapter(Paytm paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Convert our application's method to Paytm's method
        paymentGateway.makePayment(amount);
    }
}

class PhonePeAdapter implements PaymentProcessor {
    private PhonePe paymentGateway;

    public PhonePeAdapter(PhonePe paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        // Convert our application's method to PhonePe's method
        paymentGateway.charge(amount);
    }
}




