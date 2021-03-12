package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ScrollBar");

        // будущая прокрутка
        ScrollBar scrolX = new ScrollBar(); // создаём
        scrolX.setMin(0);                   // минимальное значение
        scrolX.setMax(260);                 // максимальное значение
        scrolX.setValue(100);               // установленное значение

        // будущая прокрутка
        ScrollBar scrolY = new ScrollBar();
        scrolY.setMin(0);
        scrolY.setMax(260);
        scrolY.setValue(100);
        scrolY.setOrientation(Orientation.VERTICAL); // разворачиваем его вертикально
        scrolY.setTranslateY(20);                   // отступаем от края на 20 по Y

        // будущая прокрутка
        ScrollBar scrolZ = new ScrollBar();
        scrolZ.setMin(0);
        scrolZ.setMax(260);
        scrolZ.setValue(260);
        scrolZ.setTranslateX(100); // отступаем от края на 100 по Х

        // Создаем зеленный квадрат 100х100
        Rectangle rectangle = new Rectangle(100, 100, Color.GOLD);
        rectangle.setTranslateX(20);// отступаем от края на 20 по Х
        rectangle.setTranslateY(20);// отступаем от края на 20 по Y

        // действия на прокрутке
        scrolX.valueProperty().addListener(observable -> { // передвижение по Х
            rectangle.setTranslateX(20+scrolX.getValue());
        });
        scrolY.valueProperty().addListener(observable -> { // передвижение по Y
            rectangle.setTranslateY(20+scrolY.getValue());
        });
        scrolZ.valueProperty().addListener(observable -> { // заливка фигуры
            rectangle.setOpacity(scrolZ.getValue()/260);
        });

        Pane root = new Pane(); // Основая панель
        root.getChildren().addAll(scrolZ,scrolX,scrolY,rectangle);

        // добавление на сцены | на форму
        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);  // размер формы и сцена
        primaryStage.show(); // отобразить
    }

    public static void main(String[] args) {
        launch(args);
    }
}