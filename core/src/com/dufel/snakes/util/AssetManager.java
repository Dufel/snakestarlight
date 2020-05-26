package com.dufel.snakes.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {

    public static final AssetManager o_manager = new AssetManager();

    public final ScreenManager o_screen;
    public final SnakeManager o_snake;    

    TextureAtlas o_atlas;
    
    public AssetManager() {
        
        o_screen = new ScreenManager();
        o_snake = new SnakeManager();
        
        TextureRegion o_reg = o_atlas.findRegion( "" );        
        
    }
    
    public class ScreenManager {
        
        public final Texture o_tile_a;
        public final Texture o_tile_b;
        
        public ScreenManager() {
            
            o_tile_a = new Texture( "tile_a.png" );
            o_tile_b = new Texture( "tile_b.png" );
        }
    }
    
    public class SnakeManager {
        
        public final Texture o_snake_head_right;
        public final Texture o_snake_head_left;
        public final Texture o_snake_head_up;
        public final Texture o_snake_head_down;
        
        public final Texture o_snake_tail_right;
        public final Texture o_snake_tail_left;
        public final Texture o_snake_tail_up;
        public final Texture o_snake_tail_down;
        
        public final Texture o_snake_body_horizontal;
        public final Texture o_snake_body_vertical;
        
        public final Texture o_snake_body_top_left;
        public final Texture o_snake_body_top_right;
        public final Texture o_snake_body_bottom_left;
        public final Texture o_snake_body_bottom_right;
        
        public SnakeManager() {
         
            o_snake_head_right = o_atlas.findRegion( "snake_head_r" ).getTexture();
            o_snake_head_left = o_atlas.findRegion( "snake_head_l" ).getTexture();
            o_snake_head_up = o_atlas.findRegion( "snake_head_u" ).getTexture();
            o_snake_head_down = o_atlas.findRegion( "snake_head_d" ).getTexture();
            
            o_snake_tail_right = o_atlas.findRegion( "snake_tail_r" ).getTexture();
            o_snake_tail_left = o_atlas.findRegion( "snake_tail_l" ).getTexture();
            o_snake_tail_up = o_atlas.findRegion( "snake_tail_u" ).getTexture();
            o_snake_tail_down = o_atlas.findRegion( "snake_tail_d" ).getTexture();
            
            o_snake_body_horizontal = o_atlas.findRegion( "snake_body_h" ).getTexture();
            o_snake_body_vertical = o_atlas.findRegion( "snake_body_v" ).getTexture();
            
            o_snake_body_top_left = o_atlas.findRegion( "snake_body_top_left" ).getTexture();
            o_snake_body_top_right = o_atlas.findRegion( "snake_body_top_right" ).getTexture();
            o_snake_body_bottom_left = o_atlas.findRegion( "snake_body_bottom_left" ).getTexture();
            o_snake_body_bottom_right = o_atlas.findRegion( "snake_body_bottom_right" ).getTexture();
            
        }
    }

}
