package estacionamento;

public class CalculoPorTipoVeiculo implements CalculadoraEstacionamento {

    private Veiculo veiculo;

    public CalculoPorTipoVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public double calcular() {
        double tempoEstadia = veiculo.tempoEstadia;
        double valor = 0;

        // Additional charge based on vehicle type
        switch (veiculo.tipoTamanho) {
            case "pequeno":
                valor = Math.ceil(tempoEstadia) * 2;
                break;
            case "medio":
                valor = Math.ceil(tempoEstadia) * 2.5;
                break;
            case "grande":
                valor = Math.ceil(tempoEstadia) * 3;
                break;
            case "caminhonete":
                valor = Math.ceil(tempoEstadia) * 3.5;
                break;
            default:
                System.out.println("Tipo de veículo desconhecido.");
        }

        return valor;
    }
}
