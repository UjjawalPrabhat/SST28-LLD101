public class EarnedCreditsRule implements EligibilityRule {
    public boolean evaluate(StudentProfile s) {
        return s.earnedCredits >= RuleInput.minCredits;
    }

    public String reasonForFailure() {
        return "credits below " + RuleInput.minCredits;
    }
}
