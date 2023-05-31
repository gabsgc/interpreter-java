public class OperacaoAnd implements InterpretadorExpressao {
    private boolean x;
    private boolean y;

    public OperacaoAnd(Booleano elementoEsquerda, Booleano elementoDireita) {
        x = elementoEsquerda.isValor();
        y = elementoDireita.isValor();
    }

    @Override
    public boolean interpretar() {
        return x && y;
    }
}
