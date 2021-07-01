package com.dufel.snakes.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dufel.snakes.util.Config;
import com.dufel.snakes.util.Constants;
import com.dufel.snakes.util.Direction;
import com.dufel.snakes.util.GridManager;

public class GameScreen extends ScreenAdapter {

    Config o_config;
    Game o_game;
    Viewport o_viewport;
    GridManager o_grid;
    SpriteBatch o_batch;

    ShapeRenderer o_renderer;
    BitmapFont o_font;

    long l_start_time;
    Direction o_direction;
    
    int n_score;
    boolean b_pause;

    public GameScreen( Game vo_game, Config vo_config ) {
        
        o_config = vo_config;
        o_game = vo_game;
        n_score = 3;
        b_pause = false;
    }

    @Override
    public void show() {

        o_batch = new SpriteBatch();
        o_grid = new GridManager();
        o_viewport = new FitViewport( Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, new OrthographicCamera() );

        l_start_time = TimeUtils.nanoTime();
        o_direction = Direction.RIGHT;
        o_renderer = new ShapeRenderer();              
        
        FreeTypeFontGenerator.setMaxTextureSize( FreeTypeFontGenerator.NO_MAXIMUM );
        FreeTypeFontGenerator o_gen = new FreeTypeFontGenerator( Gdx.files.internal( "corbelb.ttf" ) );
        FreeTypeFontGenerator.FreeTypeFontParameter o_param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        o_param.size = 16;
        o_param.color = Color.WHITE;
        o_param.shadowColor = Color.BLACK;
        o_font = o_gen.generateFont( o_param );
        o_font.setUseIntegerPositions( false );
        o_font.getRegion().getTexture().setFilter( Texture.TextureFilter.Linear, Texture.TextureFilter.Linear );
        
        Gdx.input.setInputProcessor( new InputAdapter() { 
        
            @Override
            public boolean keyDown( int keycode ) {

                switch ( keycode ) {

                    case Input.Keys.SPACE :
                        b_pause = !b_pause;
                        break;

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
        if ( MathUtils.nanoToSec * l_elapsed_time >= o_config.DELTA ) {
            
            // Do a discreet update                                    
            o_grid.update( o_direction );
            n_score = o_grid.o_snake.o_cells.size;
            l_start_time = TimeUtils.nanoTime();

            if ( o_grid.checkForGameOver() ) {

                o_game.setScreen( new GameOverScreen( o_game ) );
            }
        }
        
    }

    @Override
    public void render( float delta ) {

        if ( !b_pause ) {

            update( delta );
        }                
        
        Gdx.gl.glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        o_batch.setProjectionMatrix( o_viewport.getCamera().combined );
        o_viewport.apply();

        o_batch.begin();

        o_grid.render( o_batch );

        if ( b_pause ) {

            o_batch.end();
            
            o_renderer.setProjectionMatrix( o_viewport.getCamera().combined );
            o_viewport.apply();

            Gdx.graphics.getGL20().glEnable( GL20.GL_BLEND );
            Gdx.gl.glBlendFunc( GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA );
            o_renderer.begin( ShapeRenderer.ShapeType.Filled );

            o_renderer.setColor( new Color( 0, 0, 0, 0.2f ) );
            o_renderer.rect(0, 0, Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT );

            o_renderer.end();
            Gdx.gl.glDisable( GL20.GL_BLEND );

            o_batch.begin();
            Matrix4 o_orig_matrix = o_batch.getProjectionMatrix().cpy();
            o_batch.setProjectionMatrix( o_orig_matrix.cpy().scale( Constants.WORLD_WIDTH / Gdx.graphics.getWidth(), Constants.WORLD_HEIGHT / Gdx.graphics.getHeight(), 1 ) );

            o_font.draw( o_batch, "PAUSED", Constants.WORLD_WIDTH / 4, Constants.WORLD_HEIGHT / 2, Constants.WORLD_WIDTH / 2, 1, false );
            o_batch.setProjectionMatrix( o_orig_matrix );
        }

        o_batch.end();
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
