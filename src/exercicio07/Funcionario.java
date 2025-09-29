package exercicio07;

class Funcionario implements Identificavel<String> {
    private final String matricula;
    private final String nome;

    public Funcionario(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public String getId() {
        return matricula;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return "Funcionario{matricula='" + matricula + "', nome='" + nome + "'}";
    }
}