package es.masanz.ut7.pokemonfx.app;

import es.masanz.ut7.pokemonfx.controller.MapController;
import es.masanz.ut7.pokemonfx.model.pokemons.Bulbasaur;
import es.masanz.ut7.pokemonfx.model.pokemons.Charmander;
import es.masanz.ut7.pokemonfx.model.base.Entrenador;
import es.masanz.ut7.pokemonfx.model.pokemons.Squirtle;
import javafx.application.Application;
import javafx.stage.Stage;

public class GameApp extends Application {

    // SPRITES OBTENIDOS DE (ENTRE OTROS) https://www.spriters-resource.com/game_boy_gbc/pokemongoldsilver/

    public static Entrenador jugador;

    @Override
    public void start(Stage primaryStage) {
        MapController.load(primaryStage);
    }

    public static void main(String[] args) {
        // TODO 00: AQUI DEFINIR VUESTRO ENTRENADOR INICIAL
        jugador = new Entrenador();
        jugador.incluirPokemonParaCombatir(0, new Bulbasaur(5));
        jugador.incluirPokemonParaCombatir(1, new Charmander(6));
        jugador.incluirPokemonParaCombatir(2, new Squirtle(7));
        jugador.incluirPokemonParaCombatir(3, new Squirtle(8));
        jugador.incluirPokemonParaCombatir(4, new Charmander(9));
        jugador.incluirPokemonParaCombatir(5, new Bulbasaur(15));
        jugador.getPokemonesCapturados().add(new Squirtle(25));
        jugador.getPokemonesCapturados().add(new Charmander(35));
        launch(args);
    }
}
