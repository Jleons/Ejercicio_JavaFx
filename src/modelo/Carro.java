/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Estudiante
 */
public class Carro {
    private int xref;
    private int yref;
    private int ancho;
    private int alto;
    private Chasis chasis;
    private Llanta[] llantas;

    public Carro(int xref, int yref, int ancho, int alto) {
        this.xref = xref;
        this.yref = yref;
        this.ancho = ancho;
        this.alto = alto;
        //Chasis chasis;
        //Llantas
    }

    public int getXref() {
        return xref;
    }

    public int getYref() {
        return yref;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    
    public void mover(){
       this.xref++;
    }
    
}
