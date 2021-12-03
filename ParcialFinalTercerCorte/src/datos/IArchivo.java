
package datos;

import Entidades.Tiendas;
import java.io.IOException;
import java.util.List;

public interface IArchivo {
     public List<Tiendas> leer() throws IOException;
     public Tiendas buscar(String codigoTienda) throws IOException ;
     public Tiendas eliminar(String codigoTienda) throws IOException;
     public boolean escribir (Tiendas t) throws IOException;
}
