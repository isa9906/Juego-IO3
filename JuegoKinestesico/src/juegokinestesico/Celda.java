/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegokinestesico;

/**
 *
 * @author Isabel
 */
public class Celda {
    private int x,y;
    private Figura figura;
    public Celda(int x, int y, Figura figura){
        this.x=x;
        this.y=y;
        this.figura=figura;
    }
    public Celda(int x, int y){
        this.x=x;
        this.y=y;
        this.figura=null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }
    
}
