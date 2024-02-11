package org.tendencias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class Cancion {
    final Icono icono;
    @Getter
    final Popularidad popularidad;
    @Getter
    final Artista artista;
    @Getter
    final Album album;
    @Getter
    final String titulo;
    int reproduccionesHistoricas = 0;
    LocalDateTime primeraReperoduccionAntesReset = null;
    int reproduccionesActuales = 0;



    String leyenda(){
        return this.getPopularidad().formularLeyenda(this);
    }
    String getArtistaNombre(){
        return getArtista().getNombre();
    }
    String getAlbumNombre(){
        return getAlbum().getNombre();
    }
    String getAlbumAnio(){
        return String.valueOf(getAlbum().getAnio().getYear());
    }

    void reproducir(){
        reproduccionesHistoricas++;

        if(primeraReperoduccionAntesReset == null){
            primeraReperoduccionAntesReset = LocalDateTime.now();
        }
        getPopularidad().reproducir(this);


    }
    void reset(){
        primeraReperoduccionAntesReset = null;
    }
}
