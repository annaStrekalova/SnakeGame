/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import java.util.EventObject;
import snakeGame.model.events.SnakeActionListener;
import snakeGame.modules.Module;
import snakeGame.modules.ModuleEngine;

/**
 *
 * @author Анна
 */
public class GamePanel implements Screen{
    
    private SnakeGame game;
    private GameModel _model;
    BitmapFont score;
    int currentScore = 1;
    
    public GamePanel(SnakeGame game) {
        this.game = game;
        this._model = new GameModel(game);
        this._model.start();
        _model.field().getSnake().addActionListener(new GamePanel.SnakeListener());
    }
    
    public GameModel model(){
        return _model;
    }
    
    public Module mg;
        public void setModule(Module module){
        this.mg = module;
    }
    
    /*Отрисовка поля*/
    private void drawField() {
        score = new BitmapFont();
        score.setColor(Color.WHITE);
        _model.field().getSprite().setPosition(0, 0);
        _model.field().getSprite().draw(game.batch);
        score.draw(game.batch, "Score: " + currentScore, 565, 50);
    }
    
    /*Отрисовка змеи*/
    private void drawSnake() {
        for (int i = 0; i < _model.field().getSnake().snakeParts.size; i++) {
            _model.field().getSnake().snakeParts.get(i).draw(game.batch);
        }
    }
    
    /*Отрисовка игровых объектов*/
    private void drawGameObjects(){
        for(GameObject obj : _model.field().getObjects()){
            if(obj.timeBeforeRender == 0)
                obj.objectSprite.draw(game.batch);
            else
                _model.countdownToRenderObject(obj);
        }
    }
    
    /*Нажатие клавишь*/
    private void keyPressed() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
           _model.field().getSnake().moveDirection = 2;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
           _model.field().getSnake().moveDirection = 3;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
           _model.field().getSnake().moveDirection = 0;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
           _model.field().getSnake().moveDirection = 1;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.F5)){
            String[] arr = new String[1];
            arr[0] = "C:\\SnakeGameMod\\SnakeGame\\core\\build\\classes\\main\\com\\mygdx\\game\\";
            ModuleEngine.main(arr, this);
        }
    }
    
    private class SnakeListener implements SnakeActionListener {

        @Override
        public void makeMove(EventObject e) {

        }

        @Override
        public void changeSpeedPlus(EventObject e) {
            currentScore++;
        }

        @Override
        public void changeSpeedMinus(EventObject e) {
           currentScore--;
        }
    }
        
    @Override
    public void show() {
       
    }

    @Override
    public void render(float f) {
        game.batch.begin();
        drawField();
        drawSnake();
        _model.setPositionGameObject();
        drawGameObjects();
        _model.field().getSnake().move();
        keyPressed();
        if(mg!=null)
            mg.run();
        if(_model.field().collisionWithEdges())
            _model.updatePositionRectanglesSnake();
        game.batch.end();
    }

    @Override
    public void resize(int i, int i1) {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
       
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {

    }
    
}
