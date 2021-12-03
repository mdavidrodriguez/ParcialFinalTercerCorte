package vista;

import Entidades.Tiendas;
import java.io.IOException;
import java.util.List;
import modelo.RegistroTiendas;

public class Test {

    public static void main(String[] args) throws IOException{
        RegistroTiendas modelo = new RegistroTiendas();
        Tiendas t1 = new Tiendas("Abvc1", "Vpar-Guatapuri", "Valleupar", "Cesar", "Lg", 100, 4900, 2000);
        Tiendas t2 = new Tiendas("Abhc1", "Vpar-MALLALES", "Valleupar", "Cesar", "Lg", 100, 4900, 4000);
        Tiendas t3 = new Tiendas("Abjc1", "Vpar-Guatapuri", "Valleupar", "Cesar", "Lg", 100, 4900, 6000);
        Tiendas t4 = new Tiendas("Abuc1", "Vpar-Guatapuri", "Valleupar", "Cesar", "Lg", 100, 4900, 8000);

            modelo.registrar(t1);
            modelo.registrar(t2);
            modelo.registrar(t3);
            modelo.registrar(t4);

//            System.out.println("---------------------");
//            DatosProductosVendidos eliminado = modelo.Eliminar("123");
//            System.out.println("Futbolista eliminado: ");
//            if(eliminado!=null)
//                imprimirFutbolista(eliminado);
//            else
//               System.out.println("El futbolista de cedula 123 no se encuentra en el archivo");
//            
//            System.out.println("---------------------");
//            
//            System.out.println("Futbolista buscado: ");
//            Futbolista buscado = modelo.buscar("789");
//            if(buscado!=null)
//                imprimirFutbolista(buscado);
//            else
//                System.out.println("El futbolista de cedula 555 no se encuentra en el archivo");
//            System.out.println("---------------------");
            System.out.println("Futbolista en el archivo: ");
            List<Tiendas> TiendasVentas = modelo.leer();
            imprimirLista(TiendasVentas);
        }

    

    public static void imprimirTiendas(Tiendas t) {
        System.out.printf("%10s %20s %10s %10s %10s %10s %10.2f%n", t.getCodigoTienda(), t.getNombreTienda(), t.getCiudad(),
                t.getDepartamento(), t.getSubtotal(), t.getDescuentoAplicado(), t.getTotal());
    }

    public static void imprimirLista(List<Tiendas> lista) {
//        System.out.printf("%10s %20s %10s %10s %10s %10s%n", "Cedula", "Nombre", "Equipo",
//                "No Goles", "No Partidos", "Promedio");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Tiendas t : lista) {
            imprimirTiendas(t);
}
    }
}
