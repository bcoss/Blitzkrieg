package org.Blitzkrieg.State;

import java.util.ArrayList;
import java.util.List;

import org.Blitzkrieg.Entity.DirectionBlock;
import org.Blitzkrieg.Entity.Vehicle;
import org.Blitzkrieg.Entity.block;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {
	protected List<Vehicle> cars;
	private List<block> blocks;
	protected List<DirectionBlock> DirectionBlocks;
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		cars = new ArrayList<Vehicle>();
		blocks = new ArrayList<block>();
		DirectionBlocks = new ArrayList<DirectionBlock>();
		// TODO Auto-generated method stub

	}

	
	
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		return 0;
	}

	public List<block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<block> blocks) {
		this.blocks = blocks;
	}

	public List<DirectionBlock> getDirectionBlocks() {
		return DirectionBlocks;
	}
}