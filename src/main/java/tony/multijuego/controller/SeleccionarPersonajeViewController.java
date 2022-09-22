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
import java.util.Timer;
import java.util.TimerTask;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import tony.multijuego.AtaqueAnimado;
import tony.multijuego.EnemigoAnimado;
import tony.multijuego.Fondo;
import tony.multijuego.Item;
import tony.multijuego.PersonajeAnimado;
import tony.multijuego.Tile;
import static tony.multijuego.controller.InicioViewController.mediaFondo;
import tony.multijuego.util.FlowController;

/**
 * FXML Controller class
 *
 * @author ANTHONY
 */
public class SeleccionarPersonajeViewController extends Controller implements Initializable {
    
    @FXML
    private AnchorPane rootSelec;
    @FXML
    private JFXButton btnIzquierda;
    @FXML
    private ImageView imgPersonaje;
    @FXML
    private JFXButton btnDerecha;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private JFXButton btnJugar;
    
    private static Scene escena;
    int i = 0;
    public int x = 100;
    public int y = 100;
    int t2;
    int t3 = 0;
    int direcc;
    int contador = 1;
    String PersonajeN;
    AnimationTimer animationTimer;
    Group root;
    public static Stage stage;
    public Canvas cvLienzo;
    public GraphicsContext graficos;
    public String image;
    boolean bandera = true;
    boolean salir = false;
    public static boolean arriba = false;
    public static boolean abajo = false;
    public static boolean derecha = false;
    public static boolean izquierda = false;
    public static boolean Atacando = false;
    boolean banderaSonido = true;
    public static HashMap<String, Image> imagenes;
    public static HashMap<String, File> sonidos;
    public ArrayList<Tile> tile;
    public ArrayList<AtaqueAnimado> ataque;
    public List<Image> listaPersonajes = new ArrayList<>();
    public List<String> listaPersonaje = new ArrayList<>();
    
    MediaPlayer mediaplayer;
    Media musicFile;
    
    MediaPlayer mediaJuego;
    Media musicJuego;
    
    //Personaje p1;
    PersonajeAnimado p1;
    EnemigoAnimado e1;
    Fondo fondo;
    Item item;
    Item item2;
    Item item3;
    
    private int tileMap [] [] = {
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {7,0,0,0,0,7,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0}
    };

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaPersonajes.add(new Image("tony/multijuego/resources/goku.png"));
        listaPersonajes.add(new Image("tony/multijuego/resources/Vegeta.png"));
        listaPersonaje.add("tony/multijuego/resources/goku.png");
        listaPersonaje.add("tony/multijuego/resources/Vegeta.png");
        sonidos = new HashMap<String, File>();
        sonidos.put("Sonido", new File("src/main/resources/tony/multijuego/resources/Music/facebook-pop.mp3"));
        sonidos.put("Radar", new File("src/main/resources/tony/multijuego/resources/Music/dragon_ball_radar.mp3"));
        sonidos.put("FondoJuego", new File("src/main/resources/tony/multijuego/resources/Music/DBZ Budokai Tenkaichi 3 .mp3"));
        imgPersonaje.setImage(listaPersonajes.get(0));
        
