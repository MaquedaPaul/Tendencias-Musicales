package org.tendencias;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PopularidadNormal extends Popularidad {
    Icono icono = Icono.MUSICAL_NOTE;

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
        return new PopularidadEnAuge();

    }

    public Icono getIcono() {
        return this.icono;
    }

    private void efectuarCambio(Cancion cancion) {

    }

    private boolean verificarCambio(Cancion cancion) {
        if(cancion.yaEstuvoEnAuge())
        return reproduccionesActuales > 100;
    }
}
