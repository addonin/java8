package _1_lambdas;

/**
 * @author Dmitry Adonin
 * @since 11/10/2015
 */
public class lambda_5 {
    public static void main(String[] args) {
        //non-lambda style
        /*new Thread(uncheck(
                new RunnableEx() {
                    @Override
                    public void run() throws Exception {

                    }
                }
        )).start();*/

        //usually Thread.sleep needs to have exception handled, but...
        new Thread(uncheck(() -> Thread.sleep(1000))).start();
    }

    public static Runnable uncheck(RunnableEx runner) {
        //non-lambda style
        /*return new Runnable() {
            @Override
            public void run() {
                try {
                    runner.run();
                } catch (Exception ignored) {
                    //do nothing
                }
            }
        };*/
        return () -> {
            try {
                runner.run();
            } catch (Exception ignored) {
                //do nothing
            }
        };
    }
}

@FunctionalInterface
interface RunnableEx {
    void run() throws Exception;
}
