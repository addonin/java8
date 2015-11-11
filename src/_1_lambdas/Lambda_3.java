package _1_lambdas;

import java.io.File;
import java.util.Arrays;

/**
 * @author Dmitry Adonin
 * @since 11/10/2015
 */
public class Lambda_3 {
    public static void main(String[] args) {

        String rootPath = "C:\\Windows";
        String ext = ".exe";

        File root = new File(rootPath);
        //non-lambda style
        /*File[] files = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (!pathname.isDirectory()) {
                    String filename = pathname.getName();
                    int index = filename.lastIndexOf('.');
                    return filename.substring(index).equals(ext);
                }
                return false;
            }
        });*/
        File[] files = root.listFiles((pathname) -> {
            if (!pathname.isDirectory()) {
                String filename = pathname.getName();
                int index = filename.lastIndexOf('.');
                return filename.substring(index).equals(ext);
            }
            return false;
        });
        Arrays.asList(files).forEach(System.out::println);
    }
}
