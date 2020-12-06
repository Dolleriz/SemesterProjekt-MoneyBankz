package worldofzuul;


import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprites{
        private Image image;
        private double positionX;
        private double positionY;
        private double velocityX;
        private double velocityY;
        private double width;
        private double height;

        public Sprites()
        {
            positionX = 0;
            positionY = 0;
            velocityX = 0;
            velocityY = 0;
        }

        public void setImage(Image i)
        {
            image = i;
            width = i.getWidth();
            height = i.getHeight();
        }

        public void setImageString(String filename)
        {
            Image i = new Image(filename,25,25,true,false);
            setImage(i);

        }

        public void setPosition(double x, double y)
        {
            positionX = x;
            positionY = y;
        }

        public void setVelocity(double x, double y)
        {
            velocityX = x;
            velocityY = y;
        }

        public void addVelocity(double x, double y)
        {
            velocityX += x;
            velocityY += y;
        }

        public void update(double time)
        {
            positionX += velocityX * time;
            positionY += velocityY * time;
        }

        public void render(GraphicsContext gc)
        {
            gc.drawImage( image, positionX, positionY );
        }

        public Rectangle2D getFigure()
        {
            return new Rectangle2D(positionX,positionY,width,height);
        }

        public boolean intersects(Sprites s)
        {
            return s.getFigure().intersects( this.getFigure() );
        }

        public String toString()
        {
            return " Position: [" + positionX + "," + positionY + "]"
                    + " Velocity: [" + velocityX + "," + velocityY + "]";
        }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public Image getImage() {
        return image;
    }
}