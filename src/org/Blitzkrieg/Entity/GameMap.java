package org.Blitzkrieg.Entity;

import java.util.List;

import org.Blitzkrieg.State.GameState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class GameMap {
	private TiledMap map;
	private StateBasedGame game;
	public GameMap(String location) throws SlickException{
		map = new TiledMap(location);
	}
	public void init(GameContainer gc, StateBasedGame game){
		this.game = game;
		BlockFinder(((GameState)game.getCurrentState()).getBlocks(), ((GameState)game.getCurrentState()).getDirectionBlocks());
	}
	
	public int getWidth(){
		return map.getWidth()*8;
	}
	public int getHeight(){
		return map.getHeight()*8;
	}
	
	private void BlockFinder(List<block> blocks, List<DirectionBlock> DirectionBlocks) {
		for(int i =0; i<map.getLayerCount(); i++){
			for(int j =0; j<map.getWidth(); j++){
				for(int k =0; k<map.getHeight(); k++){
					if(Boolean.parseBoolean(map.getTileProperty(map.getTileId(j, k, i), "move", "false"))) {
                        DirectionBlocks.add(new DirectionBlock(new Rectangle(j * map.getTileWidth(), k * map.getTileHeight(), 
                        		map.getTileWidth(), map.getTileHeight()), map.getTileProperty(map.getTileId(j, k, i), "direction", "null")));
                    }
					else if (Boolean.parseBoolean(map.getTileProperty(map.getTileId(j, k, i), "solid", "false"))) {
                        blocks.add(new block(new Rectangle(j * map.getTileWidth(), k * map.getTileHeight(), 
                                8, 8)));
                    }
					else if (Boolean.parseBoolean(map.getTileProperty(map.getTileId(j, k, i), "start", "false"))) {
						((GameState)game.getCurrentState()).setStart(new Rectangle(j * map.getTileWidth(), k * map.getTileHeight(),  map.getTileWidth(), map.getTileHeight()));
					}
				}
			}
		}
	}
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		map.render(0, 0);
	}

	public void update(GameContainer gc, StateBasedGame game, int g)
			throws SlickException {
	}
	
	public TiledMap getMap() {
		return map;
	}

	public void setMap(TiledMap map) {
		this.map = map;
	}
}
