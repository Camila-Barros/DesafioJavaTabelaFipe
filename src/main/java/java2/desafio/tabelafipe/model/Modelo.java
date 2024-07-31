package java2.desafio.tabelafipe.model;

public class Modelo {
    private String codigo;
    private String modelo;

    public Modelo(Dados dados){
        this.codigo = dados.codigo();
        this.modelo = dados.nome();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "CÓD: " + codigo +
                " - MODELO: " + modelo;
    }
}
