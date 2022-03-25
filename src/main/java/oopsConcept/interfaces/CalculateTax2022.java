package oopsConcept.interfaces;

public class CalculateTax2022 implements TaxCalculator {
    @Override
    public float calculateTax() {
        return 2;
    }

    public float calculateInsurance(){
        return 3;
    }
}
