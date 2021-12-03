package Entidades;

import java.io.Serializable;

public class Tiendas implements Serializable{

    private String codigoTienda;
    private String nombreTienda;
    private String ciudad;
    private String departamento;
    private String nombreProducto;
    private double subtotal;
    private double descuentoAplicado;
    private double total;
    

    public Tiendas() {
    }

    public Tiendas(String codigoTienda, String nombreTienda, String ciudad, String departamento, String nombreProducto, double subtotal, double descuentoAplicado, double total) {
        this.codigoTienda = codigoTienda;
        this.nombreTienda = nombreTienda;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.nombreProducto = nombreProducto;
        this.subtotal = subtotal;
        this.descuentoAplicado = descuentoAplicado;
        this.total = total;
    }

    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getArchivosDatos() {
        return this.codigoTienda+";"+
                this.nombreTienda+";"+ 
                this.ciudad+";"+ 
                this.departamento+";"+
                this.nombreProducto+";"+
                this.subtotal+";"+
                this.descuentoAplicado+";"+
                this.total;
    }

}
