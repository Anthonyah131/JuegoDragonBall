/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tony.multijuego;

import javafx.scene.canvas.GraphicsContext;
import tony.multijuego.controller.InicioViewController;
import tony.multijuego.controller.SeleccionarPersonajeViewController;

/**
 *
 * @author ANTHONY
 */
public class Personaje extends ObjetoJuego{
    
    int vida;

    public Personaje(int x, int y, String nombreImagen, int velocidad, int vida) {
        super(x, y, nombreImagen, velocidad, 0, 0);
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
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
    
    

    @Override
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get(nombreImagen), x, y);
    }

    @Override
    public void mover() {
        if (x>650)
            SeleccionarPersonajeViewController.derecha = false;
        if (x<0)
            SeleccionarPersonajeViewController.izquierda = false;
        if (y>450)
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
