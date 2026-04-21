public class CgrRule implements EligibilityRule {
    public boolean evaluate(StudentProfile s) {
        return s.cgr >= RuleInput.minCgr;
    }

    public String reasonForFailure() {
        return "CGR below " + RuleInput.minCgr;
    }
}