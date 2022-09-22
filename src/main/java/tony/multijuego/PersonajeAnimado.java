/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tony.multijuego;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tony.multijuego.controller.InicioViewController;
import tony.multijuego.controller.SeleccionarPersonajeViewController;
import static tony.multijuego.controller.SeleccionarPersonajeViewController.stage;

/**
 *
 * @author ANTHONY
 */
public class PersonajeAnimado extends ObjetoJuego{
    private double vidaM;
    private double vida;
    private double ki;
    private double kiM;
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;
    private int direccion = 1;
    private String animacionActual;
    private double t2 = 0;
    private double t2M = 0;
    
    private HashMap<String, Animacion> animaciones;

    public PersonajeAnimado(double vida, double ki, int x, int y, String nombreImagen, int velocidad, String animacionActual) {
        super(x, y, nombreImagen, velocidad, x, y);
        this.vida = vida;
        this.vidaM = vida;
        this.ki = ki;
        this.kiM = ki;
        this.animacionActual = animacionActual;
        animaciones = new HashMap<String, Animacion>();
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
    
    public void setMasKi(double ki) {
        this.ki += ki;
    }
    
    public int getxImagen() {
        return xImagen;
    }

    public void setxImagen(int xImagen) {
        this.xImagen = xImagen;
    }

    public int getyImagen() {
        return yImagen;
    }

    public void setyImagen(int yImagen) {
        this.yImagen = yImagen;
    }

    public int getAnchoImagen() {
        return anchoImagen;
    }

    public void setAnchoImagen(int anchoImagen) {
        this.anchoImagen = anchoImagen;
    }

    public int getAltoImagen() {
        return altoImagen;
    }

    public void setAltoImagen(int altoImagen) {
        this.altoImagen = altoImagen;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
    
    public String getAnimacionActual() {
        return animacionActual;
    }

    public void setAnimacionActual(String animacionActual) {
        this.animacionActual = animacionActual;
    }

    public double getT2() {
        return t2;
    }

    public void setT2(double t2) {
        this.t2 = t2;
        this.t2M = t2;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }
    
    public void setMoverX(int x) {
        this.x += x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
    
    public void setMoverY(int y) {
        this.y += y;
    }

    @Override
    public String getNombreImagen() {
        return nombreImagen;
    }

    @Override
    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public void inicializarAnimaciones(String Personaje) {
        Rectangle coordenadasBarraVida[] = {
            /*new Rectangle(105, 60, 85, 620),
            new Rectangle(105, 180, 85, 620),
            new Rectangle(105, 310, 85, 620),
            new Rectangle(105, 440, 85, 620),
            new Rectangle(105, 570, 85, 620),
            new Rectangle(105, 685, 85, 620),*/
            new Rectangle(90, 285, 75, 620),
            new Rectangle(90, 165, 75, 620),
        };
        Rectangle coordenadasBarraKi[] = {
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
                new Rectangle(350, 150, 45, 35),
                new Rectangle(400, 150, 45, 35),
                new Rectangle(450, 150, 45, 35),
                //new Rectangle(450, 150, 45, 35),
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
                new Rectangle(48, 76, 51, 26),
                //new Rectangle(5, 75, 50, 35)
            };
            Rectangle coordenadasCorrerAbajo[] = {
                //new Rectangle(5, 75, 50, 35),
                //new Rectangle(100, 75, 55, 35),
                new Rectangle(150, 70, 50, 24),
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
                new Rectangle(400, 150, 45, 36),
                new Rectangle(450, 150, 48, 34)
                //new Rectangle(450, 150, 48, 34),
                //new Rectangle(450, 150, 48, 34),
            };
            Rectangle coordenadasAtaque2[] = {
                new Rectangle(5, 225, 44, 35),
                //new Rectangle(100, 225, 52, 42),
                new Rectangle(50, 221, 49, 37),
                //new Rectangle(100, 225, 52, 42),
            };
            Rectangle coordenadasAtaque3[] = {
                new Rectangle(150, 225, 49, 35),
                new Rectangle(200, 225, 42, 33),
                new Rectangle(250, 225, 41, 29),
                new Rectangle(300, 225, 47, 45),
                new Rectangle(350, 225, 47, 44),
            };
            Rectangle coordenadasEsquivar[] = {
                new Rectangle(500, 5, 38, 18),
                new Rectangle(550, 5, 51, 25),
                new Rectangle(600, 5, 51, 25),
            };
            Rectangle coordenadasCargarKi[] = {
                new Rectangle(400, 50, 72, 75),
                new Rectangle(500, 68, 72, 75),
                new Rectangle(600, 65, 72, 75),
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

            Animacion animacionAtaque2 = new Animacion(.2, coordenadasAtaque2);
            animaciones.put("Ataque2", animacionAtaque2);

            Animacion animacionAtaque3 = new Animacion(.1, coordenadasAtaque3);
            animaciones.put("Ataque3", animacionAtaque3);
            
            Animacion animacionEsquivar = new Animacion(.01, coordenadasEsquivar);
            animaciones.put("Esquivar", animacionEsquivar);
            
            Animacion animacionCargarKi = new Animacion(.07, coordenadasCargarKi);
            animaciones.put("CargarKi", animacionCargarKi);
        }
    }
    
    public void calcularFrame(double t, String personajeSelecc) {
        Rectangle coordenadas = null;
        if ("Ataque1".equals(animacionActual)) {
            if("GokuSST".equals(personajeSelecc)) {
                coordenadas = animaciones.get(animacionActual).calcularFrameActualGokuBase(t2M, t2);
                t2-=3;
            } else if("VegetaSST".equals(personajeSelecc)) {
                coordenadas = animaciones.get(animacionActual).calcularFrameActualVeguetaBase(t2M, t2);
                t2-=3;
            }
        } else
            coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
        this.xImagen = (int) coordenadas.getX();
        this.yImagen = (int) coordenadas.getY();
        this.altoImagen = (int) coordenadas.getWidth();
        this.anchoImagen = (int) coordenadas.getHeight();
    }
    
    public int calcularIndiceActual(double t) {
        return animaciones.get(animacionActual).calcularIndiceActual(t);
    }
    
    public Rectangle ObtenerRectangulo() {
        return new Rectangle(x, y, anchoImagen, altoImagen);
    }
    
    public void VerificarColisionesItem(Item item) {
        if(!item.isCapturado() && this.ObtenerRectangulo().getBoundsInLocal().intersects(item.ObtenerRectangulo().getBoundsInLocal())) {
            //this.vida += item.getCantidadVidas();
            //item.setCapturado(true);
            if (SeleccionarPersonajeViewController.Atacando) {
                if("Ataque2".equals(animacionActual))
                    item.setCantidadVidas(.09);
                if("Ataque3".equals(animacionActual))
                    item.setCantidadVidas(.09);
                //System.out.println("Atacando");
                //System.out.println(item.getCantidadVidas());
            }
                
        }
            //System.out.println("Estan colisionando");
    }
    
    public void VerificarColisionesEne(EnemigoAnimado enemigo) {
        if(enemigo.isVivo()&& this.ObtenerRectangulo().getBoundsInLocal().intersects(enemigo.ObtenerRectangulo().getBoundsInLocal())) {
            int mover = 0;
            if(enemigo.getVida()<=0)
                enemigo.setVivo(false);
            //System.out.println(enemigo.getVida());
            if (SeleccionarPersonajeViewController.Atacando) {
                enemigo.setAnimacionActual("ResiveDano");
                if("Ataque2".equals(animacionActual)) {
                    enemigo.menosVida(.5);
                    mover = 5;
                }   
                if("Ataque3".equals(animacionActual)) {
                    enemigo.menosVida(.5);
                    mover = 8;
                }
                
                if(SeleccionarPersonajeViewController.stage.getWidth()-50 < enemigo.getX() + mover && direccion == 1) {
                    enemigo.setX((int) stage.getWidth()-51);
                } else if ( 0 > enemigo.getX() - mover&& direccion == -1){
                    enemigo.setX(5);
                } else {
                    enemigo.setMenosX(direccion*mover);
                }
            }      
        } else {
            enemigo.setAnimacionActual("Descanso");
        }
    }
    
    public boolean VerificarColisionesEnemigo(EnemigoAnimado enemigo) {
        if(enemigo.isVivo()&& this.ObtenerRectangulo().getBoundsInLocal().intersects(enemigo.ObtenerRectangulo().getBoundsInLocal())) {
            if (SeleccionarPersonajeViewController.Atacando) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        if("CargarKi".equals(animacionActual))
            graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get(nombreImagen), xImagen, yImagen, anchoImagen, altoImagen, x + (direccion == -1?anchoImagen-20:-25), y-20, direccion*anchoImagen, altoImagen);
        else
            graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get(nombreImagen), xImagen, yImagen, anchoImagen, altoImagen, x + (direccion == -1?anchoImagen:0), y, direccion*anchoImagen, altoImagen);
        
        graficos.setStroke(Color.RED);
        
        if("CargarKi".equals(animacionActual))
            graficos.strokeRect(x + (direccion == -1?-20:-25), y-20, anchoImagen, altoImagen);
        else 
            graficos.strokeRect(x, y, anchoImagen, altoImagen);
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
        if (x>SeleccionarPersonajeViewController.stage.getWidth()-50)
            SeleccionarPersonajeViewController.derecha = false;
        if (x<0)
            SeleccionarPersonajeViewController.izquierda = false;
        if (y>SeleccionarPersonajeViewController.stage.getHeight()-100)
            SeleccionarPersonajeViewController.abajo = false;
        if (y<0)
            SeleccionarPersonajeViewController.arriba = false;
        
        if (SeleccionarPersonajeViewController.arriba)
            y -= velocidad;
        if (SeleccionarPersonajeViewController.abajo)
            y += velocidad;
        if (SeleccionarPersonajeViewController.derecha)
            x += velocidad;
        if (SeleccionarPersonajeViewController.izquierda)
            x -= velocidad;
    }
    
}
