package es.masanz.ut7.pokemonfx.model.map;

import es.masanz.ut7.pokemonfx.model.base.Evento;
import es.masanz.ut7.pokemonfx.model.base.Mapa;
import es.masanz.ut7.pokemonfx.model.enums.CollisionType;
import es.masanz.ut7.pokemonfx.model.enums.TileType;
import es.masanz.ut7.pokemonfx.model.event.EventoEjemplo;
import es.masanz.ut7.pokemonfx.model.pokemons.Bulbasaur;
import es.masanz.ut7.pokemonfx.model.pokemons.Charmander;
import es.masanz.ut7.pokemonfx.model.pokemons.Squirtle;

import java.util.ArrayList;

public class Ruta3 extends Mapa {

    @Override
    protected void cargarPokemonSalvajes(){
        pokemonSalvajes = new ArrayList<>();
        pokemonSalvajes.add(new Bulbasaur(5));
        pokemonSalvajes.add(new Squirtle(6));
        pokemonSalvajes.add(new Charmander(7));
    }

    @Override
    protected void cargarMapa() {

        this.nombre = "Ruta 3";

        // 🎮 MAPA DE RUTA 3 - Diseño completo basado en Pokémon Gen 2/3
        // Códigos de tiles:
        // 1 = Pared/Monte borde
        // 2 = Césped navegable
        // 3 = Hierba (encuentros Pokémon)
        // 4 = Arbusto (bloquea movimiento)
        // 5 = Teleport (salida)
        // 6 = Monte/Roca decorativo
        // 7 = Árbol oscuro (bloquea)
        // 8 = Árbol verde (bloquea)
        // 9 = Casa/Edificio (bloquea)
        // 10 = Flores decorativas (bloquea)
        // 11 = Agua (opcional, bloquea)

        int[][] mapaRuta = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 7, 2, 2, 2, 10, 10, 10, 2, 2, 2, 8, 2, 1},
                {1, 7, 7, 2, 2, 2, 10, 10, 10, 2, 2, 2, 8, 2, 1},
                {1, 7, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 7, 2, 2, 2, 2, 9, 9, 9, 2, 2, 2, 2, 2, 1},
                {1, 7, 2, 2, 2, 2, 9, 9, 9, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 3, 3, 2, 2, 2, 2, 2, 3, 3, 2, 2, 1},
                {1, 2, 2, 3, 3, 2, 2, 2, 2, 2, 3, 3, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 5, 2, 2, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        this.inicioX = 7;
        this.inicioY = 11;

        this.altura = mapaRuta.length;
        this.anchura = mapaRuta[0].length;

        this.mapData = new int[altura][anchura];
        this.collisionMap = new int[altura][anchura];
        this.teleportMap = new String[altura][anchura];
        this.eventsMap = new Evento[altura][anchura];
        this.npcs = new ArrayList<>();

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < anchura; x++) {
                switch (mapaRuta[y][x]) {
                    case 1:
                        // Pared/Borde
                        mapData[y][x] = TileType.PARED_BLANCA.ordinal();
                        collisionMap[y][x] = CollisionType.PARED.ordinal();
                        break;
                    case 2:
                        // Césped navegable
                        mapData[y][x] = TileType.CESPED.ordinal();
                        collisionMap[y][x] = CollisionType.SUELO.ordinal();
                        break;
                    case 3:
                        // Hierba - Encuentros con Pokémon salvajes
                        mapData[y][x] = TileType.CESPED_HIERBA.ordinal();
                        collisionMap[y][x] = CollisionType.SUELO.ordinal();
                        eventsMap[y][x] = new EventoEjemplo();
                        break;
                    case 4:
                        // Arbusto (bloquea)
                        mapData[y][x] = TileType.CESPED_ARBUSTO.ordinal();
                        collisionMap[y][x] = CollisionType.PARED.ordinal();
                        break;
                    case 5:
                        // Teleport a Ruta 2
                        mapData[y][x] = TileType.TELEPORT_RED.ordinal();
                        collisionMap[y][x] = CollisionType.SUELO.ordinal();
                        teleportMap[y][x] = "Ruta 2";
                        break;
                    case 6:
                        // Monte/Roca decorativo
                        mapData[y][x] = TileType.MONTE_CENTRO.ordinal();
                        collisionMap[y][x] = CollisionType.PARED.ordinal();
                        break;
                    case 7:
                        // Árbol oscuro
                        mapData[y][x] = TileType.ARBOL.ordinal();
                        collisionMap[y][x] = CollisionType.PARED.ordinal();
                        break;

                    default:
                        mapData[y][x] = TileType.CAMINO_BLANCO.ordinal();
                        collisionMap[y][x] = CollisionType.SUELO.ordinal();
                        break;
                }
            }
        }
    }
}
