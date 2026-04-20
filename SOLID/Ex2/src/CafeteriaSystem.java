import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceRepository repo;
    private final InvoiceIdGenerator idGenerator;
    private final TaxRules taxRule;
    private final DiscountRules discountRule;

    CafeteriaSystem(InvoiceRepository repo, InvoiceIdGenerator idGenerator, TaxRules taxRule,
            DiscountRules discountRule) {
        this.repo = repo;
        this.idGenerator = idGenerator;
        this.taxRule = taxRule;
        this.discountRule = discountRule;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        StringBuilder out = new StringBuilder();

        String invId = idGenerator.nextId();
        InvoiceFormatter.formatInv(invId, out);

        InvoiceFormatter.formatMenuItems(lines, menu, out);

        Bill bill = new Bill(menu, customerType, lines, taxRule, discountRule);

        InvoiceFormatter.formatTotal(bill.subtotal, bill.taxPct, bill.tax, bill.discount, bill.total, out);

        String printable = out.toString();
        System.out.print(printable);

        repo.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + repo.countLines(invId) + ")");
    }
}
