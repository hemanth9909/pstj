public class SecureAuthenticationStressTesting {
    static final String USERNAME = "admin";
    static final String PASSWORD = "java123";

    static boolean authenticate(String user, String pass) {
        return USERNAME.equals(user) && PASSWORD.equals(pass);
    }

    public static void main(String[] args) {
        int totalAttempts = 10000;
        int successful = 0;
        int failed = 0;

        long start = System.nanoTime();

        for (int i = 1; i <= totalAttempts; i++) {
            String user;
            String pass;

            if (i % 2 == 0) {
                user = "admin";
                pass = "java123";
            } else {
                user = "user";
                pass = "wrong";
            }

            if (authenticate(user, pass)) {
                successful++;
            } else {
                failed++;
            }
        }

        long end = System.nanoTime();
        double timeMs = (end - start) / 1_000_000.0;

        System.out.println("Total Attempts: " + totalAttempts);
        System.out.println("Successful Logins: " + successful);
        System.out.println("Failed Logins: " + failed);
        System.out.printf("Execution Time: %.3f ms%n", timeMs);
    }
}
Total Attempts: 10000
Successful Logins: 5000
Failed Logins: 5000
Execution Time: [measured time] ms
