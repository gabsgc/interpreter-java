public class Escola {
    private static final double NOTA_MINIMA = 7.0;

    public static boolean isAprovado(Aluno aluno) {
        double media = (aluno.getNota1() + aluno.getNota2()) / 2;
        return media >= NOTA_MINIMA;
    }
}
