public class Booleano implements InterpretadorExpressao {
    private boolean valor;

    public Booleano(boolean valor) {
        this.valor = valor;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }

    public boolean interpretar() {
        return valor;
    }
}
