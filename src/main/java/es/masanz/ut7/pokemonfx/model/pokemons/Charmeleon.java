package es.masanz.ut7.pokemonfx.model.pokemons;

import es.masanz.ut7.pokemonfx.model.base.Ataque;
import es.masanz.ut7.pokemonfx.model.base.Pokemon;
import es.masanz.ut7.pokemonfx.model.enums.Tipo;
import es.masanz.ut7.pokemonfx.model.type.Fuego;

public class Charmeleon extends Pokemon implements Fuego {

    public Charmeleon(int nivel) {
        super(nivel);
    }

    @Override
    public int nivelEvolucion() {
        return 7;
    }

    @Override
    public Pokemon pokemonAEvolucionar() {
        if (this.nivel >= nivelEvolucion()) {
            return new Charizard(this.nivel);
        }
        return new Charmeleon(this.nivel);
    }

    @Override
    protected void asignarAtaques() {

        Ataque aranazo = new Ataque("arañazo", 40, 100, Tipo.NORMAL, false, 35);
        asignarAtaque(aranazo.getNombre(), aranazo);

        Ataque ascuas = new Ataque("ascuas", 40, 100, Tipo.FUEGO, true, 25);
        asignarAtaque(ascuas.getNombre(), ascuas);

        Ataque lanzallamas = new Ataque("lanzallamas", 95, 100, Tipo.FUEGO, true, 10);
        asignarAtaque(lanzallamas.getNombre(), lanzallamas);
/*
        Ataque cuchillada = new Ataque("cuchillada", 70, 100, Tipo.NORMAL, false, 20);
        asignarAtaque(cuchillada.getNombre(), cuchillada);
*/
    }
}
