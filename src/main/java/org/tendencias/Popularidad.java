package org.tendencias;

import lombok.Getter;

public abstract class  Popularidad {
   @Getter
    Icono icono;
    int reproduccionesActuales = 0;

    String formularLeyenda(Cancion cancion) {
        return getIcono().texto()+" - ";
    }

    Popularidad anteriorEstado() {
        return null;
    }

    Popularidad siguienteEstado() {
        return null;
    }

    public void reproducir(Cancion cancion) {
        reproduccionesActuales++;
        verificarCambio(cancion);
        efectuarCambio(cancion);
    }

    private void efectuarCambio(Cancion cancion) {
    }

    private boolean verificarCambio(Cancion cancion) {
        
    }

}
