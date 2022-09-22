package tony.multijuego;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import tony.multijuego.util.FlowController;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().InitializeFlow(stage,null);
        //stage.getIcons().add(new Image("cr/ac/una/proyecto1/resources/LogoApp.jpg"));
        stage.setTitle("TonyJuego");
        FlowController.getInstance().goViewInWindow("InicioView");
    }
    
    public static void main(String[] args) {
        launch();
    }
}