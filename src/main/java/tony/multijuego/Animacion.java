/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tony.multijuego;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import tony.multijuego.controller.SeleccionarPersonajeViewController;

/**
 *
 * @author ANTHONY
 */
public class Animacion {
    private double duracion;
    private Rectangle coordenadas[];


    public Animacion(double duracion, Rectangle coordenadas[]) {
        this.duracion = duracion;
        this.coordenadas = coordenadas;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Rectangle[] getCoordenadas() {
        return coordenadas;
    }
    
    public Rectangle getCoordenadas(int i) {
        return coordenadas[i];
    }

    public void setCoordenadas(Rectangle[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int calcularIndiceActual(double t) {
        int cantidadFrames = this.coordenadas.length;
        int indiceFrameActual = (int) (t%(cantidadFrames*duracion)/duracion);
        return indiceFrameActual;
    }
    public Rectangle calcularFrameActual(double t) {
        int cantidadFrames = this.coordenadas.length;
        int indiceFrameActual = (int) (t%(cantidadFrames*duracion)/duracion);
        return coordenadas[indiceFrameActual];
    }
    public Rectangle calcularFrameActual(double vidaM, double vida) {
        if (vida >= vidaM-40)
            return coordenadas[0];
        if (vida >= vidaM-60)
            return coordenadas[1];
        else if (vida >= vidaM-100)
            return coordenadas[2];
        else if (vida >= vidaM-140)
            return coordenadas[3];
        else if (vida > 0)
            return coordenadas[4];
        return coordenadas[4];
    }
    public Rectangle calcularFrameActualVida(double vidaM, double vida) {
        if (vida == vidaM)
            return coordenadas[0];
        if (vida >= vidaM*0.8)
            return coordenadas[1];
        else if (vida >= vidaM*0.6)
            return coordenadas[2];
        else if (vida >= vidaM*0.4)
            return coordenadas[3];
        else if (vida > 0)
            return coordenadas[4];
        else if (vida <= 0)
            return coordenadas[5];
        return coordenadas[5];
    }
    
    public Rectangle calcularFrameActualGokuBase(double t2M, double t2) {
        if (t2 >= t2M-20)
            return coordenadas[0];
        if (t2 >= t2M-40)
            return coordenadas[1];
        else if (t2 >= t2M-60)
            return coordenadas[2];
        else if (t2 > 0)
            return coordenadas[3];
        return coordenadas[3];
    }
    public Rectangle calcularFrameActualVeguetaBase(double t2M, double t2) {
        if (t2 >= t2M-40)
            return coordenadas[0];
        if (t2 >= t2M-60)
            return coordenadas[1];
        else if (t2 > 0)
            return coordenadas[2];
        return coordenadas[2];
    }
    
}
