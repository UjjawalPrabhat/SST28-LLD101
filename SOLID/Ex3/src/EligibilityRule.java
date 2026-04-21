public interface EligibilityRule {
    public boolean evaluate(StudentProfile s);
    public String reasonForFailure();
}
