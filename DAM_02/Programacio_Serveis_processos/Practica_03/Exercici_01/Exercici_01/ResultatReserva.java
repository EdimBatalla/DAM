package Exercici_01;

import java.util.Collections;
import java.util.List;

public class ResultatReserva {
    private final boolean exit;
    private final String zona;
    private final List<Integer> butaques;
    private final String missatge;

    private ResultatReserva(boolean exit, String zona, List<Integer> butaques, String missatge) {
        this.exit = exit;
        this.zona = zona;
        this.butaques = butaques == null ? List.of() : List.copyOf(butaques);
        this.missatge = missatge;
    }

    public static ResultatReserva exit(String zona, List<Integer> butaques) {
        return new ResultatReserva(true, zona, butaques, "OK");
    }

    public static ResultatReserva rebuig(String zona, String missatge) {
        return new ResultatReserva(false, zona, Collections.emptyList(), missatge);
    }

    public boolean isExit() {
        return exit;
    }

    public String getZona() {
        return zona;
    }

    public List<Integer> getButaques() {
        return butaques;
    }

    public String getMissatge() {
        return missatge;
    }

    @Override
    public String toString() {
        return (exit ? "[OK] " : "[KO] ") + zona + " " + butaques + (exit ? "" : " - " + missatge);
    }
}
