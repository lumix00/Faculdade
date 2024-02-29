package estacionamento;

public class Veiculo {
    protected String tipoVeiculo;
    protected String tipoTamanho;
    protected float tempoEstadia;

    public Veiculo(String tipoVeiculo, float tempoEstadia, String tipoTamanho) {
        this.tipoVeiculo = tipoVeiculo;
        this.tipoTamanho = tipoTamanho;
        this.tempoEstadia = tempoEstadia;
    }

    public void setDadosVeiculo(String tipoVeiculo, float tempoEstadia, String tipoTamanho) {
        this.tipoVeiculo = tipoVeiculo;
        this.tipoTamanho = tipoTamanho;
        this.tempoEstadia = tempoEstadia;
    }
}
