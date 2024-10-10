package modelo;

public class Producto {
    private String Referencia;
    private String Nombre;
    private Float Precio;
    private Integer Categoria;

    public Producto() {
    }

    public Producto(String Referencia, String Nombre, Float Precio, Integer Categoria) {
        this.Referencia = Referencia;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Categoria = Categoria;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public Integer getCategoria() {
        return Categoria;
    }

    public void setCategoria(Integer Categoria) {
        this.Categoria = Categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Referencia='" + Referencia + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Precio=" + Precio +
                ", Categoria=" + Categoria +
                '}';
    }
}