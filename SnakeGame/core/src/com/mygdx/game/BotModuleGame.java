/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import snakeGame.modules.Module;

/**
 *
 * @author Anna
 */
public class BotModuleGame implements Module{
    GamePanel gm;

    //Apple ap = gm.model().
    public void load(GamePanel gm, Module batch) {
        this.gm = gm;
        this.gm.setModule(batch);
    }
    Apple ap;
    public int run() {
        
        Snake snake = gm.model().field().getSnake();
        for(GameObject obj : gm.model().field().getObjects()){
            if(obj instanceof Food){
                if(obj instanceof Apple){
                    ap =  (Apple) obj;
                }
            }
        }

        if(snake.snakeParts.get(0).getY() == ap.objectRectangle.getY() || ap.objectRectangle.getY()- snake.snakeParts.get(0).getY() == 1  || snake.snakeParts.get(0).getY() - ap.objectRectangle.getY() == 1){
            if(snake.snakeParts.get(0).getX() < ap.objectRectangle.getX())
                snake.moveDirection = 3;
            else
                snake.moveDirection = 2;
        } else {
            snake.moveDirection = 1;
        }
       /* if(snake.snakeParts.get(0).getY() == ap.objectRectangle.getY()){
            if(snake.snakeParts.get(0).getX() < ap.objectRectangle.getX())
                snake.moveDirection = 3;
            else if(snake.snakeParts.get(0).getX() > ap.objectRectangle.getX())
                 snake.moveDirection = 2;
        }
        if(snake.snakeParts.get(0).getX() == ap.objectRectangle.getX()){
            if(snake.snakeParts.get(0).getY() < ap.objectRectangle.getY())
                snake.moveDirection = 0;
            else if(snake.snakeParts.get(0).getY() > ap.objectRectangle.getY())
                 snake.moveDirection = 1;
        }
        /*if(snake.snakeParts.get(0).getX() <= -1)
            snake.moveDirection = 1;*/
        /*if(snake.snakeParts.get(0).getY() >= 650){
            snake.moveDirection = 3;
        }
        if(snake.snakeParts.get(0).getY() >= 650 && snake.snakeParts.get(0).getX() > 1300)
            snake.moveDirection = 1;
        if(snake.snakeParts.get(0).getY() <= 20){
            snake.moveDirection = 3;
        }
        if(snake.snakeParts.get(0).getY() <= 20 && snake.snakeParts.get(0).getX() > 1300)
            snake.moveDirection = 0;
        
        
        if(snake.snakeParts.get(0).getX() >= 1300)
            snake.moveDirection = 0;
        
        if(snake.snakeParts.get(0).getX() >= 1300 && snake.snakeParts.get(0).getY() >= 650)
            snake.moveDirection = 1;
        if (snake.snakeParts.get(0).getX() <=100 && snake.snakeParts.get(0).getY() < 20)
            snake.moveDirection = 3;*/
       
    
        return 0;
    }
    
    public void unload() {
        System.out.println("unload");
    }
    
}
