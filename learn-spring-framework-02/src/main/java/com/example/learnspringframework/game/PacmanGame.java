package com.example.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component // by using this annotation, Spring will scan(ComponentScan) and create an instance of Pacman class
public class PacmanGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("up");
    }

    @Override
    public void down() {
        System.out.println("down");
    }

    @Override
    public void left() {
        System.out.println("left");
    }

    @Override
    public void right() {
        System.out.println("right");
    }
}
