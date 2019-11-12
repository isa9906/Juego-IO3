/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegokinestesico;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Isabel
 */
public class Figura extends JButton implements ActionListener{
    private int xSolPos, ySolPos;
    private int xPos, yPos;
    private int dimension;
    public Figura(int xSolPos, int ySolPos, ImageIcon subimage, int dimension){
        this.xSolPos=xSolPos;
        this.ySolPos=ySolPos;
        this.dimension=dimension;
        
        xPos=xSolPos;
        yPos=ySolPos;
        
        this.setIcon(subimage);
        this.setPreferredSize(new Dimension(subimage.getIconWidth(), subimage.getIconHeight()));
        this.addActionListener(this);
    }

    public int getxSolPos() {
        return xSolPos;
    }

    public void setxSolPos(int xSolPos) {
        this.xSolPos = xSolPos;
    }

    public int getySolPos() {
        return ySolPos;
    }

    public void setySolPos(int ySolPos) {
        this.ySolPos = ySolPos;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
    }
   private void move(){
       Celda [][] tablero=Tablero.tablero;
       try{
            if (tablero[xPos][yPos-1].getFigura()==null){//arriba
                Tablero.tablero[xPos][yPos-1].setFigura(this);
                Tablero.tablero[xPos][yPos].setFigura(null);
                yPos--;  
                JuegoKinestesico.tablero.remover();
                comprobarRespuesta();
                return;
            }
       }catch(ArrayIndexOutOfBoundsException e){
           System.err.println("Error arriba");       
        }
        try{
            if (tablero[xPos][yPos+1].getFigura()==null){//abajo
                Tablero.tablero[xPos][yPos+1].setFigura(this);
                Tablero.tablero[xPos][yPos].setFigura(null);
                yPos++;
                JuegoKinestesico.tablero.remover();
                comprobarRespuesta();
                return;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error abajo");   
        }
        try{
            if (tablero[xPos+1][yPos].getFigura()==null){//derecha
                Tablero.tablero[xPos+1][yPos].setFigura(this);
                Tablero.tablero[xPos][yPos].setFigura(null);
                 xPos++;  
                 JuegoKinestesico.tablero.remover();
                 comprobarRespuesta();
                return;
            }  
        }catch(ArrayIndexOutOfBoundsException e){
                System.err.println("Error derecha");   
        }
       try{
            if (tablero[xPos-1][yPos].getFigura()==null){//izquierda
                 Tablero.tablero[xPos-1][yPos].setFigura(this);
                 Tablero.tablero[xPos][yPos].setFigura(null);
                 xPos--;
                 JuegoKinestesico.tablero.remover();
                 comprobarRespuesta();
        return;  
             }
        }catch(ArrayIndexOutOfBoundsException e){
            
        }
        
      
   }
   
   private void comprobarRespuesta(){
       Figura figura=null;
       for (int i=0; i<dimension;i++){
           for (int j=0; j<dimension;j++){
               figura=Tablero.tablero[i][j].getFigura();
               if(figura==null){
                   continue;
               }
               if(figura.getxPos()!=figura.getxSolPos()|| 
                       figura.getyPos()!= figura.getySolPos()){
                   return;
               }
           }
       }
       //completado
       JOptionPane.showMessageDialog(new JPanel(), "Felicidades","Rompecabezas terminado",JOptionPane.INFORMATION_MESSAGE);
   }
}
