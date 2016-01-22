package _3_examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.BiFunction;

/**
 * Created by dmytro_adonin on 1/22/2016.
 */
public class Example_6 extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("http://i68.tinypic.com/o54brd.jpg");
        //Image newImage = transform(image, Color::brighter);
        /*Image newImage = transform(image, (x, y, c) -> (
                (x <= 10 || x >= image.getWidth() - 10 || y <= 10 || y >= image.getHeight() - 10)
                        ? Color.GREY : c)
        );*/
        Image newImage = transform(image, (color, factor) -> color.deriveColor(0, 1, factor, 1), 1.5);
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }

    static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, f.apply(in.getPixelReader().getColor(x, y), arg));
            }
        }
        return out;
    }
}
