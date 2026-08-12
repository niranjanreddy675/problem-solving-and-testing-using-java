import java.util.*;

class Authentication {

    private Map<String, String> users = new HashMap<>();

    Authentication() {
        users.put("admin", "admin123");
        users.put("user123", "password");
        users.put("testuser", "test1234");
    }

    public boolean login(String username, String password) {

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

        return users.containsKey(username)
                && users.get(username).equals(password);
    }
}

public class task10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Authentication auth = new Authentication();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String username = sc.next();
            String password = sc.next();

            try {

                boolean success = auth.login(username, password);

                if (success) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("FAILURE");
                }

            } catch (Exception e) {
                System.out.println("FAILURE");
            }
        }

        sc.close();
    }
}