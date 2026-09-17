import java.util.*;

class Authentication {

    private Map<String, String> users = new HashMap<>();

    Authentication() {
        users.put("admin", "admin123");
        users.put("user123", "password");
        users.put("testuser", "test1234");
    }

    public boolean login(String username, String password) {

        try {

            // Null validation
            if (username == null || password == null) {
                return false;
            }

            // Boundary validation
            if (username.length() < 3 || username.length() > 20) {
                return false;
            }

            if (password.length() < 6 || password.length() > 20) {
                return false;
            }

            // Authentication
            if (users.containsKey(username)) {
                return users.get(username).equals(password);
            }

            return false;

        } catch (Exception e) {
            return false;
        }
    }
}

public class syllabus_task10_secureauthenctication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Authentication authentication = new Authentication();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String username = sc.next();
            String password = sc.next();

            boolean result = authentication.login(username, password);

            if (result) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILURE");
            }
        }

        sc.close();
    }
}
