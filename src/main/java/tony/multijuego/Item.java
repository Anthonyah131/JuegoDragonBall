/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tony.multijuego;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import tony.multijuego.controller.InicioViewController;
import tony.multijuego.controller.SeleccionarPersonajeViewController;

/**
 *
 * @author ANTHONY
 */
public class Item extends ObjetoJuego{
    private double cantidadVidas;
    private boolean capturado = false;

    public Item(int cantidadVidas, int x, int y, String nombreImagen, int velocidad, int ancho, int alto) {
        super(x, y, nombreImagen, velocidad, ancho, alto);
        this.cantidadVidas = cantidadVidas;
        this.ancho = (int) SeleccionarPersonajeViewController.imagenes.get("Cell").getWidth();
        this.alto = (int) SeleccionarPersonajeViewController.imagenes.get("Cell").getHeight();
    }

    public double getCantidadVidas() {
        return cantidadVidas;
    }

    public void setCantidadVidas(double cantidadVidas) {
        //this.cantidadVidas = cantidadVidas;
        this.cantidadVidas -= cantidadVidas;
    }

    public boolean isCapturado() {
        return capturado;
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }
    
    public Rectangle ObtenerRectangulo() {
        return new Rectangle(x, y, ancho, alto);
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        if(!this.capturado) {
            graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get("Cell"), this.x, this.y);
            graficos.setFill(Color.RED);
            graficos.strokeRect(x, y, ancho, alto);
        }
    }

    @Override
    public void mover() {
    }
    
}
