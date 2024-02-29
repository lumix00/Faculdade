package estacionamento;

public class CalculoHoraCase2 implements CalculadoraEstacionamento {

    private Veiculo veiculo;

    public CalculoHoraCase2(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    Double valor;

    @Override
    public double calcular() {
        valor = Math.ceil(veiculo.tempoEstadia * 4);

        if (veiculo.tipoVeiculo.equals("passeio")) {
            return valor;
        } else {
            return valor * 1.5;
        }
    }
}
