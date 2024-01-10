package com.example.learnspringframework;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.GamingConsole;
import com.example.learnspringframework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }

    //var game = new MarioGame();
    //var game = new SuperContraGame();

   // var game = new PacmanGame(); //1: Object Creation

   // var gameRunner = new GameRunner(game);
    //2: Object Creation + Wiring of Dependencies
    // Game is a Dependency of GameRunner

     //   gameRunner.run();

}
