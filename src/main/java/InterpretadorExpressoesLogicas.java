import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class InterpretadorExpressoesLogicas implements InterpretadorExpressao {
    private InterpretadorExpressao interpretadorInicial;

    public InterpretadorExpressoesLogicas(String contexto) {
        Stack<InterpretadorExpressao> pilhaInterpretadores = new Stack<>();
        List<String> elementos = Arrays.asList(contexto.split(" "));
        Iterator<String> iterator = elementos.iterator();

        while (iterator.hasNext()) {
            String elemento = iterator.next();
            if (elemento.equalsIgnoreCase("true") || elemento.equalsIgnoreCase("false")) {
                pilhaInterpretadores.push(new Booleano(Boolean.parseBoolean(elemento)));
            } else if (elemento.equalsIgnoreCase("and")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                Booleano elementoEsquerda = (Booleano) pilhaInterpretadores.pop();
                Booleano elementoDireita = new Booleano(Boolean.parseBoolean(iterator.next()));
                OperacaoAnd interpretador = new OperacaoAnd(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Booleano(interpretador.interpretar()));
            } else if (elemento.equalsIgnoreCase("or")) {
                if (!iterator.hasNext())
                    throw new IllegalArgumentException("Expressão inválida");
                Booleano elementoEsquerda = (Booleano) pilhaInterpretadores.pop();
                Booleano elementoDireita = new Booleano(Boolean.parseBoolean(iterator.next()));
                OperacaoOr interpretador = new OperacaoOr(elementoEsquerda, elementoDireita);
                pilhaInterpretadores.push(new Booleano(interpretador.interpretar()));
            } else {
                throw new IllegalArgumentException("Expressão com elemento inválido");
            }
        }
        interpretadorInicial = pilhaInterpretadores.pop();
    }

    @Override
    public boolean interpretar() {
        return interpretadorInicial.interpretar();
    }
}
