import java.util.*;

public class EligibilityEngine {
    private final EligibilityRepository store;

    public EligibilityEngine(EligibilityRepository store) { this.store = store; }

    public void runAndPrint(StudentProfile s) {
        EligibilityEngineResult r = Evaluation.evaluate(s);

        ReportPrinter p = new ReportPrinter();
        p.print(s, r);
        
        store.save(s.rollNo, r.status);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
