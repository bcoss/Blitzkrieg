package org.Blitzkrieg.Entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

public class Entity{
	protected Shape shape;
	protected String name;
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
	}
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
	}
	public void update(GameContainer gc, StateBasedGame game, int g)
			throws SlickException {
		// TODO Auto-generated method stub

	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
}
