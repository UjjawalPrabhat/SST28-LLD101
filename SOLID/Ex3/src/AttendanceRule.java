public class AttendanceRule implements EligibilityRule {
    public boolean evaluate(StudentProfile s) {
        return s.attendancePct >= RuleInput.minAttendance;
    }

    public String reasonForFailure() {
        return "attendance below " + RuleInput.minAttendance;
    }
}
