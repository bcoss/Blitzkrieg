import org.newdawn.slick.*;
public class game extends BasicGame
{
 
  public game()
  {
     super("Goodbye");
  }
 
  @Override
  public void init(GameContainer gc) throws SlickException
  {
	  gc.setShowFPS(false); 
  }
 
  @Override
  public void update(GameContainer gc, int delta) throws SlickException
  {
 
  }
 
  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException
  {
  }
 
  public static void main(String[] args) throws SlickException
  {
     AppGameContainer app = new AppGameContainer(new game());
 
     app.setDisplayMode(800, 600, false);
     app.start();
  }
}