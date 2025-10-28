package Exercici_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZonaTeatre {
    private final String nomZona;
    private final boolean[] butaques;

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
    
    public int comptarLliures() {
        int comptador = 0;
        for (boolean butaca : butaques) {
            if (!butaca) {
                comptador++;
            }
        }
        return comptador;
    }

    public List<Integer> obtenirButaquesLliures() {
        List<Integer> lliures = new ArrayList<>();
        for (int i = 0; i < butaques.length; i++) if (!butaques[i]) lliures.add(i + 1);
        return Collections.unmodifiableList(lliures);
    }

    public List<Integer> obtenirButaquesOcupades() {
        List<Integer> ocupades = new ArrayList<>();
        for (int i = 0; i < butaques.length; i++) if (butaques[i]) ocupades.add(i + 1);
        return Collections.unmodifiableList(ocupades);
    }

    public synchronized ResultatReserva reservar(int num, EstrategiaSeleccio estrategia) {
        if (num <= 0) {
            return ResultatReserva.rebuig(nomZona, "Quantita invàlida.")
        }
        if (num > comptarLliures()) {
            return ResultatReserva.rebuig(nomZona, "No hi ha prou butques lliures.")
        }

        List<Integer> seleccio = estretegia.seleccionar(butaques.clone, num);
        if (seleccio == null || seleccio.size() !=n) {
            return ResultatReserva.rebuig(nomZona, "No s'ha pogut seleccionar " + num + " butaques.")
        }  

        for (int seat : seleccio) {
            butaques[seat - 1] = true;
            }

        return ResultatReserva.exit(nomZona, seleccio);
    }
}
