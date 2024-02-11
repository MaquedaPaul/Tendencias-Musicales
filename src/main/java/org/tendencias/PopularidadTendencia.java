package org.tendencias;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PopularidadTendencia extends Popularidad {
    Icono icono = Icono.FIRE;
    @Override
    public String formularLeyenda(Cancion cancion) {
        return super.formularLeyenda(cancion) + cancion.getArtistaNombre() + " - " + cancion.getAlbumNombre() + " - " + cancion.getTitulo();
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
