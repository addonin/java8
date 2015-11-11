package _1_lambdas;

/**
 * @author Dmitry Adonin
 * @since 11/10/2015
 */
public class Lambda_9 {
    public static void main(String[] args) {
        new Thread(andThen(() -> {
            System.out.println("I'm R1");
        }, () -> {
            System.out.println("I'm R2");
        })).start();
    }

    public static Runnable andThen(Runnable r1, Runnable r2) {
        return () -> {
            r1.run();
            r2.run();
        };
    }
}
