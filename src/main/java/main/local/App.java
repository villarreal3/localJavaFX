package main.local;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    public class ExitButtonListener implements EventHandler<ActionEvent> {

            @Override
            public void handle(ActionEvent arg0) {
                Platform.exit();
        }
    }
    
    class screenSize{
        private double Height, Width;
        private Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        screenSize(){
            Height = screenBounds.getHeight();
            Width = screenBounds.getWidth();
        }
        public double getHeight(){
            return Height;
        }
        public double getWidth(){
            return Width;
        }
    }
    
    class anchorPane {
        protected AnchorPane getAnchorPane(){
            var anchorPane = new AnchorPane(this.getBorderPane());
            anchorPane.setStyle("-fx-background-color:white;");
            
            return anchorPane;
            
        }
        
        private BorderPane getBorderPane(){
            var centerBorder = new AnchorPane(this.getFactura());
            var leftBorder = new VBox(this.getBorderPaneLeft(centerBorder));
            
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(centerBorder);
            borderPane.setLeft(leftBorder);
            
            return borderPane;
        }
        
        private VBox getBorderPaneLeft(AnchorPane l){
            Button btnFactura = new Button("Facturacion");
            btnFactura.setStyle(""
                    + "-fx-background-color:#111111;"
                    + "-fx-text-fill: white;"
                    + "-fx-font-size: 25px;"
            );
            Button btnVista = new Button("Vista");
            btnVista.setStyle(""
                    + "-fx-background-color:#111111;"
                    + "-fx-text-fill: white;"
                    + "-fx-font-size: 25px;"
            );
            Button btnExit = new Button("Salir");
            btnExit.setStyle(""
                    + "-fx-background-color:#FF4A4A;"
                    + "-fx-text-fill: white;"
                    + "-fx-font-size: 25px;"
            );
            btnExit.setOnAction(new ExitButtonListener());
            
            btnFactura.setPrefWidth(200);
            btnVista.setPrefWidth(200);
            btnExit.setPrefWidth(200);
            
            screenSize screen = new screenSize();
            double height = screen.getHeight()/3;
            
            btnFactura.setPrefHeight(height);
            btnVista.setPrefHeight(height);
            btnExit.setPrefHeight(height);
            
            
            EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){
                    l.setVisible(true);
                }
            };
            EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e){
                    l.setVisible(false);
                }
            };
  
            // when button is pressed
            btnFactura.setOnAction(event1);
            btnVista.setOnAction(event2);
            VBox box = new VBox();
            box.getChildren().addAll(btnFactura, btnVista, btnExit);
            return box;
        }
        
        private AnchorPane getFactura(){
            
            screenSize screen = new screenSize();
            
            Label lblOption = new Label("Lavar automovil");
            
            ObservableList<String> options = 
            FXCollections.observableArrayList(
                "Si",
                "No"
            );
            ComboBox cbxOption = new ComboBox(options);
            
            Button renameButton = new Button("Rename");
            
            cbxOption.setPrefWidth(200);
            
            Label lblPlaca = new Label("Placa");       
      
            TextField txtPlaca = new TextField(); 
            
            //creating label password 
            Label lblModelo = new Label("Modelo");      
      
            //Creating Text Filed for password        
            TextField txtModelo = new TextField();  
            String prueba = (String) cbxOption.getValue();
       
            //Creating Buttons 
            Button button1 = new Button("Submit"); 
            button1.setStyle("-fx-background-color:white;");
            Button button2 = new Button("Clear");
      
            //Creating a Grid Pane 
            GridPane gridPane = new GridPane();    
      
            //Setting size for the pane  
            gridPane.setMinSize(((screen.Width)-200), 200);
            gridPane.setStyle("-fx-background-color:green;");
       
            //Setting the padding  
            gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
            //Setting the vertical and horizontal gaps between the columns 
            gridPane.setVgap(5); 
            gridPane.setHgap(5);       
      
            //Setting the Grid alignment 
            gridPane.setAlignment(Pos.CENTER); 
       
            //Arranging all the nodes in the grid
            gridPane.add(lblOption, 0, 0); 
            gridPane.add(cbxOption, 1, 0);
            gridPane.add(lblPlaca, 0, 1); 
            gridPane.add(txtPlaca, 1, 1); 
            gridPane.add(lblModelo, 0, 2);       
            gridPane.add(txtModelo, 1, 2); 
            gridPane.add(button1, 0, 3); 
            gridPane.add(button2, 1, 3); 
            
            var anchorPane = new AnchorPane(gridPane);
        
            anchorPane.setStyle("-fx-background-color:white;");
        
        
            return anchorPane;
        }
        
        private AnchorPane getVista(){
            var javaVersion = SystemInfo.javaVersion();
            var javafxVersion = SystemInfo.javafxVersion();
            var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
            
            var anchorPane = new AnchorPane(label);
        
            anchorPane.setStyle("-fx-background-color:white;");
        
        
            return anchorPane;
        }
    }
    
    class login {
        protected AnchorPane logIn(){
            var anchorData = new AnchorPane(this.data());
            
            var anchorPane = new AnchorPane(anchorData);
            
            screenSize screen = new screenSize();
            
            
            
            //stackPane.setLocation(screen.getWidth()/2, screen.getHeight()/2);
            
            anchorPane.setStyle("-fx-background-image: url('file:/home/dan-linux/Documentos/imgJava/modern-6528732.png'); -fx-background-repeat: no-repeat; -fx-background-size: "+ screen.getWidth() + " " + screen.getHeight() +";");
            
            return anchorPane;
        }
        
        private AnchorPane data() {
            double width = 500;
            double height = 250;
            
            Label lblUser = new Label("Usuario");
            TextField txtUser = new TextField(); 
            
            Label lblPassword = new Label("Contrasena");
            TextField txtPassword = new TextField();
            
            
            
            GridPane gridPane = new GridPane();    
            
            gridPane.setPrefWidth(width);
            gridPane.setPrefHeight(height);
      
            //Setting the vertical and horizontal gaps between the columns 
            gridPane.setVgap(5); 
            gridPane.setHgap(5);       
      
            //Setting the Grid alignment 
            gridPane.setAlignment(Pos.CENTER); 
       
            //Arranging all the nodes in the grid
            gridPane.add(lblUser, 0, 0); 
            gridPane.add(txtUser, 1, 0);
            gridPane.add(lblPassword, 0, 1); 
            gridPane.add(txtPassword, 1, 1); 
            gridPane.add(new Button("Si"), 0, 2);       
            gridPane.add(new Button("No"), 1, 2);
            
            
            var anchorPane = new AnchorPane(gridPane);
            screenSize screen = new screenSize();
            
            
            anchorPane.setStyle("-fx-background-color: rgba(255, 255, 255, 1);"
                    + "-fx-border-radius: 50;\n"
                    + "-fx-background-radius: 50;");
            anchorPane.setPrefWidth(width);
            anchorPane.setPrefHeight(height);
            anchorPane.setLayoutX((screen.getWidth()/2)-(width/2));
            anchorPane.setLayoutY((screen.getHeight()/2)-(height/2));
            
            return anchorPane;
        }
    }

    @Override
    public void start(Stage stage) {
        anchorPane panel = new anchorPane();
        login session = new login();
        
        var scene = new Scene(session.logIn(), 640, 480);
        stage.setScene(scene);
        stage.setMaximized(true);
        //stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}