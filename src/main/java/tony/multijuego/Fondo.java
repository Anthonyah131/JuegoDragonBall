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
public class Fondo extends ObjetoJuego {
    
    int x2;
    int ancho;
    int alto;

    public Fondo(int x, int y, String nombreImagen, int velocidad) {
        super(x, y, nombreImagen, velocidad, 0, 0);
        this.ancho = (int) SeleccionarPersonajeViewController.imagenes.get(nombreImagen).getWidth();
        this.x2 = this.ancho + this.x;
        this.alto = (int) SeleccionarPersonajeViewController.imagenes.get(nombreImagen).getHeight();
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get(nombreImagen), x, y);
        graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get(nombreImagen+"2"), x2, y);
    }

    @Override
    public void mover() {
        if (x <= -1 * ancho) {
            x = ancho;
        }
        if (x2 <= -1 * ancho) {
            x2 = ancho;
        }

        x -= velocidad;
        x2 -= velocidad;
    }
    
}
