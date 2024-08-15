package DecoratorPatternExample;

public class Test {
    public static void main(String[] args) {
        // Create an EmailNotifier instance
        Notifier emailNotifier = new EmailNotifier();
        
        // Decorate with SMSNotifier
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        
        // Decorate further with SlackNotifier
        Notifier slackSMSNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        // Send notifications through decorated notifiers
        slackSMSNotifier.send("Hello, Java!!");
    }
}



interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email with message: " + message);
    }
}


abstract class NotifierDecorator implements Notifier {
    private Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}


class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS with message: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack message with: " + message);
    }
}

