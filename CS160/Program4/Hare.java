/** Hare class
*   inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Hare extends Racer
{
   /** Default Constructor: calls Racer default constructor
   */
   public Hare( )
   {
     super( );
   }

   /** Constructor
   *    @param rID   racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Hare( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
   }

   /** move:  calculates the new x position for the racer
   *   Hare move characteristics:  30% of the time, Hare jumps 5 pixels
   *                               70% of the time, Hare sleeps (no move)
   *   generates random number between 1 & 10
   *          for 1 - 7,  no change to x position
   *          for 8 - 10, x position is incremented by 5
   */
   public void move( )
   {
      Random rand = new Random( );
     int move =  rand.nextInt( 10 ) + 1 ;

     if ( getX( ) < 100 )
     {
      if ( move > 6 )
       setX( getX( ) + 4 );
     }
     else
     {
      if ( move > 8 )
       setX( getX( ) + 4 );
     }
   }

   /** draw: draws the Hare at current (x, y) coordinate
   *   @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startY = getY( );
     int startX = getX( );

    if (this.isWinner){
      morph(g);
    }

     // tail
     g.setColor( Color.LIGHT_GRAY );
     g.fillOval( startX - 37, startY + 8,  12, 12 ) ;

     //body
     g.setColor( Color.GRAY );
     g.fillOval( startX - 30, startY,  20,  20 );

     //head
     g.fillOval( startX - 13, startY + 2, 13, 8 );
     g.fillOval( startX - 13, startY - 8, 8, 28 );

     //flatten bottom
     g.clearRect( startX - 37, startY + 15, 32, 5 );
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
