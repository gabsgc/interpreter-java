public class Aluno {
    private double nota1;
    private double nota2;

    public Aluno(double nota1, double nota2) {
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public boolean isAprovado() {
        return Escola.isAprovado(this);
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }
}
