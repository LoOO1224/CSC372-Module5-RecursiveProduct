import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class BankBalanceFX extends Application {

    private TextArea textArea;
    private BorderPane root;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        // ========== MenuBar ==========
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Options");

        MenuItem item1 = new MenuItem("Show Date & Time");
        MenuItem item2 = new MenuItem("Save to log.txt");
        MenuItem item3 = new MenuItem("Change Background (Random Green)");
        MenuItem item4 = new MenuItem("Exit");

        menu.getItems().addAll(item1, item2, item3, item4);
        menuBar.getMenus().add(menu);
        root.setTop(menuBar);

        // ========== TextArea (중앙) ==========
        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setStyle("-fx-font-size: 14px;");
        root.setCenter(textArea);

        // ========== Event Handlers ==========
        item1.setOnAction(e -> showDateTime());
        item2.setOnAction(e -> saveToFile());
        item3.setOnAction(e -> changeRandomGreenBackground());
        item4.setOnAction(e -> Platform.exit());

        // ========== Scene & Stage ==========
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Module 3 - JavaFX Menu Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // 1. 날짜 + 시간 출력
    private void showDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = "Current Date & Time: " + now.format(formatter) + "\n";
        textArea.appendText(dateTime);
    }

    // 2. log.txt 파일로 저장
    private void saveToFile() {
        String content = textArea.getText();
        if (content.isEmpty()) {
            textArea.appendText("Nothing to save!\n");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write("=== Log Entry: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " ===\n");
            writer.write(content);
            writer.write("\n\n");
            textArea.appendText("Successfully saved to log.txt\n");
        } catch (IOException ex) {
            textArea.appendText("Error saving file: " + ex.getMessage() + "\n");
        }
    }

    // 3. 랜덤 그린 배경색 변경
    private void changeRandomGreenBackground() {
        // 그린 계열 랜덤 색상 생성 (Hue 90~150 사이)
        double hue = 90 + random.nextDouble() * 60;           // 90 ~ 150
        double saturation = 0.5 + random.nextDouble() * 0.4;  // 0.5 ~ 0.9
        double brightness = 0.7 + random.nextDouble() * 0.3;  // 0.7 ~ 1.0

        Color randomGreen = Color.hsb(hue, saturation, brightness);
        root.setStyle("-fx-background-color: " + toHexString(randomGreen) + ";");
        
        textArea.appendText("Background changed to random green!\n");
    }

    // Color → Hex 문자열 변환
    private String toHexString(Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}