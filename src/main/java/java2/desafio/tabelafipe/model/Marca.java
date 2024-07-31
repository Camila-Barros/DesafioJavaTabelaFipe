package java2.desafio.tabelafipe.model;

public class Marca {
    private String codigo;
    private String marca;

    public Marca(Dados dados){
        this.codigo = dados.codigo();
        this.marca = dados.nome();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "CÓD: " + codigo +
                " - MARCA: " + marca;
    }
}
