/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tony.multijuego;

import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tony.multijuego.controller.SeleccionarPersonajeViewController;

/**
 *
 * @author ANTHONY
 */
public class EnemigoAnimado extends ObjetoJuego{
    private double vida;
    private double vidaM;
    private double ki;
    private double kiM;
    private boolean vivo;
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;
    private int direccion;
    private String animacionActual;
    
    private HashMap<String, Animacion> animaciones;

    public EnemigoAnimado(double vida, double ki, int x, int y, String nombreImagen, int velocidad, String animacionActual, int direccion) {
        super(x, y, nombreImagen, velocidad, x, y);
        this.vida = vida;
        this.ki = ki;
        this.kiM = ki;
        this.vidaM = vida;
        this.vivo = true;
        this.direccion = direccion;
        this.animacionActual = animacionActual;
        animaciones = new HashMap<String, Animacion>();
    }
    
    public void setMenosX(double x) {
        this.x += x;
    }
    

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }
    
    public void menosVida(double vida) {
        this.vida -= vida;
    }

    public double getKi() {
        return ki;
    }

    public void setKi(double ki) {
        this.ki = ki;
    }
    
    public void setMenosKi(double ki) {
        this.ki -= ki;
    }
    
    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getAnimacionActual() {
        return animacionActual;
    }

    public void setAnimacionActual(String animacionActual) {
        this.animacionActual = animacionActual;
    }
    
    public void inicializarAnimaciones(String Personaje) {
         Rectangle coordenadasBarraVida[] = {
            /*new Rectangle(105, 60, 85, 620),
            new Rectangle(105, 180, 85, 620),
            new Rectangle(105, 310, 85, 620),
            new Rectangle(105, 440, 85, 620),
            new Rectangle(105, 570, 85, 620),
            new Rectangle(105, 685, 85, 620),*/
            new Rectangle(85, 30, 90, 630),
            new Rectangle(90, 165, 85, 620),
        }; Rectangle coordenadasBarraKi[] = {
            /*new Rectangle(105, 60, 85, 620),
            new Rectangle(105, 180, 85, 620),
            new Rectangle(105, 310, 85, 620),
            new Rectangle(105, 440, 85, 620),
            new Rectangle(105, 570, 85, 620),
            new Rectangle(105, 685, 85, 620),*/
            new Rectangle(90, 285, 75, 620),
            new Rectangle(90, 385, 75, 620),
        };
        Animacion animacionBarraVida = new Animacion(.01, coordenadasBarraVida);
        animaciones.put("BarraVida", animacionBarraVida);
        Animacion animacionBarraKi = new Animacion(.01, coordenadasBarraKi);
        animaciones.put("BarraKi", animacionBarraKi);
        
        if("GokuSST".equals(Personaje)) {
            Rectangle coordenadasCorrerD[] = {
           // new Rectangle(200, 75, 45, 50),
            //new Rectangle(250, 75, 45, 45),
            new Rectangle(300, 85, 30, 55)
            };
            Rectangle coordenadasDescanso[] = {
                new Rectangle(5, 150, 45, 35),
                //new Rectangle(100, 7, 50, 40)
            };
            Rectangle coordenadasCorrerArriba[] = {
                //new Rectangle(5, 75, 50, 35),
                new Rectangle(50, 75, 55, 35),
                //new Rectangle(5, 75, 50, 35)
            };
            Rectangle coordenadasCorrerAbajo[] = {
                //new Rectangle(5, 75, 50, 35),
                //new Rectangle(100, 75, 55, 35),
                new Rectangle(150, 75, 60, 30),
                //new Rectangle(5, 75, 50, 35)
            };
            Rectangle coordenadasAtaque1[] = {
                //new Rectangle(5, 150, 50, 35),
                //new Rectangle(50, 154, 43, 32),
                //new Rectangle(98, 154, 45, 35),
                //new Rectangle(150, 153, 43, 33),
                //new Rectangle(200, 150, 46, 30),
                //new Rectangle(250, 150, 45, 35),
                new Rectangle(300, 150, 45, 35),
                //new Rectangle(350, 150, 45, 35),
                new Rectangle(400, 150, 45, 35),
                new Rectangle(450, 150, 45, 35),
                new Rectangle(450, 150, 45, 35),
            };
            Rectangle coordenadasAtaque2[] = {
                new Rectangle(5, 225, 45, 35),
                new Rectangle(100, 225, 49, 35),
                new Rectangle(50, 221, 50, 41),
                new Rectangle(100, 225, 49, 35),
            };
            Rectangle coordenadasAtaque3[] = {
                new Rectangle(150, 225, 51, 32),
                new Rectangle(195, 225, 48, 45),
                new Rectangle(250, 225, 45, 32),
                new Rectangle(300, 225, 48, 45),
                new Rectangle(350, 225, 48, 46),
            };
            
            Rectangle coordenadasEsquivar[] = {
                new Rectangle(500, 5, 51, 25),
                new Rectangle(550, 5, 47, 21),
                new Rectangle(600, 5, 51, 27),
                new Rectangle(300, 5, 40, 27),
            };
            Rectangle coordenadasCargarKi[] = {
                new Rectangle(400, 50, 72, 75),
                new Rectangle(500, 68, 72, 75),
                new Rectangle(600, 65, 72, 75),
            };
            
            Rectangle coordenadasResiveDano[] = {
                new Rectangle(5, 500, 41, 31),
                new Rectangle(150, 500, 47, 26),
                new Rectangle(50, 500, 49, 30),
                new Rectangle(100, 500, 45, 37),
                new Rectangle(200, 500, 46, 42),
            };

            Animacion animacionCorrerD = new Animacion(.3, coordenadasCorrerD);
            animaciones.put("CorrerD", animacionCorrerD);

            Animacion animacionDescanso = new Animacion(.3, coordenadasDescanso);
            animaciones.put("Descanso", animacionDescanso);

            Animacion animacionCorrerArriba = new Animacion(.3, coordenadasCorrerArriba);
            animaciones.put("CorrerArriba", animacionCorrerArriba);

            Animacion animacionCorrerAbajo = new Animacion(.3, coordenadasCorrerAbajo);
            animaciones.put("CorrerAbajo", animacionCorrerAbajo);

            Animacion animacionAtaque1 = new Animacion(.2, coordenadasAtaque1);
            animaciones.put("Ataque1", animacionAtaque1);

            Animacion animacionAtaque2 = new Animacion(.1, coordenadasAtaque2);
            animaciones.put("Ataque2", animacionAtaque2);

            Animacion animacionAtaque3 = new Animacion(.1, coordenadasAtaque3);
            animaciones.put("Ataque3", animacionAtaque3);
            
            Animacion animacionEsquivar = new Animacion(.01, coordenadasEsquivar);
            animaciones.put("Esquivar", animacionEsquivar);
            
            Animacion animacionCargarKi = new Animacion(.07, coordenadasCargarKi);
            animaciones.put("CargarKi", animacionCargarKi);
            
            Animacion animacionResiveDano = new Animacion(.5, coordenadasResiveDano);
            animaciones.put("ResiveDano", animacionResiveDano);
            
        } else if("VegetaSST".equals(Personaje)) {
            Rectangle coordenadasCorrerD[] = {
           // new Rectangle(200, 75, 45, 50),
            //new Rectangle(250, 75, 45, 45),
            new Rectangle(300, 85, 46, 35)
            };
            Rectangle coordenadasDescanso[] = {
                new Rectangle(5, 150, 53, 33),
                //new Rectangle(100, 7, 50, 40)
            };
            Rectangle coordenadasCorrerArriba[] = {
                //new Rectangle(5, 75, 50, 35),
                new Rectangle(50, 75, 55, 35),
                //new Rectangle(5, 75, 50, 35)
            };
            Rectangle coordenadasCorrerAbajo[] = {
                //new Rectangle(5, 75, 50, 35),
                //new Rectangle(100, 75, 55, 35),
                new Rectangle(150, 75, 60, 30),
                //new Rectangle(5, 75, 50, 35)
            };
            Rectangle coordenadasAtaque1[] = {
                //new Rectangle(5, 150, 50, 35),
                //new Rectangle(50, 154, 43, 32),
                //new Rectangle(98, 154, 45, 35),
                //new Rectangle(150, 153, 43, 33),
                //new Rectangle(200, 150, 46, 30),
                //new Rectangle(250, 150, 45, 35),
                new Rectangle(300, 150, 44, 27),
                //new Rectangle(350, 150, 45, 35),
                new Rectangle(400, 150, 46, 36),
                new Rectangle(450, 150, 48, 34),
                new Rectangle(450, 150, 48, 34),
            };
            Rectangle coordenadasAtaque2[] = {
                new Rectangle(5, 225, 44, 35),
                new Rectangle(100, 225, 52, 42),
                new Rectangle(50, 221, 49, 37),
                new Rectangle(100, 225, 52, 42),
            };
            Rectangle coordenadasAtaque3[] = {
                new Rectangle(150, 225, 49, 35),
                new Rectangle(195, 225, 42, 33),
                new Rectangle(250, 225, 41, 29),
                new Rectangle(300, 225, 47, 45),
                new Rectangle(350, 225, 47, 44),
            };
            
            Rectangle coordenadasEsquivar[] = {
                new Rectangle(500, 5, 51, 25),
                new Rectangle(550, 5, 47, 21),
                new Rectangle(600, 5, 51, 27),
                new Rectangle(300, 5, 40, 27),
            };
            Rectangle coordenadasCargarKi[] = {
                new Rectangle(400, 50, 72, 75),
                new Rectangle(500, 68, 72, 75),
                new Rectangle(600, 65, 72, 75),
            };
            
            Rectangle coordenadasResiveDano[] = {
                new Rectangle(5, 500, 41, 31),
                new Rectangle(150, 500, 47, 26),
                new Rectangle(50, 500, 49, 30),
                new Rectangle(100, 500, 45, 37),
                new Rectangle(200, 500, 46, 42),
            };

            Animacion animacionCorrerD = new Animacion(.3, coordenadasCorrerD);
            animaciones.put("CorrerD", animacionCorrerD);

            Animacion animacionDescanso = new Animacion(.3, coordenadasDescanso);
            animaciones.put("Descanso", animacionDescanso);

            Animacion animacionCorrerArriba = new Animacion(.3, coordenadasCorrerArriba);
            animaciones.put("CorrerArriba", animacionCorrerArriba);

            Animacion animacionCorrerAbajo = new Animacion(.3, coordenadasCorrerAbajo);
            animaciones.put("CorrerAbajo", animacionCorrerAbajo);

            Animacion animacionAtaque1 = new Animacion(.2, coordenadasAtaque1);
            animaciones.put("Ataque1", animacionAtaque1);

            Animacion animacionAtaque2 = new Animacion(.1, coordenadasAtaque2);
            animaciones.put("Ataque2", animacionAtaque2);

            Animacion animacionAtaque3 = new Animacion(.1, coordenadasAtaque3);
            animaciones.put("Ataque3", animacionAtaque3);
            
            Animacion animacionEsquivar = new Animacion(.01, coordenadasEsquivar);
            animaciones.put("Esquivar", animacionEsquivar);
            
            Animacion animacionCargarKi = new Animacion(.07, coordenadasCargarKi);
            animaciones.put("CargarKi", animacionCargarKi);
            
            Animacion animacionResiveDano = new Animacion(.5, coordenadasResiveDano);
            animaciones.put("ResiveDano", animacionResiveDano);
        }
    }
    
     public void calcularFrame(double t) {
        Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
        this.xImagen = (int) coordenadas.getX();
        this.yImagen = (int) coordenadas.getY();
        this.altoImagen = (int) coordenadas.getWidth();
        this.anchoImagen = (int) coordenadas.getHeight();
    }
    
    public Rectangle ObtenerRectangulo() {
        return new Rectangle(x, y, anchoImagen, altoImagen);
    }
    
    public void VerificarColisionesPer(PersonajeAnimado personaje) {
        if(this.ObtenerRectangulo().getBoundsInLocal().intersects(personaje.ObtenerRectangulo().getBoundsInLocal())) {
            //this.vida += item.getCantidadVidas();
            //item.setCapturado(true);
            if (SeleccionarPersonajeViewController.Atacando) {
                if("Ataque2".equals(animacionActual))
                    personaje.menosVida(.09);
                if("Ataque3".equals(animacionActual))
                    personaje.menosVida(.09);
                //System.out.println("Atacando");
                //System.out.println(item.getCantidadVidas());
            }
                
        }
            //System.out.println("Estan colisionando");
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        if(this.vivo) {
            graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get(nombreImagen), xImagen, yImagen, anchoImagen, altoImagen, x + (direccion == -1?anchoImagen:0), y, direccion*anchoImagen, altoImagen);
            graficos.setStroke(Color.RED);
            graficos.strokeRect(x, y, anchoImagen, altoImagen);
        }
    }
    
    public void pintarBarraVida(GraphicsContext graficos, int xB, int yB) {
        Rectangle coordenadas;
        //coordenadas = animaciones.get("BarraVida").calcularFrameActualVida(vidaM, vida);
        double n = vida/vidaM;
        if(n<0)
            n=0;
        coordenadas = animaciones.get("BarraVida").getCoordenadas(1);
        graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get("BarraVidaPoder"), coordenadas.getX(), coordenadas.getY(), coordenadas.getHeight(), coordenadas.getWidth(), xB, yB, 250*n, 50);

        coordenadas = animaciones.get("BarraVida").getCoordenadas(0);
        graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get("BarraVidaPoder"), coordenadas.getX(), coordenadas.getY(), coordenadas.getHeight(), coordenadas.getWidth(), xB, yB, 250, 50);
    }
    
    public void pintarBarraKi(GraphicsContext graficos, int xB, int yB) {
        Rectangle coordenadas;
        //coordenadas = animaciones.get("BarraVida").calcularFrameActualVida(vidaM, vida);
        double n = ki/kiM;
        if(n<0)
            n=0;
        coordenadas = animaciones.get("BarraKi").getCoordenadas(1);
        graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get("BarraVidaPoder"), coordenadas.getX(), coordenadas.getY(), coordenadas.getHeight(), coordenadas.getWidth(), xB, yB, 250*n, 50);

        coordenadas = animaciones.get("BarraKi").getCoordenadas(0);
        graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get("BarraVidaPoder"), coordenadas.getX(), coordenadas.getY(), coordenadas.getHeight(), coordenadas.getWidth(), xB, yB, 250, 50);
    }

    @Override
    public void mover() {
    }
    
    
    
}
