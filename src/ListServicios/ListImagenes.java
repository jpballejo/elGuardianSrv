/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListServicios;

import Logica.Imagenes;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author PabloP
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListImagenes {
    
    List<Imagenes> lista;

    public ListImagenes(List<Imagenes> list) {
        this.lista = list;
    }

    public List<Imagenes> getLista() {
        return this.lista;
    }
    
}