public class RequirementBodyNullRule implements ExporterRules {
    public boolean satisfies(ExportRequest req){
        return req.body != null;
    }
}
