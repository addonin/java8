package _3_examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;

/**
 * @author dimon
 * @since 01/12/15.
 */
public class Example_5 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("http://i68.tinypic.com/o54brd.jpg");
        //Image newImage = transform(image, Color::brighter);
        Image newImage = transform(image, (x, y, c) -> (
            (x <= 10 || x >= image.getWidth() - 10 || y <= 10 || y >= image.getHeight() - 10)
                    ? Color.GREY : c)
        );
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }

    /*public static Image transform(Image in, UnaryOperator<Color> f) {
        int x = (int) in.getWidth();
        int y = (int) in.getHeight();
        WritableImage out = new WritableImage(x, y);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                out.getPixelWriter().setColor(i, j, f.apply(in.getPixelReader().getColor(i, j)));
            }
        }
        return out;
    }*/

    public static Image transform(Image in, ColorTransformer transformer) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, transformer.apply(x, y, in.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }

}

@FunctionalInterface
interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);
}
