package datos;

import Entidades.Tiendas;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaArrayList implements IArchivo, Serializable {

    private List<Tiendas> lista;

    public ListaArrayList() {
        this.lista = new ArrayList();
    }

    @Override
    public List<Tiendas> leer() throws IOException {
        return this.getLista();
    }

    @Override
    public Tiendas buscar(String codigoTienda) throws IOException {
        for (Tiendas t : this.getLista()) {
            if (t.getCodigoTienda().equals(codigoTienda)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Tiendas eliminar(String codigoTienda) throws IOException {
        Iterator<Tiendas> i = this.getLista().iterator();
        while (i.hasNext()) {
            Tiendas t = i.next();
            if (t.getCodigoTienda().equals(codigoTienda)) {
                i.remove();
                return t;
            }
        }
        return null;

    }

    @Override
    public boolean escribir(Tiendas t) throws IOException {
        return this.getLista().add(t);
    }

    public List<Tiendas> getLista() {
        return lista;
    }

    public void setLista(List<Tiendas> lista) {
        this.lista = lista;
    }

}
