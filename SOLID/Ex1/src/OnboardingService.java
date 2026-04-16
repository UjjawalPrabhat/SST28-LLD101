import java.util.*;

public class OnboardingService {
    private final StudentRepository repo;

    public OnboardingService(StudentRepository repo) { this.repo = repo; }

    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        Map<String,String> kv=ConsoleInput.parseRawInput(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        List<String> errors = Validation.validateParsedValue(name, email, phone, program);
        if(!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        repo.save(rec);

        Print.print(id,rec,repo.count());
    }
}
