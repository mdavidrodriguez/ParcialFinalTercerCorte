package datos;

import Entidades.Tiendas;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ArchivoTiendasBin implements IArchivo {
 private File archivo;
    private FileOutputStream aEscritura;
    private FileInputStream aLectura;

    public ArchivoTiendasBin() {
        this.archivo = new File("ListaTiendasObjetos.dat");
    }
    
    
    private boolean guardarLista(ListaArrayList lista) throws IOException{
        
        this.aEscritura = new FileOutputStream(this.archivo);
        ObjectOutputStream escritor = new ObjectOutputStream(this.aEscritura);
        escritor.writeObject(lista);
        escritor.close();
        this.aEscritura.close();
        return true;
        
    }
    
    private ListaArrayList leerLista()throws IOException{
       if(this.archivo.exists()){
           this.aLectura = new FileInputStream(this.archivo);
           ObjectInputStream lector = new ObjectInputStream(this.aLectura);
           try{
                ListaArrayList lista = (ListaArrayList)lector.readObject();
                return lista;
           }catch(ClassNotFoundException nfe){
               throw new IOException("Error al leer");
           } finally{
                   lector.close();
                   this.aLectura.close();
           }
       }
       else{
            return new ListaArrayList();
       }
    }

    @Override
    public List<Tiendas> leer() throws IOException {
       ListaArrayList lista = this.leerLista();
       return lista.getLista();
      
    }

    @Override
    public Tiendas buscar(String codigoTienda) throws IOException {
        ListaArrayList lista = this.leerLista();
        return lista.buscar(codigoTienda);
        
    }

    @Override
    public Tiendas eliminar(String codigoTienda) throws IOException {
        ListaArrayList lista = this.leerLista();
        Tiendas eliminado = lista.eliminar(codigoTienda);
        this.guardarLista(lista);
        return eliminado;
        
    }

    @Override
    public boolean escribir(Tiendas t) throws IOException {
        ListaArrayList lista = this.leerLista();
        lista.escribir(t);
        return this.guardarLista(lista);
        
    }
    
   

}
