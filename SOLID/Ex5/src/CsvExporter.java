import java.nio.charset.StandardCharsets;

public class CsvExporter implements Exporter {
    public ExportResult export(ExportRequest req) {
        ExporterRules rules = new RequirementBodyNullRule();

        if (!rules.satisfies(req))
            throw new IllegalArgumentException("Csv cannot be null");

        String body = req.body.replace("\n", " ").replace(",", " ");
        String csv = "title,body\n" + req.title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }
}
