/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tony.multijuego.controller;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tony.multijuego.App;
import tony.multijuego.Fondo;
import tony.multijuego.Item;
import tony.multijuego.Personaje;
import tony.multijuego.PersonajeAnimado;
import tony.multijuego.Tile;
import static tony.multijuego.controller.SeleccionarPersonajeViewController.sonidos;
import tony.multijuego.util.FlowController;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class InicioViewController extends Controller implements Initializable {

    @FXML
    private JFXButton btnIniciar;
    @FXML
    private BorderPane rootInicio;
    @FXML
    private JFXButton btnOpciones;
    @FXML
    private JFXButton btnCreditos;
    @FXML
    private JFXButton btnSalirr;
    @FXML
    private ImageView imgInicio;
    
    public HashMap<String, File> sonidosIncio;
    
    MediaPlayer mediaplayer;
    Media musicFile;
    
    public static MediaPlayer mediaFondo;
    Media musicFondo;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        imgInicio.setImage(new Image("tony/multijuego/resources/GokuGif.gif"));
        
        sonidosIncio = new HashMap<String, File>();
        
        sonidosIncio.put("Pop", new File("src/main/resources/tony/multijuego/resources/Music/facebook-pop.mp3"));
        sonidosIncio.put("Angeles", new File("src/main/resources/tony/multijuego/resources/Music/Angeles Fuimos.mp3"));
        
        File archivo = sonidosIncio.get("Angeles");
        musicFondo = new Media(archivo.toURI().toString());
        mediaFondo = new MediaPlayer(musicFondo);
    }    

    @Override
    public void initialize() {
        mediaFondo.play();
        mediaFondo.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
    }
    
    public void getSonido (String sonido) {
        File archivo = sonidosIncio.get(sonido);
        musicFile = new Media(archivo.toURI().toString());
        mediaplayer = new MediaPlayer(musicFile);
        mediaplayer.play();
    }

    @FXML
    private void onActionBtnIniciar(ActionEvent event) {
        getSonido("Pop");
        FlowController.getInstance().goViewInWindow("SeleccionarPersonajeView");
        getStage().close();
    }
    
    @FXML
    private void onActionBtnOpciones(ActionEvent event) {
       getSonido("Pop");
    }

    @FXML
    private void onActionBtnCreditos(ActionEvent event) {
        getSonido("Pop");
    }

    @FXML
    private void onActionBtnSalir(ActionEvent event) {
       getSonido("Pop");
       getStage().close();
    }
    
    
}
