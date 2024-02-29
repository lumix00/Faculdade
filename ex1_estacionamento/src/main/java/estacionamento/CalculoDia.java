package estacionamento;

public class CalculoDia implements CalculadoraEstacionamento {

    private Veiculo veiculo;

    public CalculoDia(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public double calcular() {

        double valor = Math.ceil(veiculo.tempoEstadia / 24) * 26;

        if (veiculo.tipoVeiculo.equals("passeio")) {
            return valor;
        } else {
            return valor * 2;
        }
    }
}
