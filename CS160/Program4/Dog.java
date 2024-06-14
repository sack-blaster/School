/**  Dog class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Dog extends Racer
{
    private int speed;
    private Random rand;

   /** Default Constructor: calls Racer default constructor
   */
   public Dog( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Dog( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     setRandAndSpeed();
   }

   /** move:  calculates the new x position for the racer
   *   Dog move characteristics:  50% of the time, Dog moves 2 pixels
   *                             50% of the time, Dog moves 3 pixels
   */
   public void move( )
   {
     int move =  rand.nextInt( 100 )  + 1;
     if ( move < speed )
     {
       if (move < 50)
       {
         setX( getX( ) + 2 );
       }
       else
       {
         setX( getX( ) + 3 );
       }
     }
   }

   /** draw: draws the Dog at current (x, y) coordinate
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startX = getX( );
     int startY = getY( );
     
     	g.setColor( new Color( 139, 69, 19 ) ); // brown
      if (this.isWinner){
        morph(g);
      }
     //body
     g.fillOval( startX - 30, startY, 25, 15 );

     //head
     g.fillOval( startX - 10, startY + 5,  15, 10 );

     //flatten bottom
     g.setColor( new Color( 0, 0, 0 ) ); // black
     g.fillOval( startX - 30, startY + 10, 25, 5 );

     //legs
     g.setColor( new Color( 139, 69, 19 ) ); // brown
     g.fillOval( startX - 30, startY + 15, 5, 10 );
     g.fillOval( startX - 10, startY + 15, 5, 10 );
    }

    private void setRandAndSpeed( ) {
        rand = new Random( );
        speed = 50;
    }

    public void morph( Graphics g ){
      // move the hare up and down 10 times
      for (int i = 0; i < 10; i++){
        // move the hare up
        setY(getY() - 5);
        draw(g);
        // pause for 100 milliseconds
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        // move the hare down
        setY(getY() + 5);
        draw(g);
        // pause for 100 milliseconds
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }    
    } 
}