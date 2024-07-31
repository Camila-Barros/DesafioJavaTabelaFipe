package java2.desafio.tabelafipe.principal;

import java2.desafio.tabelafipe.model.*;
import java2.desafio.tabelafipe.service.ConsumoApi;
import java2.desafio.tabelafipe.service.ConverteDados;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){

        System.out.println("\n====================================================");
        System.out.println("    CONSULTA DE DADOS DE VEÍCULOS NA TABELA FIPE    ");
        System.out.println("====================================================");

        System.out.println("\n-------------------------------------------------");
        System.out.println("Digite o tipo de veículo que deseja consultar" +
                "\nCARROS, MOTOS ou CAMINHOES:");

            var tipoVeiculo = leitura.nextLine();
        System.out.println("-------------------------------------------------");

            String endereco;

            if (tipoVeiculo.toLowerCase().contains("car")){
                endereco = ENDERECO + "carros/marcas";
            } else if (tipoVeiculo.toLowerCase().contains("mot")){
                endereco = ENDERECO + "motos/marcas";
            } else {
              endereco = ENDERECO + "caminhoes/marcas";
            }

            var json = consumo.obterDados(endereco);

            var marcas = conversor.obterLista(json, Dados.class);

        System.out.println("\n>>>>>>>>>>> LISTA DE MARCAS <<<<<<<<<<<");
        System.out.println();
            marcas.stream()
                    .map(d ->new Marca(d))
                    .sorted(Comparator.comparing(Marca::getMarca))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        System.out.println("\n-------------------------------------------------");
        System.out.println("Digite o código da MARCA desejada");

            var codMarca = leitura.nextLine();
        System.out.println("-------------------------------------------------");

            endereco = endereco + "/" + codMarca + "/modelos";

            json = consumo.obterDados(endereco);

            var listaModelos = conversor.obterDados(json, Modelos.class);

            System.out.println("\n>>>>>>>>>>> LISTA DE MODELOS <<<<<<<<<<<");
            System.out.println();
            listaModelos.modelos().stream()
                    .map(d ->new Modelo(d))
                    .sorted(Comparator.comparing(Modelo::getModelo))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        System.out.println("\n--------------------------------------------------");
        System.out.println("Digite o código do MODELO");

            var codModelo = leitura.nextLine();
        System.out.println("--------------------------------------------------");

            endereco = endereco + "/" + codModelo + "/anos";

            json = consumo.obterDados(endereco);

            var listaAnos = conversor.obterLista(json, Dados.class);

            List<Dados> anos = conversor.obterLista(json, Dados.class);
            List<DadosVeiculo> dadosVeiculos = new ArrayList<>();

            for (int i = 0; i < anos.size(); i++){
                var enderecoAnos = endereco + "/" + anos.get(i).codigo();
                json = consumo.obterDados(enderecoAnos);
                DadosVeiculo veiculo = conversor.obterDados(json, DadosVeiculo.class);
                dadosVeiculos.add(veiculo);
            }

            System.out.println("\n>>>>>>>>> FICHA DOS VEÍCULOS SOLICITADOS <<<<<<<<<");
            System.out.println();
            dadosVeiculos.stream()
                .map(d -> new Veiculo(d))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

}
