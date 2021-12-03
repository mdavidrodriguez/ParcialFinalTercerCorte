package modelo;

import Entidades.Tiendas;
import datos.ArchivoTiendasBin;
import datos.ArchivoTiendasTexto;
import datos.IArchivo;
import datos.ListaArrayList;
import java.io.IOException;
import java.util.List;

public class RegistroTiendas {
    
 private IArchivo datos; //

    public RegistroTiendas() {
        this.datos = new ArchivoTiendasTexto();
        //this.datos = new ListaArrayList();
//        this.datos = new ArchivoTiendasBin();
    }

    public IArchivo getDatos() {
        return datos;
    }

    public void setDatos(ArchivoTiendasBin datos) {
        this.datos = datos;
    }
    
    
    public boolean registrar(Tiendas t) throws IOException{
        return this.datos.escribir(t);
    }
    
    public List<Tiendas> leer() throws IOException{
        return this.datos.leer();
    }
    
    public Tiendas eliminar(String codigoTienda) throws IOException{
        return this.datos.eliminar(codigoTienda);
    }
    
    public Tiendas buscar(String codigoTienda) throws IOException{
        return this.datos.buscar(codigoTienda);
    }
}
