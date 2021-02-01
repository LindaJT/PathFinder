
package pathFinder;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class UI extends Application {
    
        public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PathService service = new PathService();
        primaryStage.setTitle("Path Finder");
        
        VBox mainPane = new VBox(10);
        HBox inputPane = new HBox(10);
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        Label fileLabel = new Label("Add map file");
        TextField fileInput = new TextField();
        Text fileText = new Text("");
        Button fileButton = new Button("Submit");
        
        fileButton.setOnAction(e-> {
            String fileName = fileInput.getText();
            boolean success = service.readFile(fileName);
            if (success) {
                fileText.setText("File added");
            } else {
                fileText.setText("File not found or not readable");
            }
        });
        
        Text startCoordinatesText = new Text("Give start coordinates: ");
        Label xstartLabel = new Label("x start: ");
        TextField xstartInput = new TextField();
        Label ystartLabel = new Label("y end: ");
        TextField ystartInput = new TextField();
        
        Text endCoordinatesText = new Text("Give end coordinates: ");
        Label xendLabel = new Label("x end: ");
        TextField xendInput = new TextField();
        Label yendLabel = new Label("y end: ");
        TextField yendInput = new TextField();
        
        HBox optionsPane = new HBox(10);
        VBox astarPane = new VBox(10);
        VBox idastarPane = new VBox(10);
        
        Text distanceTitle = new Text("Find shortes path with ");
        Button aStarButton = new Button("A*");
        Text aStarDistance = new Text("----");
        Text aStarTime = new Text("----");
        
        Button idaStarButton = new Button("IDA*");
        Text idaStarDistance = new Text("----");
        Text idaStarTime = new Text("----");
        
        aStarButton.setOnAction(e -> {
            int xstart = Integer.parseInt(xstartInput.getText());
            int ystart = Integer.parseInt(ystartInput.getText());
            int xend = Integer.parseInt(xendInput.getText());
            int yend = Integer.parseInt(yendInput.getText());
            long aStartTime = System.currentTimeMillis();
            int distance = service.aStarDistance(xstart, ystart, xend, yend);
            long aEndTime = System.currentTimeMillis();
            String text = String.valueOf(distance);
            String text2 = String.valueOf(aEndTime - aStartTime);
            aStarDistance.setText(text);
            aStarTime.setText(text2);
            service.drawPath(true);
        });
        
        idaStarButton.setOnAction(e -> {
            int xstart = Integer.parseInt(xstartInput.getText());
            int ystart = Integer.parseInt(ystartInput.getText());
            int xend = Integer.parseInt(xendInput.getText());
            int yend = Integer.parseInt(yendInput.getText());
            long idaStartTime = System.currentTimeMillis();
            int distance = service.IDAStarDistance(xstart, ystart, xend, yend);
            long idaEndTime = System.currentTimeMillis();
            String text = String.valueOf(distance);
            String text2 = String.valueOf(idaEndTime - idaStartTime);
            idaStarDistance.setText(text);
            idaStarTime.setText(text2);
            service.drawPath(false);
        });
        
        astarPane.getChildren().addAll(aStarButton, aStarDistance, aStarTime);
        idastarPane.getChildren().addAll(idaStarButton, idaStarDistance, idaStarTime);
        optionsPane.getChildren().addAll(astarPane, idastarPane);
        
        inputPane.getChildren().addAll(fileInput, fileButton);
        
        
        mainPane.getChildren().addAll(fileLabel, inputPane, fileText, startCoordinatesText, xstartLabel, xstartInput,
                ystartLabel, ystartInput, endCoordinatesText, xendLabel, xendInput, yendLabel, yendInput, distanceTitle, optionsPane);       
        
        Scene inputScene = new Scene(mainPane, 700, 700);    
        primaryStage.setScene(inputScene);    
        
        primaryStage.show();
    }
    
}
