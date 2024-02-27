package org.tendencias;
import lombok.*;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Cancion {
    final Icono icono;
    @NonNull
    @Getter(AccessLevel.NONE)
    List<Popularidad> popularidad;
    @Getter
    final Artista artista;
    @Getter
    final Album album;

    final String titulo;
    List<LocalDateTime> reproduccionesHistoricas;



    String leyenda(){
        return this.getPopularidad().formularLeyenda(this);
    }

    private Popularidad getPopularidad() {
        return this.getPopularidades().get(this.getPopularidades().size()-1);
    }

    private List<Popularidad> getPopularidades() {
        return this.popularidad;
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
        sumarReproduccion();
        getPopularidad().reproducir(this);


    }

    private void sumarReproduccion() {
        getReproduccionesHistoricas().add(LocalDateTime.now());
    }

    public boolean yaEstuvoEnAuge() {
        return getPopularidades().stream().anyMatch(popularidad -> popularidad.equals(PopularidadEnAuge.getInstancia()));
    }

    public int getCantidadReproducciones() {
        return getReproduccionesHistoricas().size();
    }

    private List<LocalDateTime> getReproduccionesXHoras(int horas){
        return getReproduccionesHistoricas().stream().filter(reproduccion -> reproduccion.isAfter(LocalDateTime.now().minusHours(horas))).toList();
    }
    public List<LocalDateTime> getReproducciones24Horas() {
        return getReproduccionesXHoras(24);
    }
    public List<LocalDateTime> getReproducciones48Horas() {
        return getReproduccionesXHoras(48);
    }

    public void cambiarPopularidad(Popularidad popularidad) {
        this.getPopularidades().add(popularidad);
    }
}
