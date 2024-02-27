package org.tendencias;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PopularidadNormal extends Popularidad {
    Icono icono = Icono.MUSICAL_NOTE;

    private static PopularidadNormal instancia;

    public static PopularidadNormal getInstancia() {
        // Si la instancia aún no ha sido creada, la crea
        if (instancia == null) {
            instancia = new PopularidadNormal();
        }
        // Devuelve la instancia única
        return instancia;
    }

    @Override
    public String formularLeyenda(Cancion cancion) {
        return super.formularLeyenda(cancion) + cancion.getArtistaNombre() + " - " + cancion.getAlbumNombre() + " - " + cancion.getTitulo();
    }

    @Override
    public Popularidad anteriorEstado() {
        return this;

    }

    @Override
    public Popularidad siguienteEstado() {
        return PopularidadEnAuge.getInstancia();

    }

    public Icono getIcono() {
        return this.icono;
    }

    private void efectuarCambio(Cancion cancion) {
        cancion.cambiarPopularidad(this.siguienteEstado());
    }


    private boolean verificarCambio(Cancion cancion) {
        if (cancion.yaEstuvoEnAuge()) {
            return this.masDe10024Horas(cancion);
        }
        return cancion.getCantidadReproducciones() > 100;
    }
    private boolean masDe10024Horas(Cancion cancion) {
        return cancion.getReproducciones24Horas().size() > 100;
    }
}


