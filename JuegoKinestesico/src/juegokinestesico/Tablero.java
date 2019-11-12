/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegokinestesico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Isabel
 */
public class Tablero extends JPanel{
   public static Celda [][] tablero;
   private ArrayList <Celda> tablerocompleto= new ArrayList<Celda>();
   private int dimension;
   private int x,y;
   private int figAncho, figAlto;
  
      
   private JLabel vacio;
   public Tablero(int dimension, BufferedImage rompecabezas){
        this.dimension=dimension;
        tablero=new Celda [dimension][dimension];
        //this.setBackground(Color.BLACK);
        
        x=0;
        y=0;
        figAncho=rompecabezas.getWidth()/dimension;
        figAlto=rompecabezas.getHeight()/dimension;
        
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        for(int i=0; i<dimension;i++){
            for (int j=0;j<dimension;j++){
                if (i==dimension-1 && j==dimension-1){
                    continue;
                }
                tablerocompleto.add(new Celda(i,j,new Figura(i,j,new ImageIcon(rompecabezas.getSubimage(x, y, figAncho,figAlto)),dimension)));
                x+=figAncho;
            }
            x=0;
            y+=figAlto;     
        }
        desordenar();
        remover();
        
    }

   private void desordenar(){
       Random generador= new Random();
       ArrayList <Celda> copia= new ArrayList<Celda>(tablerocompleto);
       for(int i=0; i<dimension;i++){
            for (int j=0;j<dimension;j++){
                if (i==dimension-1 && j==dimension-1){
                    tablero[i][j]=new Celda(i,j);
                    continue;
                }
                int aleatorio=generador.nextInt(tablerocompleto.size());
                tablerocompleto.get(aleatorio).getFigura().setxPos(i);
                tablerocompleto.get(aleatorio).getFigura().setyPos(j);
                tablero[i][j]=new Celda (i,j,tablerocompleto.get(aleatorio).getFigura());
                tablerocompleto.remove(aleatorio);
            }       
        }
       tablerocompleto=copia;
       remover();
   }
   private void actualizar(){
       for(int i=0; i<dimension;i++){
            for (int j=0;j<dimension;j++){
                if(tablero[i][j].getFigura()==null){
                    vacio=new JLabel();
                    vacio.setPreferredSize(new Dimension(figAncho,figAlto));
                    this.add(vacio);
                    continue;
                }
                this.add(tablero[i][j].getFigura());               
            }
        }
       JuegoKinestesico.contenedor.validate();
   }
   public void remover(){
       this.removeAll();
       actualizar();
   }
}
