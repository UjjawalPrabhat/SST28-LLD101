public interface DiscountRules {
    double discountAmount(String customerType, double subtotal, int distinctLines);
}
