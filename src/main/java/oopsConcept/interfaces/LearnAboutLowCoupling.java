package oopsConcept.interfaces;

public class LearnAboutLowCoupling {

    public static void main(String[] args) {
        TaxCalculator taxCalculator = getCalculator();
        System.out.println(taxCalculator.calculateTax());
    }

    public static TaxCalculator getCalculator() {
        return new CalculateTax2021();
    }
}
