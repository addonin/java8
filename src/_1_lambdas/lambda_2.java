package _1_lambdas;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Dmytro_Adonin on 11/9/2015.
 */
public class lambda_2 {

    public static void main(String[] args) {
        String path = "C:\\"; //should be replaced with arg
        File root = new File(path);
        //non-lambda style
        /*File[] dirs = root.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });*/
        File[] dirs = root.listFiles(File::isDirectory);
        Arrays.asList(dirs).forEach(System.out::println);
    }
}
