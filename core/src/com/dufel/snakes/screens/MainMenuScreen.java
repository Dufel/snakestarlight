package com.dufel.snakes.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dufel.snakes.util.Config;
import com.dufel.snakes.util.Constants;

public class MainMenuScreen extends ScreenAdapter {

    Config o_config;
    Game o_game;
    Stage o_stage;
    SpriteBatch o_batch;
    Viewport o_viewport;

    public MainMenuScreen( Game vo_game ) {
        
        o_game = vo_game;
        o_config = new Config();
        o_config.DELTA = Constants.DELTA_EASY;

        o_batch = new SpriteBatch();
        o_viewport = new FitViewport( Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, new OrthographicCamera() );
        o_viewport.apply();

        o_stage = new Stage( o_viewport, o_batch );
    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor( o_stage );

        Table o_table = new Table();
        o_table.setDebug( true, true );
        o_table.setSize( Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT / 4 );
        o_table.setPosition( 0, Constants.WORLD_HEIGHT / 4 );

        BitmapFont o_font = new BitmapFont();

        FreeTypeFontGenerator.setMaxTextureSize( FreeTypeFontGenerator.NO_MAXIMUM );
        FreeTypeFontGenerator o_gen = new FreeTypeFontGenerator( Gdx.files.internal( "corbelb.ttf" ) );
        FreeTypeFontGenerator.FreeTypeFontParameter o_param = new FreeTypeFontGenerator.FreeTypeFontParameter();
        o_param.size = 16;
        o_param.color = Color.WHITE;
        o_font = o_gen.generateFont( o_param );
        o_font.setUseIntegerPositions( false );        
        o_font.getRegion().getTexture().setFilter( Texture.TextureFilter.Linear, Texture.TextureFilter.Linear );
        //o_font.getData().setScale( 1f / Constants.WORLD_HEIGHT );

        Label.LabelStyle o_style = new Label.LabelStyle( o_font, Color.WHITE );
        Label o_score_label = new Label( "score: 0", o_style );
        o_score_label.setFontScale( 1f / Constants.WORLD_HEIGHT );

        TextButton.TextButtonStyle o_button_style = new TextButton.TextButtonStyle();
        o_button_style.font = o_font;

        TextButton o_button = new TextButton( "Start", o_button_style );
        o_button.getLabel().setFontScale( 1f / Constants.WORLD_HEIGHT );
        o_button.addListener( new ClickListener() {
            @Override
            public void clicked( InputEvent event, float x, float y ) {
                o_game.setScreen( new GameScreen( o_game, o_config ) );
            }
        } );

        o_table.add( o_score_label ).left().top().expandX();
        o_table.add( o_button ).right().bottom().expandX();

        o_stage.addActor( o_table );
    }

    @Override
    public void render( float delta ) {

        Gdx.gl.glClearColor(.1f, .12f, .16f, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        o_stage.act();
        o_stage.draw();
    }

    @Override
    public void resize( int width, int height ) {
        super.resize( width, height );
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
