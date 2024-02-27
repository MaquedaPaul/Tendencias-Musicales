package org.tendencias;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PopularidadEnAuge extends Popularidad {
    private static PopularidadEnAuge instancia;
    public static PopularidadEnAuge getInstancia() {
        // Si la instancia aún no ha sido creada, la crea
        if (instancia == null) {
            instancia = new PopularidadEnAuge();
        }
        // Devuelve la instancia única
        return instancia;
    }

    Icono icono = Icono.ROCKET;
    @Override
    public String formularLeyenda(Cancion cancion) {
        return super.formularLeyenda(cancion) + cancion.getTitulo() + " - " + cancion.getArtistaNombre() + " (" + cancion.getAlbumNombre() + " - " + cancion.getAlbumAnio() + ")";
    }

    @Override
    public Popularidad anteriorEstado() {
        return PopularidadNormal.getInstancia();

    }

    @Override
    public Popularidad siguienteEstado() {
        return PopularidadTendencia.getInstancia();
    }
}
