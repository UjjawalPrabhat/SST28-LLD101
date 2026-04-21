import java.util.ArrayList;
import java.util.List;

public class Evaluation {

    public static EligibilityEngineResult evaluate(StudentProfile s) {
        List<EligibilityRule> rules = new ArrayList<>();
        rules.add(new DisciplinaryFlagRule());
        rules.add(new CgrRule());
        rules.add(new AttendanceRule());
        rules.add(new EarnedCreditsRule());

        List<String> reasons = new ArrayList<>();
        for (EligibilityRule rule : rules) {
            if (!rule.evaluate(s)) {
                reasons.add(rule.reasonForFailure());
                break;
            }
        }

        String status = reasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";
        return new EligibilityEngineResult(status, reasons);
    }
}
