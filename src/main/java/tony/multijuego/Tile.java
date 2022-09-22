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
public class Tile extends ObjetoJuego{
    int xImagen;
    int yImagen;
    int tipoTile;

    public Tile(String nombreImagen, int tipoTile, int x, int y, int xImagen, int yImagen, int alto, int ancho, int velocidad) {
        super(x, y, nombreImagen, velocidad, ancho, alto);
        this.xImagen = xImagen;
        this.yImagen = yImagen;
        switch (tipoTile){
            case 1:
                this.xImagen = 0;
                this.yImagen = 0;
                break;
            case 2:
                this.xImagen = 0;
                this.yImagen = 70;
                break;
            case 3:
                this.xImagen = 0;
                this.yImagen = 140;
                break;
            case 4:
                this.xImagen = 0;
                this.yImagen = 210;
                break;    
            case 5:
                this.xImagen = 490;
                this.yImagen = 560;
                break;    
            case 6:
                this.xImagen = 560;
                this.yImagen = 560;
                break;    
            case 7:
                this.xImagen = 80;
                this.yImagen = 350;
                break;    
        }
    }
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    public int getxImagen() {
        return xImagen;
    }

    public void setxImagen(int xImagen) {
        this.xImagen = xImagen;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public int getyImagen() {
        return yImagen;
    }

    public void setyImagen(int yImagen) {
        this.yImagen = yImagen;
    }

    @Override
    public int getAlto() {
        return alto;
    }

    @Override
    public void setAlto(int alto) {
        this.alto = alto;
    }

    @Override
    public int getAncho() {
        return ancho;
    }

    @Override
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getTipoTile() {
        return tipoTile;
    }

    public void setTipoTile(int tipoTile) {
        this.tipoTile = tipoTile;
    }
    
    @Override
    public void pintar(GraphicsContext graficos) {
        graficos.drawImage(SeleccionarPersonajeViewController.imagenes.get(nombreImagen), xImagen, yImagen, ancho, alto, x, y, ancho, alto);
    }

    @Override
    public void mover() {
    }
    
}
