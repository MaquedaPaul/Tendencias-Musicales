package org.tendencias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class Album {
    final List<Cancion> canciones;
    @Getter
    final String nombre;
    @Getter
    final LocalDate anio;
}
