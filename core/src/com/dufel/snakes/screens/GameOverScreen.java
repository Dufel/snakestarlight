package com.dufel.snakes.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dufel.snakes.util.Constants;

/**
 * The display shown when the snake hits a wall or their own body.
 */
public class GameOverScreen extends ScreenAdapter {
    
    OrthographicCamera o_camera;
    Game o_game;
    Viewport o_viewport;
    SpriteBatch o_batch;
    Stage io_stage;
    
    public GameOverScreen( Game vo_game ) {
        o_game = vo_game;
    }

    @Override
    public void show() {
        
        o_batch = new SpriteBatch();
        o_camera = new OrthographicCamera();
        o_viewport = new FitViewport( Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, o_camera );

        o_viewport.apply( true );

        io_stage = new Stage( o_viewport, o_batch );

        TextButton.TextButtonStyle o_style = new TextButton.TextButtonStyle();
        o_style.font = new BitmapFont();
        o_style.font.getData().scale( 20f / Constants.WORLD_WIDTH );
        TextButton o_button = new TextButton( "R to Restart", o_style );
        o_button.setSize( Constants.WORLD_WIDTH / 20f, Constants.WORLD_HEIGHT / 20f );

        io_stage.addActor( o_button );
        
        Gdx.input.setInputProcessor( new InputAdapter() { 
        
            @Override
            public boolean keyDown( int keycode ) {

                switch ( keycode ) {

                    case Input.Keys.R :
                        o_game.setScreen( new MainMenuScreen( o_game ) );
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

    @Override
    public void render( float delta ) {

        super.render( delta );
        io_stage.draw();
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
