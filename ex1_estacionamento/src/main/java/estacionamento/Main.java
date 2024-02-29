package estacionamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean dadosValidos = false;
        Date entrada;
        Date saida;
        Veiculo veiculo = new Veiculo("", 0,"");

        while (!dadosValidos) {
            System.out.print("Informe o momento de entrada (dd/mm/aaaa hh:mm): ");
            String momentoEntrada = scanner.nextLine();

            System.out.print("Informe o momento de saída (dd/mm/aaaa hh:mm): ");
            String momentoSaida = scanner.nextLine();

            System.out.print("Informe o tipo do veículo (passeio ou carga): ");
            String tipoVeiculo = scanner.nextLine().toLowerCase();

            System.out.print("Informe o tamanho do veículo (pequeno, médio, grande e caminhonete): ");
            String tipoTamanho = scanner.nextLine().toLowerCase();

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                entrada = formatter.parse(momentoEntrada);
                saida = formatter.parse(momentoSaida);

                float entradaMili = entrada.getTime();
                float saidaMili = saida.getTime();
                float tempoEstadia = saidaMili - entradaMili;

                switch (tipoVeiculo) {
                    case "passeio":
                    case "carga":
                        dadosValidos = true;
                        scanner.close();
                        // Criar instância da classe Veiculo
                        veiculo.setDadosVeiculo(tipoVeiculo, tempoEstadia / 3600000, tipoTamanho);
                        break;

                    default:
                        System.out.println("Tipo de veiculo invalido. Por favor, insira novamente.");
                }

            } catch (ParseException e) {
                System.out.println("Uma ou ambas as datas incorretas. Por favor, insira novamente.");
            }
        }

        // Define qual fórmula deve ser usada
        float tempo = veiculo.tempoEstadia;
        // Existing code...

        CalculadoraEstacionamento calculoFinal;
        double valorTamanho;

        if (tempo < 1) {
            calculoFinal = new CalculoHoraCase2(veiculo);
        } else if (tempo <= 12) {
            calculoFinal = new CalculoHora(veiculo);
        } else if (tempo > 12 && (tempo / 24 <= 15)) {
            calculoFinal = new CalculoDia(veiculo);
        } else {
            calculoFinal = new CalculoMes(veiculo);
        }

        // Instantiate the appropriate implementation of CalculadoraEstacionamento
        CalculadoraEstacionamento calculoPorTipoVeiculo = new CalculoPorTipoVeiculo(veiculo);
        valorTamanho = calculoPorTipoVeiculo.calcular();

        System.out.println("Este veiculo deve pagar " + calculoFinal.calcular());
        System.out.println(
                "Este veiculo deve pagar pelo tamanho de " + veiculo.tipoTamanho + " o valor de: " + valorTamanho);
    }
}
