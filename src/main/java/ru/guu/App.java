package ru.guu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private TextField field1;
    private TextField field2;
    private Label resultLabel;

    @Override
    public void start(Stage stage) {
        // Поля ввода
        field1 = new TextField();
        field1.setPromptText("Первое число");

        field2 = new TextField();
        field2.setPromptText("Второе число");

        // Кнопка вычисления
        Button calcButton = new Button("Вычислить сумму");
        calcButton.setOnAction(e -> calculate());

        // Кнопка очистки (самостоятельная работа)
        Button clearButton = new Button("Очистить");
        clearButton.setOnAction(e -> clearForm());

        // Метка результата
        resultLabel = new Label("Результат: ");

        // Контейнер
        VBox root = new VBox(12);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                new Label("Введите два числа:"),
                field1,
                field2,
                calcButton,
                clearButton,
                resultLabel
        );

        Scene scene = new Scene(root, 320, 280);
        stage.setTitle("Сумма двух чисел");
        stage.setScene(scene);
        stage.show();
    }

    private void calculate() {
        String text1 = field1.getText().trim();
        String text2 = field2.getText().trim();

        if (text1.isEmpty() || text2.isEmpty()) {
            resultLabel.setText("Ошибка: заполните оба поля");
            return;
        }

        try {
            double a = Double.parseDouble(text1.replace(',', '.'));
            double b = Double.parseDouble(text2.replace(',', '.'));
            double sum = a + b;
            resultLabel.setText("Результат: " + sum);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Ошибка: введите корректные числа");
        }
    }

    private void clearForm() {
        field1.clear();
        field2.clear();
        resultLabel.setText("Результат: ");
        field1.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
