import java.util.List;
import java.util.Map;

public class InvoiceFormatter {

    public static void formatInv(String invId, StringBuilder out) {
        out.append("Invoice# ").append(invId).append("\n");
    }

    public static void formatMenuItems(List<OrderLine> lines, Map<String, MenuItem> menu, StringBuilder out) {
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
    }

    public static void formatTotal(double subtotal, double taxPct, double tax, double discount, double total,
            StringBuilder out) {
        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));
    }
}
