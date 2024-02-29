package estacionamento;

public class CalculoMes implements CalculadoraEstacionamento {

    private Veiculo veiculo;

    public CalculoMes(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public double calcular() {

        double valor = Math.ceil(veiculo.tempoEstadia / 24 / 30) * 300;

        if (veiculo.tipoVeiculo.equals("passeio")) {
            return valor;
        } else {
            return valor * 1.5;
        }
    }
}
