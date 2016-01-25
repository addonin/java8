package _3_examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by dmytro_adonin on 1/22/2016.
 */
public class Example_8 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("http://i68.tinypic.com/o54brd.jpg");
        //Image newImage = transform(image, Color::brighter);
        Image newImage = transform(image, getColorTransformerWithBorder(image, 25, Color.WHITE));
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }

    private static ColorTransformer getColorTransformerWithBorder(Image image, int px, Color color) {
        return (x, y, colorAtXY) -> (
            (x <= px || x >= image.getWidth() - px || y <= px || y >= image.getHeight() - px)
                    ? color : colorAtXY
        );
    }

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

    @FunctionalInterface
    interface ColorTransformer {
        Color apply(int x, int y, Color colorAtXY);
    }

}
