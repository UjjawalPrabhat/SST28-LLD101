import java.nio.charset.StandardCharsets;

public class PdfExporter implements Exporter {
    public ExportResult export(ExportRequest req) {
        ExporterRules rules = new RequirementBodyNullRule();
        if (!rules.satisfies(req))
            throw new IllegalArgumentException("PDF cannot be null");

        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
