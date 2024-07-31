package java2.desafio.tabelafipe.model;

public class Veiculo {
    private String valor;
    private String marca;
    private String modelo;
    private String ano;
    private String combustivel;
    private String fipe;

    public Veiculo(DadosVeiculo dadosVeiculo){
        this.valor = dadosVeiculo.valor();
        this.marca = dadosVeiculo.marca();
        this.modelo = dadosVeiculo.modelo();
        this.ano = dadosVeiculo.ano();
        this.combustivel = dadosVeiculo.combustivel();
        this.fipe = dadosVeiculo.fipe();
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getFipe() {
        return fipe;
    }

    public void setFipe(String fipe) {
        this.fipe = fipe;
    }

    @Override
    public String toString() {
        return  "ANO = " + ano + '\n' +
                "VALOR = " + valor + '\n' +
                "MARCA = " + marca + '\n' +
                "MODELO = " + modelo + '\n' +
                "COMBUSTÍVEL = " + combustivel + '\n' +
                "CÓD. FIPE = " + fipe + '\n'
                ;
    }
}
