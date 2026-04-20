public class StudentDiscountRule implements DiscountRules {
    public double discountAmount(String customerType, double subtotal, int distinctLines) {
        if (customerType.equalsIgnoreCase("student") && subtotal >= 180.0)
            return 10.0;
        return 0.0;
    }
}
