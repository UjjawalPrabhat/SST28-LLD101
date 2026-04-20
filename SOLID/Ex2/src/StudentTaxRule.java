public class StudentTaxRule implements TaxRules {
    public double taxPercent(String customerType) {
        return customerType.equalsIgnoreCase("student") ? 5.0 : 0.0;
    }
}
