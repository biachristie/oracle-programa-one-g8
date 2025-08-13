package br.com.alura.conversor.model;

public class Conversor {

    private String result;
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double conversion_result;

    public String getResultadoChamada() {
        return result;
    }

    public String getCodigoBase() {
        return base_code;
    }

    public void setCodigoBase(String base_code) {
        this.base_code = base_code;
    }

    public String getCodigoAlvo() {
        return target_code;
    }

    public void setCodigoAlvo(String target_code) {
        this.target_code = target_code;
    }

    public Double getTaxaConversao() {
        return conversion_rate;
    }

    public Double getResultadoConversao() {
        return conversion_result;
    }

    public String formatarResultado(double valor) {
        String valorFormatado = String.format("%.2f", valor);
        String resultadoFormatado = String.format("%.2f", getResultadoConversao());

        return "\nValor de " + valorFormatado + " [" + getCodigoBase() + "] em [" + getCodigoAlvo() + "] corresponde ao valor final de " + resultadoFormatado + " [" + getCodigoAlvo() + "].";
    }

}