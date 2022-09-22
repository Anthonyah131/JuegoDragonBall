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
import static tony.multijuego.controller.SeleccionarPersonajeViewController.abajo;
import static tony.multijuego.controller.SeleccionarPersonajeViewController.arriba;
import static tony.multijuego.controller.SeleccionarPersonajeViewController.stage;

/**
 *
 * @author ANTHONY
 */
public class AtaqueAnimado extends ObjetoJuego{
    private double vida;
    private double vidaM;
    private double dano;
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;
    private int direccion = 1;
    private boolean vivo;
    private String animacionActual;
    
    private HashMap<String, Animacion> animaciones;

    public AtaqueAnimado(double vida, double dano, int x, int y, String nombreImagen, int velocidad) {
        super(x, y, nombreImagen, velocidad, x, y);
        this.vida = vida;
        this.vidaM = vida;
        this.dano = dano;
        this.vivo = true;
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

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
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
    
    public void inicializarAnimaciones() {
        Rectangle coordenadasAtaque[] = {
            new Rectangle(300, 400, 76, 159),
            new Rectangle(500, 300, 76, 184),
            new Rectangle(5, 300, 81, 210),
            new Rectangle(250, 300, 81, 235),
            new Rectangle(5, 400, 81, 262),
        };

        Animacion animacionAtaque = new Animacion(.2, coordenadasAtaque);
        animaciones.put("Ataque", animacionAtaque);
    }
    
    public void calcularFrame() {
       Rectangle coordenadas = animaciones.get("Ataque").calcularFrameActual(vidaM, vida);;
       this.xImagen = (int) coordenadas.getX();
       this.yImagen = (int) coordenadas.getY();
       this.altoImagen = (int) coordenadas.getWidth();
       this.anchoImagen = (int) coordenadas.getHeight();
    }
    
    public Rectangle ObtenerRectangulo() {
        return new Rectangle(x - (direccion == -1?anchoImagen+40:0), y, anchoImagen, altoImagen);
    }
    
    public void VerificarColisionesEne(EnemigoAnimado enemigo) {
        if(vivo && enemigo.isVivo()&& this.ObtenerRectangulo().getBoundsInLocal().intersects(enemigo.ObtenerRectangulo().getBoundsInLocal())) {
            enemigo.menosVida(10);
            vida = 0;
            vivo = false;

            if(SeleccionarPersonajeViewController.stage.getWidth()-50 < enemigo.getX() + 35 && direccion == 1) {
                enemigo.setX((int) stage.getWidth()-51);
            } else if ( 0 > enemigo.getX() - 35 && direccion == -1){
                enemigo.setX(5);
            }else {
                enemigo.setMenosX(direccion*35);
            }
            
            if(enemigo.getVida()<=0)
                enemigo.setVivo(false);
        }  
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        if (vivo) {
            graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get(nombreImagen), xImagen, yImagen, anchoImagen, altoImagen, x - (direccion == -1?40:0), y, direccion*anchoImagen, altoImagen);
            graficos.setStroke(Color.RED);
            graficos.strokeRect(x - (direccion == -1?anchoImagen+40:0), y, anchoImagen, altoImagen);
        }
    }

    @Override
    public void mover() {
        if (vida > 0) {
            vida-= velocidad;
        }
        else {
            vivo = false;
        }
    }
}
