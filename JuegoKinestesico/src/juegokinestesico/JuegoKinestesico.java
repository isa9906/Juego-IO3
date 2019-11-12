
package juegokinestesico;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


/**
 *
 * @author Isabel
 */
public class JuegoKinestesico extends JFrame {

    public static Container contenedor;
    private BufferedImage img;
    public static Tablero tablero;
    public JuegoKinestesico(){
        this.setTitle("Rompecabezas");
        this.setSize(1517,838);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        contenedor=this.getContentPane();
        try {
            img = ImageIO.read(new File ("src/juegokinestesico/imagen.png"));
        } catch (IOException ex) {
            System.err.println("no se encuentra la imagen");
        }
        Image tmp = img.getScaledInstance(1500,800,Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(1500,800,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp,0,0,null);
        g2d.dispose();
        
        tablero = new Tablero (3,resized);
        contenedor.add(tablero);
        
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new JuegoKinestesico();
    }
    
}
