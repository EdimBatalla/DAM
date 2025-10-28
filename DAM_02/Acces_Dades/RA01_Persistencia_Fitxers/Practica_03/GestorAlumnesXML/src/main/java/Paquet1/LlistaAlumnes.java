package Paquet1;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "llistaAlumnes")

public class LlistaAlumnes {
    @XmlElement(name = "alumne")
    public List<Alumne> alumnes = new ArrayList<>();
    
    //constructor buit per JAXB
    public LlistaAlumnes() {}
    public LlistaAlumnes(List<Alumne> alumnes) {
    this.alumnes = alumnes;
    }

    //metode get alumnes per demanar la list
    public List<Alumne> getAlumnes() {
        return alumnes;
    }
}