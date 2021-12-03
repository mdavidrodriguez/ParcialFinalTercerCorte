package datos;

import Entidades.Tiendas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArchivoTiendasTexto implements IArchivo{

    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;

    public ArchivoTiendasTexto() {
        this.archivo = new File("ReporteVentas.dat");

    }

    public ArchivoTiendasTexto(String name) {
        this.archivo = new File(name);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileWriter getaEscritura() {
        return aEscritura;
    }

    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    public Scanner getaLectura() {
        return aLectura;
    }

    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }

    public Tiendas leerTiendas(String linea[]) {
        Tiendas t = new Tiendas();
        t.setCodigoTienda(linea[0]);
        t.setNombreTienda(linea[1]);
        t.setCiudad(linea[2]);
        t.setDepartamento(linea[3]);
        t.setNombreProducto(linea[4]);
        t.setSubtotal(Double.valueOf(linea[5]));
        t.setDescuentoAplicado(Double.valueOf(linea[6]));
        t.setTotal(Double.valueOf(linea[7]));
        return t;

    }


    public List<Tiendas> leer() throws IOException {

        List<Tiendas> lista = null;

        try {
            this.aLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while (this.aLectura.hasNext()) {
                String linea[] = this.aLectura.nextLine().split(";");
                Tiendas t = this.leerTiendas(linea);
                lista.add(t);
            }
            return lista;
        } catch (FileNotFoundException ex) {
            throw new IOException("Error al leer el archivo");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }

    }

    public Tiendas buscar(String codigoTienda) throws IOException {
        Tiendas buscado = null;

        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                Tiendas t = this.leerTiendas(this.aLectura.nextLine().split(";"));
                if (t.getCodigoTienda().equals(codigoTienda)) {
                    buscado = t;
                    break;
                }
            }
            return buscado;
        } catch (FileNotFoundException ex) {
            throw new IOException("No fue posible abrir el archivo para leer");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
    }

    public Tiendas eliminar(String codigoTienda) throws IOException { // 123

        Tiendas eliminado = null;
        List<Tiendas> listadotiendas = this.leer();
        ArchivoTiendasTexto archivoTmp = new ArchivoTiendasTexto("ListadoRegistroTiendas.dat");
        for (Tiendas t : listadotiendas) {
            if (t.getCodigoTienda().equals(codigoTienda)) {
                eliminado = t;
            } else {
                archivoTmp.escribir(t);
            }
        }

        if (!archivoTmp.archivo.exists()) {
            archivoTmp.archivo.createNewFile();
        }

        if (this.archivo.delete()) {
            if (archivoTmp.archivo.renameTo(this.archivo)) {
                return eliminado;
            } else {
                throw new IOException("El archivo temporal no fue renombrado");
            }

        } else {
            throw new IOException("El archivo original no fue eliminado");
        }

    }

    public boolean escribir(Tiendas t) throws IOException {

        PrintWriter escritor = null;
        boolean exito = false;
        try {
            this.aEscritura = new FileWriter(this.archivo, true);
            escritor = new PrintWriter(this.aEscritura);
            escritor.println(t.getArchivosDatos());
            exito = true;
            return exito;

        } catch (IOException ioe) {
            throw new IOException("Error al abrir el archvio en modo escritura");
        } finally {
            if (escritor != null) {
                escritor.close();
            }

            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }

}
