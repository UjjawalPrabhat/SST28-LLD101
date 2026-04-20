public class StaffTaxRule implements TaxRules {
    public double taxPercent(String customerType) {
        return customerType.equalsIgnoreCase("staff") ? 2.0 : 0.0;
    }
}
