package com.dufel.snakes.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.audio.Sound;

public class AssetManager {

    public static final AssetManager o_manager = new AssetManager();

    public final ScreenManager o_screen;
    public final SnakeManager o_snake;    

    TextureAtlas o_atlas;
    
    public AssetManager() {

        o_atlas = new TextureAtlas( "snake.atlas" );
        o_screen = new ScreenManager();
        o_snake = new SnakeManager();
    }

    public class ScreenManager {
        
        public final TextureRegion o_tile_a;
        public final TextureRegion o_tile_b;
        public final TextureRegion o_pellet;
        
        public ScreenManager() {
            
            o_tile_a = o_atlas.findRegion( "tile_a" );
            o_tile_b = o_atlas.findRegion( "tile_b" );
            o_pellet = o_atlas.findRegion( "pellet" );
        }
    }
    
    public class SoundManager {
        
        public final Sound o_consume;
        public final Music o_theme;
        
        public SoundManager() {
            
            o_consume = Gdx.audio.newSound( Gdx.files.internal( "consume.wav" ) );
            o_theme = Gdx.audio.newMusic( Gdx.files.internal( "theme.mp3" ) );
        }
    }
    
    public class SnakeManager {
        
        public final TextureRegion o_snake_head_right;
        public final TextureRegion o_snake_head_left;
        public final TextureRegion o_snake_head_up;
        public final TextureRegion o_snake_head_down;
        
        public final TextureRegion o_snake_tail_right;
        public final TextureRegion o_snake_tail_left;
        public final TextureRegion o_snake_tail_up;
        public final TextureRegion o_snake_tail_down;
        
        public final TextureRegion o_snake_body_horizontal;
        public final TextureRegion o_snake_body_vertical;
        
        public final TextureRegion o_snake_body_top_left;
        public final TextureRegion o_snake_body_top_right;
        public final TextureRegion o_snake_body_bottom_left;
        public final TextureRegion o_snake_body_bottom_right;
        
        public SnakeManager() {
         
            o_snake_head_right = o_atlas.findRegion( "snake_head_r" );
            o_snake_head_left = o_atlas.findRegion( "snake_head_l" );
            o_snake_head_up = o_atlas.findRegion( "snake_head_u" );
            o_snake_head_down = o_atlas.findRegion( "snake_head_d" );
            
            o_snake_tail_right = o_atlas.findRegion( "snake_tail_r" );
            o_snake_tail_left = o_atlas.findRegion( "snake_tail_l" );
            o_snake_tail_up = o_atlas.findRegion( "snake_tail_u" );
            o_snake_tail_down = o_atlas.findRegion( "snake_tail_d" );
            
            o_snake_body_horizontal = o_atlas.findRegion( "snake_body_h" );
            o_snake_body_vertical = o_atlas.findRegion( "snake_body_v" );
            
            o_snake_body_top_left = o_atlas.findRegion( "snake_body_top_left" );
            o_snake_body_top_right = o_atlas.findRegion( "snake_body_top_right" );
            o_snake_body_bottom_left = o_atlas.findRegion( "snake_body_bottom_left" );
            o_snake_body_bottom_right = o_atlas.findRegion( "snake_body_bottom_right" );
        }
    }

}
