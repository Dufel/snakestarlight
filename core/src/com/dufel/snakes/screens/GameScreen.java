package com.dufel.snakes.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dufel.snakes.util.Constants;
import com.dufel.snakes.util.Direction;
import com.dufel.snakes.util.GridManager;

public class GameScreen extends ScreenAdapter {

    Game o_game;
    Viewport o_viewport;
    GridManager o_grid;
    SpriteBatch o_batch;

    long l_start_time;
    Direction o_direction;
    
    int n_score;
    
    public GameScreen( Game vo_game ) {
        o_game = vo_game;
        n_score = 3;
    }

    @Override
    public void show() {

        o_batch = new SpriteBatch();
        o_grid = new GridManager();
        o_viewport = new FitViewport( Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, new OrthographicCamera() );

        l_start_time = TimeUtils.nanoTime();
        o_direction = Direction.RIGHT;
        
        Gdx.input.setInputProcessor( new InputAdapter() { 
        
            @Override
            public boolean keyDown( int keycode ) {

                switch ( keycode ) {

                    case Input.Keys.LEFT :
                    case Input.Keys.A :
                        
                        if ( o_grid.getCurrentDirection() != Direction.RIGHT ) {
                            o_direction = Direction.LEFT;
                        }
                        break;

                    case Input.Keys.RIGHT :
                    case Input.Keys.D :
                        
                        if ( o_grid.getCurrentDirection() != Direction.LEFT ) {
                            o_direction = Direction.RIGHT;
                        }
                        break;

                    case Input.Keys.DOWN :
                    case Input.Keys.S :
                        
                        if ( o_grid.getCurrentDirection() != Direction.UP ) {
                            o_direction = Direction.DOWN;
                        }
                        break;

                    case Input.Keys.UP :
                    case Input.Keys.W :
                        
                        if ( o_grid.getCurrentDirection() != Direction.DOWN ) {
                            o_direction = Direction.UP;
                        }
                        break;
                }
                return true;
            }
        });
        
    }

    @Override
    public void resize( int width, int height ) {
        o_viewport.update( width, height, true );
    }

    public void update( float delta ) {

        o_viewport.getCamera().update();
        // Need to determine when this method is called at a certain interval,
        // so as to call underlying updates / render at discrete steps
        long l_elapsed_time = TimeUtils.timeSinceNanos( l_start_time );
        if ( MathUtils.nanoToSec * l_elapsed_time >= Constants.DELTA_FRAME ) {
            
            // Do a discreet update                                    
            o_grid.update( o_direction );
            n_score = o_grid.o_snake.o_cells.size;
            l_start_time = TimeUtils.nanoTime();

            if ( o_grid.checkForGameOver() ) {
                System.out.println( "Game Over!" );
                o_game.setScreen( new GameOverScreen( o_game ) );
            }
        }
        
    }

    @Override
    public void render( float delta ) {

        Gdx.gl.glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        o_batch.setProjectionMatrix( o_viewport.getCamera().combined );
        o_viewport.apply();

        o_batch.begin();
        o_grid.render( o_batch );
        o_batch.end();

        update( delta );
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
    
}
