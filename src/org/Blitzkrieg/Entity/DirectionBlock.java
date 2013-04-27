package org.Blitzkrieg.Entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class DirectionBlock extends block{

	private String direction;
	public DirectionBlock(Shape shape, String direction) {
		super(shape);
		this.direction = direction;
		name = "direction";
		System.out.println(direction);
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		//g.setColor(Color.red);
		//g.draw(new Rectangle(shape.getCenterX(), shape.getCenterY(), 1, 1));
	}
	
}
