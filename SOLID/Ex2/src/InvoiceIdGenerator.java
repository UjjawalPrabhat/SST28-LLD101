public class InvoiceIdGenerator {
    private int invoiceSeq = 1000;
    public String nextId() { return "INV-" + (++invoiceSeq);}
}
