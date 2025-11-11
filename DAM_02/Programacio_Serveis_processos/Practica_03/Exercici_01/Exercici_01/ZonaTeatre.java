package Exercici_01;

import java.util.ArrayList;
import java.util.List;

public class ZonaTeatre {
    private final String nomZona;
    private final boolean[] butaques; // false = lliure, true = ocupada

    public ZonaTeatre(String nomZona, int capacitat) {
        this.nomZona = nomZona;
        this.butaques = new boolean[capacitat];
    }

    public String getNomZona() {
        return nomZona;
    }

    public int getCapacitat() {
        return butaques.length;
    }

    public synchronized int comptarLliures() {
        int lliures = 0;
        for (boolean ocupada : butaques) {
            if (!ocupada) lliures++;
        }
        return lliures;
    }

    public synchronized List<Integer> llistarLliures() {
        List<Integer> lliures = new ArrayList<>();
        for (int i = 0; i < butaques.length; i++) {
            if (!butaques[i]) lliures.add(i + 1);
        }
        return lliures;
    }

    public synchronized List<Integer> llistarOcupades() {
        List<Integer> ocupades = new ArrayList<>();
        for (int i = 0; i < butaques.length; i++) {
            if (butaques[i]) ocupades.add(i + 1);
        }
        return ocupades;
    }

    public synchronized ResultatReserva reservar(int n) {
        if (n <= 0) {
            return ResultatReserva.rebuig(nomZona, "Quantitat invàlida");
        }

        int lliures = comptarLliures();
        if (n > lliures) {
            return ResultatReserva.rebuig(nomZona, "No hi ha prou butaques lliures");
        }

        List<Integer> seleccionades = new ArrayList<>(n);

        for (int i = 0; i < butaques.length && seleccionades.size() < n; i++) {
            if (!butaques[i]) {
                seleccionades.add(i + 1); // butaques numerades 1..N
            }
        }

        if (seleccionades.size() != n) {
            return ResultatReserva.rebuig(nomZona, "No s’han pogut seleccionar " + n + " butaques");
        }

        for (int seat : seleccionades) {
            int idx = seat - 1;
            if (idx < 0 || idx >= butaques.length || butaques[idx]) {
                return ResultatReserva.rebuig(nomZona, "Conflicte de selecció");
            }
        }

        for (int seat : seleccionades) {
            butaques[seat - 1] = true;
        }

        return ResultatReserva.exit(nomZona, seleccionades);
    }
}