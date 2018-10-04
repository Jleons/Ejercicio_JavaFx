


import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;
import modelo.Carro;

/**
 *
 * @author Estudiante
 */
public class LoopJuego extends AnimationTimer{
    private GraphicsContext lapiz;
    private Carro carro;
    private Image fondo1;
    private Image gato;
    private int secuencia;
    private Image fondo2;
    private Image colision1;
    
    
    
    
    public LoopJuego(GraphicsContext lapiz) {
        this.lapiz = lapiz;
        this.fondo1=new Image("image/fondo.png");
        this.fondo2=new Image("image/fondo.png");
        this.colision1=new Image("image/left0.png");
        this.gato= new Image ("image/cats.gif");
        this.carro = new Carro(0, 100, 20, 20);
    }
    
    int point = 0;
    int posfondo=1024;
    @Override
    public void handle(long now) {
         //Carro
        lapiz.clearRect(0, 0, 1024, 512);
        
        lapiz.drawImage(this.fondo1, this.posfondo-1024, 0);
        lapiz.drawImage(this.fondo2, this.posfondo, 0);
        lapiz.drawImage(this.colision1, 900, 370);
        if(this.secuencia==5)
            this.secuencia=0;
        else
            this.secuencia++;
        
        lapiz.drawImage(this.gato,  132*this.secuencia, 0, 132, 80, 20, 350, 132, 80);
         
        
        lapiz.strokeRect(this.carro.getXref(), this.carro.getYref(), this.carro.getAncho(), this.carro.getAlto());
        lapiz.strokeRect(300,100,50,50);
        
        
        lapiz.strokeText("Puntaje: " + point , 950, 10);
        if (this.posfondo<=0)
            this.posfondo=1024;
        else
            this.posfondo-=5;
        
        
        
         Shape rRectangulo1=
                new Rectangle(this.carro.getXref(),100,20,20);
        Shape rRectangulo2=
                new Rectangle(300,100,50,50);
        Shape interseccion= SVGPath.intersect(rRectangulo1, rRectangulo2);
        
        if (interseccion.getBoundsInLocal().getWidth()==1){
        point+=1;
        }
        this.carro.mover();
    }
}
