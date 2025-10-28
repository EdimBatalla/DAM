package perist.dades.xml.json;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "llistaAlumnes")
public class LlistaAlumnes {//clase llista alumnes
    @XmlElement(name = "alumne")
    public List<Alumne> alumnes = new ArrayList<>();
    public LlistaAlumnes() {}//constructor buit per JAXB
    public LlistaAlumnes(List<Alumne> alumnes) {
    this.alumnes = alumnes;
    }
    public List<Alumne> getAlumnes() {
        return alumnes;
    }//metode get alumnes per demanar la list
}
