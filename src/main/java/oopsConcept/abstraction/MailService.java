package oopsConcept.abstraction;

public class MailService {

    public void sendEmail() {
        connect(3);
        authenticate();
        //Send Email
        System.out.println("Sending email");
        disconnect();
    }

    private void connect() {
        System.out.println("Connect");
    }

    private void disconnect() {
        System.out.println("Disconnect");
    }

    private void authenticate() {
        System.out.println("Authenticate");
    }

    private void connect(int timeout) {
        System.out.println("Connect with timeout");
    }
}
