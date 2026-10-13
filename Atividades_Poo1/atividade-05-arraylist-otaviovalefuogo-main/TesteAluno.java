public class TesteAluno {

    public static void main(String[] args) {
        
        new Aluno("Ana Silva", 1001, "Ciência da Computação");
        new Aluno("Bruno Costa", 1002, "Engenharia Civil");
        new Aluno("Carla Dias", 1003, "Ciência da Computação");
        new Aluno("Diego Fernandes", 1004, "Medicina");
        
        System.out.println("\n--- Buscando por Nome (bruno costa) ---");
        Aluno.buscarPorNome("bruno costa");

        System.out.println("\n--- Buscando por Matrícula (1003) ---");
        Aluno.buscarPorMatricula(1003);

        System.out.println("\n--- Listando por Curso (Ciência da Computação) ---");
        Aluno.listarPorCurso("Ciência da Computação");

        System.out.println("\n--- Removendo por Matrícula (1002) ---");
        Aluno.removerPorMatricula(1002);

        System.out.println("\n--- Nova Busca (bruno costa) ---");
        Aluno.buscarPorNome("bruno costa");
    }
}