package estacionamento;

public class CalculoHora implements CalculadoraEstacionamento {

    private Veiculo veiculo;

    public CalculoHora(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public double calcular() {
        double valor = Math.ceil(veiculo.tempoEstadia) * 2;

        if (veiculo.tipoVeiculo.equals("passeio")) {
            return valor;
        } else {
            return valor * 1.5;
        }
    }
}
