/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeGame.modules;

import com.mygdx.game.GamePanel;

/**
 *
 * @author Anna
 */
public interface Module {
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_FAILURE = 1;

    public void load(GamePanel gp,Module batch);
    public int run();
    public void unload();
}
