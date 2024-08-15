package StrategyPatternExample;

public class Test {
    public static void main(String[] args) {
        // Create the context
        PaymentContext paymentContext = new PaymentContext();

        // Set and use Credit Card payment strategy
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        paymentContext.setPaymentStrategy(creditCard);
        paymentContext.executePayment(100.0);

        // Set and use PayPal payment strategy
        PaymentStrategy payPal = new PayPalPayment("john.doe@example.com");
        paymentContext.setPaymentStrategy(payPal);
        paymentContext.executePayment(200.0);
    }
}

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card.");
        // Additional credit card processing logic
    }
}


class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal.");
        // Additional PayPal processing logic
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}


