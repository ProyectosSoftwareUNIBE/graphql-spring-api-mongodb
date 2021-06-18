package programacion.nube.graphql.dtos;

public class ProductDto {
    private String nombre, codigo;
    private double precio, iva, descuento, precioFinal;

    public ProductDto() {
    }

    public ProductDto(String nombre, String codigo, double precio, double iva, double descuento, double precioFinal) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.iva = iva;
        this.descuento = descuento;
        this.precioFinal = precioFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
