package org.tendencias;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PopularidadEnAuge extends Popularidad {
    Icono icono = Icono.ROCKET;
    @Override
    public String formularLeyenda(Cancion cancion) {
        return super.formularLeyenda(cancion) + cancion.getTitulo() + " - " + cancion.getArtistaNombre() + " (" + cancion.getAlbumNombre() + " - " + cancion.getAlbumAnio() + ")";
    }

    @Override
    public Popularidad anteriorEstado() {
        return new PopularidadNormal();

    }

    @Override
    public Popularidad siguienteEstado() {
        return new PopularidadTendencia();
    }
}
