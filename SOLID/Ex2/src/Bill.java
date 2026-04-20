import java.util.List;
import java.util.Map;

public class Bill {
    public final double subtotal;
    public final double taxPct;
    public final double tax;
    public final double discount;
    public final double total;

    public Bill(Map<String, MenuItem> menu, String customerType, List<OrderLine> lines,
            TaxRules taxRule, DiscountRules discountRule) {
        this.subtotal = getMenuSubTotal(menu, lines);
        this.taxPct = taxRule.taxPercent(customerType);
        this.tax = calculateTax(taxPct, subtotal);
        this.discount = discountRule.discountAmount(customerType, subtotal, lines.size());
        this.total = subtotal + tax - discount;
    }

    public double getMenuSubTotal(Map<String, MenuItem> menu, List<OrderLine> lines) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
        }
        return subtotal;
    }

    public double calculateTax(double taxPct, double subtotal) {
        return subtotal * (taxPct / 100.0);
    }
}
