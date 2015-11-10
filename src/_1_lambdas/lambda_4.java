package _1_lambdas;

import java.io.File;
import java.util.Arrays;

/**
 * @author Dmitry Adonin
 * @since 11/10/2015
 */
public class lambda_4 {
    public static void main(String[] args) {
        String path = "C:\\Windows";
        File root = new File(path);
        File[] files = root.listFiles();
        //non-lambda style
        /*Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                if (f1.isDirectory() && !f2.isDirectory()) {
                    return -1;
                } else if (!f1.isDirectory() && f2.isDirectory()) {
                    return 1;
                } else {
                    return f1.getPath().compareTo(f2.getPath());
                }
            }
        });*/
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getPath().compareTo(f2.getPath());
            }
        });
        Arrays.asList(files).forEach(System.out::println);
    }
}
