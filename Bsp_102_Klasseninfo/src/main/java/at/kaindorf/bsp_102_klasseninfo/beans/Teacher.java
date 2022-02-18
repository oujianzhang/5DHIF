package at.kaindorf.bsp_102_klasseninfo.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher {

    @XmlElement(name = "Kürzel")
    private String kuerzel;
    @XmlElement(name = "Titel")
    private String titel;
    @XmlElement(name = "Familienname")
    private String familienname;
    @XmlElement(name = "Vorname")
    private String vorname;
    @XmlElement(name = "Klasse")
    private String klasse;
    @XmlElement(name = "Schüler")
    private int schueler;
    @XmlElement(name = "Raum")
    private String raum;

}
