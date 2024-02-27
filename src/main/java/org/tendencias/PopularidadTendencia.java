package org.tendencias;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PopularidadTendencia extends Popularidad {
    private static PopularidadTendencia instancia;
    public static PopularidadTendencia getInstancia() {
        // Si la instancia aún no ha sido creada, la crea
        if (instancia == null) {
            instancia = new PopularidadTendencia();
        }
        // Devuelve la instancia única
        return instancia;
    }
    Icono icono = Icono.FIRE;
    @Override
    public String formularLeyenda(Cancion cancion) {
        return super.formularLeyenda(cancion) + cancion.getArtistaNombre() + " - " + cancion.getAlbumNombre() + " - " + cancion.getTitulo();
    }

    @Override
    public Popularidad anteriorEstado() {
        return PopularidadNormal.getInstancia();
    }

    @Override
    public Popularidad siguienteEstado() {
        return this;
    }
}
