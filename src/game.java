import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;
public class game extends BasicGame
{

	private TiledMap map;
	public game()
	{
		super("Goodbye");
	}

	@Override
	public void init(GameContainer gc) throws SlickException
	{
		gc.setShowFPS(false); 
		map = new TiledMap("res/maps/test.tmx");
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException
	{

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		map.render(0, 0);
	}

	public static void main(String[] args) throws SlickException
	{
		AppGameContainer app = new AppGameContainer(new game());

		app.setDisplayMode(800, 600, false);
		app.start();
	}
}