        File archivo = sonidos.get("FondoJuego");
        musicJuego = new Media(archivo.toURI().toString());
        mediaJuego = new MediaPlayer(musicJuego);
    }    

    @Override
    public void initialize() {
    }
    
    public void salir(AnimationTimer animationTimer) {
        if (salir) {
            animationTimer.stop();
            imagenes.clear();
            tile.clear();
            contador = 0;
            stage.close();
        }
    }
    
    public void IniciarJuego() {
        InicializarComponentes();
        stage.setScene(escena);
        GestionEventos();
        stage.show();
        mediaJuego.play();
        mediaJuego.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
        Pintar();
        CicloJuego();
    }
    
    public void InicializarComponentes() {
        PersonajeN = "";
        String EnemigoN = "";
        if("tony/multijuego/resources/goku.png".equals(listaPersonaje.get(i))) {
            PersonajeN = "GokuSST";
            EnemigoN = "VegetaSST";
        } else if("tony/multijuego/resources/Vegeta.png".equals(listaPersonaje.get(i))) {
            PersonajeN = "VegetaSST";
            EnemigoN = "GokuSST";
        }
        direcc = 1;
        stage = new Stage();
        ataque = new ArrayList<AtaqueAnimado>();
        imagenes = new HashMap<String, Image>();
        CargarImagenes();
        CargarSonidos();
        //p1 = new Personaje(100, 100, "Goku", 5, 100);
        p1 = new PersonajeAnimado(50, 100, 300, 400, PersonajeN, 3, "Descanso");
        p1.inicializarAnimaciones(PersonajeN);
        e1 = new EnemigoAnimado(50, 100, 525, 400, EnemigoN, 3, "Descanso", -1);
        e1.inicializarAnimaciones(EnemigoN);
        inicializarTiles();
        item = new Item(500, 250, 385, "Cell", 5, 0, 0);
        item2 = new Item(500, 575, 385, "Cell", 5, 0, 0);
        item3 = new Item(500, 500, 100, "Cell", 5, 0, 0);
        fondo = new Fondo(0, 0, "Namek", 2);
        //tile = new Tile("TileMap",100, 300, 420, 490, 70, 70, 0);
        root = new Group();
        escena = new Scene(root, 800, 600);
        cvLienzo = new Canvas(800, 600);
        root.getChildren().add(cvLienzo);
        graficos = cvLienzo.getGraphicsContext2D();
        salir = false;
    }
    
    public void inicializarTiles() {
        tile = new ArrayList<Tile>();
        for(int i = 0; i < tileMap.length; i++) {
            for(int j = 0; j < tileMap.length; j++) {
                if (tileMap [i] [j] != 0) {
                    this.tile.add(new Tile("TileMap2", tileMap [i] [j], j * 70, i * 70, 0, 0, 95, 435 ,0));
                }
            }
        }
    }
    
    public void CargarImagenes() {
        imagenes.put("Namek", new Image("tony/multijuego/resources/namek.jpg"));
        imagenes.put("Namek2", new Image("tony/multijuego/resources/namek2.jpg"));
        imagenes.put("TileMap", new Image("tony/multijuego/resources/tilemap.png"));
        imagenes.put("TileMap2", new Image("tony/multijuego/resources/TileMap2.png"));
        imagenes.put("GokuSS", new Image("tony/multijuego/resources/GokuSS.png"));
        imagenes.put("GokuSST", new Image("tony/multijuego/resources/GokuSSheet.png"));
        imagenes.put("VegetaSST", new Image("tony/multijuego/resources/VegetaSSheet.png"));
        imagenes.put("Cell", new Image("tony/multijuego/resources/minicell.png"));
        imagenes.put("Goku", new Image("tony/multijuego/resources/goku.png"));
        imagenes.put("Vegeta", new Image("tony/multijuego/resources/Vegeta.png"));
        //imagenes.put("BarraVida", new Image("tony/multijuego/resources/BarraVida.png"));
        imagenes.put("BarraVidaPoder", new Image("tony/multijuego/resources/BarraVidaPoder.png"));
        imagenes.put("VS", new Image("tony/multijuego/resources/VS.png"));
    }
    
    public void CargarSonidos() {
        sonidos.put("GolpeFuerte", new File("src/main/resources/tony/multijuego/resources/Music/golpe fuerte.wav"));
        sonidos.put("GolpeFuerte1", new File("src/main/resources/tony/multijuego/resources/Music/golpe fuerte al aire.wav"));
        sonidos.put("GolpeSimple", new File("src/main/resources/tony/multijuego/resources/Music/golpe simple doble.wav"));
        sonidos.put("GolpeSimple1", new File("src/main/resources/tony/multijuego/resources/Music/golpe simple doble al aire.wav"));
        sonidos.put("PatadaSimple", new File("src/main/resources/tony/multijuego/resources/Music/patada simple.wav"));
        sonidos.put("PatadaSimple1", new File("src/main/resources/tony/multijuego/resources/Music/patada simple al aire.wav"));
        sonidos.put("KamehamehaCorto", new File("src/main/resources/tony/multijuego/resources/Music/kamehameha.mp3"));
        sonidos.put("KamehamehaCharge", new File("src/main/resources/tony/multijuego/resources/Music/kame_charge.mp3"));
        //sonidos.put("Poder1", new File("src/main/resources/tony/multijuego/resources/Music/Explo de poder 1.wav"));//Error
        //sonidos.put("Tele", new File("src/main/resources/tony/multijuego/resources/Music/Teletransportación de Goku para tu celular.mp3"));
        sonidos.put("Tele", new File("src/main/resources/tony/multijuego/resources/Music/sonido de teletransportación _ dragón ball.mp3"));
        //sonidos.put("Tele2", new File("src/main/resources/tony/multijuego/resources/Music/teleport.mp3"));
        sonidos.put("CargarKi", new File("src/main/resources/tony/multijuego/resources/Music/Efecto de sonido de AURA DE SSJ DE DBZ.mp3"));
        sonidos.put("CargarKiDetener", new File("src/main/resources/tony/multijuego/resources/Music/Efecto de sonido de APAGAR KI DBZ.mp3"));
    }
    
    public void getSonido (String sonido) {
        File archivo = sonidos.get(sonido);
        musicFile = new Media(archivo.toURI().toString());
        mediaplayer = new MediaPlayer(musicFile);
        mediaplayer.play();
    }
    
    public void getSonidoRepetir (String sonido) {
        File archivo = sonidos.get(sonido);
        musicFile = new Media(archivo.toURI().toString());
        mediaplayer = new MediaPlayer(musicFile);
        mediaplayer.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
        mediaplayer.play();
    }
    
    public void CicloJuego() {
        long tiempoInicial = System.nanoTime();
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long tiempoActual) {
                double t = (tiempoActual - tiempoInicial)/1000000000.0;
                t2 = (int) t;
                int tConta = (int) t;
                Actualizar(t);
                salir(animationTimer);
                Pintar();
                if(contador < 5)
                    PintarPresentacion(tConta, t);
                System.out.println(t);
            }
        };
        animationTimer.start();
    }
    
    public void PintarPresentacion(int tConta, double t) {
        if(contador == tConta)
            contador += 1;
        String PersonajeN = "";
        String EnemigoN = "";
        if("tony/multijuego/resources/goku.png".equals(listaPersonaje.get(i))) {
            PersonajeN = "Goku";
            EnemigoN = "Vegeta";
        } else if("tony/multijuego/resources/Vegeta.png".equals(listaPersonaje.get(i))) {
            PersonajeN = "Vegeta";
            EnemigoN = "Goku";
        }
        graficos.drawImage(imagenes.get(PersonajeN), -50+10*t, stage.getHeight() - (stage.getHeight()*0.9), stage.getWidth()*0.6, stage.getHeight()*0.8);
        graficos.drawImage(imagenes.get(EnemigoN), stage.getWidth()-400 - 10*t, stage.getHeight() - (stage.getHeight()*0.9), stage.getWidth()*0.6, stage.getHeight()*0.8);
        
        graficos.drawImage(imagenes.get("VS"), stage.getWidth() - ((stage.getWidth()/2) + t*25), stage.getHeight() - ((stage.getHeight()/2)+ t*25), 50*t, 50*t);
    }
    
    public void Pintar() {
       //graficos.drawImage(imagenes.get("TileMap"), CXImagen, CYImagen, ancho, alto, CXPintar, CYPintar, anchoP, altoP);
        fondo.pintar(graficos);
        for(Tile tiles : tile) {
            if (tiles != null)
                tiles.pintar(graficos);
        }
         //if(contador > 4) {
            p1.pintar(graficos);
            e1.pintar(graficos);
            item.pintar(graficos);
            item2.pintar(graficos);
            item3.pintar(graficos);
            if (!ataque.isEmpty()) {
                for(AtaqueAnimado ataques : ataque) {
                    ataques.pintar(graficos);
                }
            }
            
            graficos.fillText("Vida JUGADOR ", 5, 15);
            p1.pintarBarraVida(graficos, 5, 25);
            p1.pintarBarraKi(graficos, 5, 65);
            graficos.fillText("Vida PC ", (int) (stage.getWidth()-270), 15);
            e1.pintarBarraVida(graficos, (int) (stage.getWidth()-270), 25);
            e1.pintarBarraKi(graficos, (int) (stage.getWidth()-270), 65);
         //}
            
        //graficos.fillText("Vidas C1: " + (int) item.getCantidadVidas(), 20, 20);
        //graficos.fillText("Vidas C2: " + (int) item2.getCantidadVidas(), 20, 40);
        //graficos.fillText("Vidas C3: " + (int) item3.getCantidadVidas(), 20, 60);
    }
    
    public void Actualizar(double t) {
        if (!ataque.isEmpty()) {
            boolean bandera1 = true;
            for(int i1 = 0; i1<ataque.size() && bandera1; i1++) {
                if (!ataque.get(i1).isVivo() && bandera1) {// Da un error
                    ataque.remove(i1);
                    bandera = false;
                }
            }
        }
        
        p1.VerificarColisionesItem(item);
        p1.VerificarColisionesItem(item2);
        p1.VerificarColisionesItem(item3);
        p1.VerificarColisionesEne(e1);
    if (!ataque.isEmpty()) {
            for(AtaqueAnimado ataques : ataque)
                ataques.VerificarColisionesEne(e1);
        }
    
        p1.calcularFrame(t, PersonajeN);
        e1.calcularFrame(t);
        if (!ataque.isEmpty()) {
            for(AtaqueAnimado ataques : ataque)
                ataques.calcularFrame();
        }
        
        p1.mover();
        if (!ataque.isEmpty()) {
            for(AtaqueAnimado ataques : ataque)
                ataques.mover();
        }
        fondo.mover();
    }

    public String revisarEvento() {
        if (arriba == true)
            return "CorrerArriba";
        else if (abajo == true)
            return "CorrerAbajo";
        else if (izquierda == true)
            return "CorrerD";
        else if (derecha == true)
            return "CorrerD";
        //else if (Atacando == true)
            //return "Ataque1";
        else 
            return "Descanso";
    }
    
    public static boolean revisarEventos() {
        if (arriba == true)
            return true;
        else if (abajo == true)
            return true;
        else if (izquierda == true)
            return true;
        else if (derecha == true)
            return true;
        else if (derecha == true)
            return true;
        else 
            return false;
    }
    
    public void GestionEventos() {
        escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent evento) {
                switch(evento.getCode().toString()) {
                    case "RIGHT":
                        derecha = true;
                        p1.setAnimacionActual("CorrerD");
                        direcc = 1;
                        p1.setDireccion(direcc);
                        
                        break;
                    case "LEFT":
                        izquierda = true;
                        p1.setAnimacionActual("CorrerD");
                        direcc = -1;
                        p1.setDireccion(direcc);
                        
                        break;
                    case "UP":
                        arriba = true;
                        p1.setAnimacionActual("CorrerArriba");
                        break;
                    case "DOWN":
                        abajo = true;
                        p1.setAnimacionActual("CorrerAbajo");
                        break;
                    case "SPACE":
                        if(p1.getKi()>0) {
                            if(!Atacando) {
                                Atacando = true;
                                p1.setAnimacionActual("Ataque1");
                                p1.setT2(100);
                                p1.setMenosKi(25);
                                AtaqueAnimado ataques = new AtaqueAnimado(200, 50, p1.getX()+40, p1.getY()-15, "GokuSST", 3);
                                ataques.inicializarAnimaciones();
                                ataques.setDireccion(direcc);
                                ataque.add(ataques);
                                mediaplayer.stop();
                                getSonido("KamehamehaCorto");
                            }
                        }
                        break;
                    case "X":
                        if(!Atacando) {
                            Atacando = true;
                            p1.setAnimacionActual("Ataque2");
                            p1.setMoverX(direcc*5);
                            if(p1.VerificarColisionesEnemigo(e1))
                                getSonido("GolpeSimple");
                            else
                                getSonido("GolpeSimple1");
                        }
                        break;
                    case "Z":
                        if(!Atacando) {
                            Atacando = true;
                            p1.setAnimacionActual("Ataque3");
                            p1.setMoverX(direcc*9);
                            if(p1.VerificarColisionesEnemigo(e1))
                                getSonido("PatadaSimple");
                            else
                                getSonido("PatadaSimple1");
                        }
                        break;
                    case "A":
                        if(p1.getKi()>0) {
                            getSonido("Tele");
                            p1.setAnimacionActual("Esquivar");
                            p1.setMenosKi(10);
                            if(arriba && 0 < p1.getY() - 75)
                                p1.setMoverY(-75);
                            if(abajo && stage.getHeight()-100> p1.getY() + 75)
                                p1.setMoverY(75);

                            if(stage.getWidth()-50< p1.getX() + 75 && p1.getDireccion() == 1) {
                                p1.setX((int) stage.getWidth()-50);
                            } else if ( 0 > p1.getX() - 75 && p1.getDireccion() == -1){
                                p1.setX(5);
                            }else {
                                p1.setMoverX(p1.getDireccion()*75);
                            }
                        }
                        break;
                    case "C":
                        if(p1.getKi()<100) {
                            p1.setAnimacionActual("CargarKi");
                            if (t3<= t2) {
                                t3=t2+1;
                                p1.setMasKi(5);
                            }
                            if(banderaSonido == true) {
                                getSonidoRepetir("CargarKi");
                                banderaSonido = false;
                            }
                        }
                        break;
                    case "S":
                        InicioViewController.mediaFondo.play();
                        mediaJuego.stop();
                        salir = true;
                        break;
                }
            }
        });

        escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent evento) {
                switch(evento.getCode().toString()) {
                    case "RIGHT":
                        derecha = false;
                        p1.setAnimacionActual(revisarEvento());
                        break;
                    case "LEFT":
                        izquierda = false;
                        p1.setAnimacionActual(revisarEvento());
                        break;
                    case "UP":
                        arriba = false;
                        p1.setAnimacionActual(revisarEvento());
                        break;
                    case "DOWN":
                        abajo = false;
                        p1.setAnimacionActual(revisarEvento());
                        break; 
                    case "SPACE":
                        Atacando = false;
                        p1.setAnimacionActual(revisarEvento());
                        break;
                    case "X":
                        Atacando = false;
                        p1.setAnimacionActual(revisarEvento());
                        break;
                    case "Z":
                        Atacando = false;
                        p1.setAnimacionActual(revisarEvento());
                        break;
                    case "A":
                        p1.setAnimacionActual(revisarEvento());
                        break;
                    case "C":
                        mediaplayer.pause();
                        getSonido("CargarKiDetener");
                        p1.setAnimacionActual("Descanso");
                        banderaSonido = true;
                        break;
                }
            }
        });
        
        /*escena.setOnMousePressed((t) -> {
            Atacando = true;
        });
        escena.setOnMouseReleased((t) -> {
            Ataque ataque = new Ataque(jugador.getX() + 50, jugador.getY() + 15);
            listaAtaques.add(ataque);
            Atacando = false;
        });*/
    }

    @FXML
    private void onActionBtnIzquierda(ActionEvent event) {
        i-=1;
        if(i<0){
            i=listaPersonajes.size()-1;
        }
        imgPersonaje.setImage(listaPersonajes.get(i));
        getSonido("Radar");
    }

    @FXML
    private void onActionBtnDerecha(ActionEvent event) {
        i+=1;
        if(i>listaPersonajes.size()-1){
            i=0;
        }
        imgPersonaje.setImage(listaPersonajes.get(i));
        getSonido("Radar");
    }

    @FXML
    private void onActionBtnSalir(ActionEvent event) {
        getSonido("Sonido");
        FlowController.getInstance().goViewInWindow("InicioView");
        getStage().close();
    }

    @FXML
    private void onActionBtnJugar(ActionEvent event) {
        InicioViewController.mediaFondo.stop();
        getSonido("Sonido");
        IniciarJuego();
    }
}
