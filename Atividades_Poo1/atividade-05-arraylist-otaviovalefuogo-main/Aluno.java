import java.util.ArrayList;
import java.util.List;

public class Aluno {
    
    private String nome;
    private int matricula;
    private String curso;

    private static List<Aluno> listaDeAlunos = new ArrayList<>();

    public Aluno(String nome, int matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        
        Aluno.listaDeAlunos.add(this);
        System.out.println("Aluno " + nome + " adicionado.");
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void exibirDados() {
        System.out.println("--- Dados do Aluno ---");
        System.out.println("Nome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Curso: " + this.curso);
    }

    public static void buscarPorNome(String nome) {
        boolean encontrado = false;
        for (Aluno aluno : Aluno.listaDeAlunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                aluno.exibirDados();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum aluno encontrado com o nome: " + nome);
        }
    }

    public static void buscarPorMatricula(int matricula) {
        boolean encontrado = false;
        for (Aluno aluno : Aluno.listaDeAlunos) {
            if (aluno.getMatricula() == matricula) {
                aluno.exibirDados();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum aluno encontrado com a matrícula: " + matricula);
        }
    }

    public static void removerPorMatricula(int matricula) {
        boolean removeu = false;
        
        for (int i = 0; i < Aluno.listaDeAlunos.size(); i++) {
            if (Aluno.listaDeAlunos.get(i).getMatricula() == matricula) {
                Aluno.listaDeAlunos.remove(i);
                removeu = true;
                System.out.println("Aluno com matrícula " + matricula + " removido.");
                break; 
            }
        }

        if (!removeu) {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        }
    }

    public static void listarPorCurso(String curso) {
        boolean encontrou = false;
        System.out.println("--- Alunos do curso de " + curso + " ---");
        
        for (Aluno aluno : Aluno.listaDeAlunos) {
            if (aluno.getCurso().equalsIgnoreCase(curso)) {
                aluno.exibirDados();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum aluno encontrado para este curso.");
        }
    }
}