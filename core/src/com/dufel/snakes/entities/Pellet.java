package com.dufel.snakes.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Queue;
import com.dufel.snakes.util.AssetManager;
import java.util.Iterator;
import java.util.Random;

public class Pellet {

    public Cell o_cell;
    public Random o_rand;
    public Array<Cell> o_choices;
    
    
    public Pellet() {
        o_cell = new Cell( 2, 5 );
        o_rand = new Random();
        o_choices = new Array<>( 30 );
    }

    public void update( Array<Cell> vo_grid, Queue<Cell> vo_snake ) {
        
        o_choices = new Array<>();
        for ( Cell o_cell : vo_grid ) {
            o_choices.add( new Cell( o_cell.n_col, o_cell.n_row ) );
        }
        
        Iterator<Cell> o_it = vo_snake.iterator();
        while ( o_it.hasNext() ) {
            
            o_choices.removeValue( o_it.next(), false );
        }
        
        o_cell = o_choices.random();
        
        o_choices.clear();
    }

    public void render( SpriteBatch vo_batch ) {
        o_cell.render( vo_batch, AssetManager.o_manager.o_screen.o_pellet );
    }
}
