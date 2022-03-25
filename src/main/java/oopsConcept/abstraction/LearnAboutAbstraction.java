package oopsConcept.abstraction;

/*
 * Reducing complexity by hiding unnecessary details
 * */
public class LearnAboutAbstraction {

    public static void main(String[] args) {
        var mailService = new MailService();
        mailService.sendEmail();
    }
}
