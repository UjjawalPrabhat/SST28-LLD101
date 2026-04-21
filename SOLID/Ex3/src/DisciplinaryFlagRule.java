public class DisciplinaryFlagRule implements EligibilityRule{
    public boolean evaluate(StudentProfile s) {
        return s.disciplinaryFlag == LegacyFlags.NONE;
    }

    public String reasonForFailure() {
        return "disciplinary flag present";
    }
}
