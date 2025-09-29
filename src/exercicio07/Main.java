/*Defina Identificavel com getId(). Crie IRepository<T extends Identificavel, ID> com salvar, buscarPorId (retorna Optional<T>), listarTodos e remover. Implemente InMemoryRepository com Map<ID, T>, garanta que listarTodos devolva cópia imutável e lance EntidadeNaoEncontradaException ao remover ID inexistente. Use com entidades como Produto e Funcionario.*/
package exercicio07;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        IRepository<Produto, Integer> produtoRepo = new InMemoryRepository<>();
        IRepository<Funcionario, String> funcionarioRepo = new InMemoryRepository<>();

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== MENU REPOSITÓRIO GENÉRICO ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Buscar Produto por ID");
            System.out.println("4. Remover Produto");
            System.out.println("5. Adicionar Funcionario");
            System.out.println("6. Listar Funcionarios");
            System.out.println("7. Buscar Funcionario por Matrícula");
            System.out.println("8. Remover Funcionario");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("ID do produto: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome do produto: ");
                        String nome = sc.nextLine();
                        System.out.print("Preço do produto: ");
                        double preco = sc.nextDouble();
                        produtoRepo.salvar(new Produto(id, nome, preco));
                        System.out.println("Produto adicionado com sucesso!");
                    }
                    case 2 -> {
                        System.out.println("=== Produtos ===");
                        produtoRepo.listarTodos().forEach(System.out::println);
                    }
                    case 3 -> {
                        System.out.print("Digite o ID do produto: ");
                        int id = sc.nextInt();
                        produtoRepo.buscarPorId(id)
                                .ifPresentOrElse(
                                        System.out::println,
                                        () -> System.out.println("Produto não encontrado.")
                                );
                    }
                    case 4 -> {
                        System.out.print("Digite o ID do produto a remover: ");
                        int id = sc.nextInt();
                        produtoRepo.remover(id);
                        System.out.println("Produto removido.");
                    }
                    case 5 -> {
                        System.out.print("Matrícula do funcionário: ");
                        String matricula = sc.nextLine();
                        System.out.print("Nome do funcionário: ");
                        String nome = sc.nextLine();
                        funcionarioRepo.salvar(new Funcionario(matricula, nome));
                        System.out.println("Funcionário adicionado com sucesso!");
                    }
                    case 6 -> {
                        System.out.println("=== Funcionários ===");
                        funcionarioRepo.listarTodos().forEach(System.out::println);
                    }
                    case 7 -> {
                        System.out.print("Digite a matrícula do funcionário: ");
                        String matricula = sc.nextLine();
                        funcionarioRepo.buscarPorId(matricula)
                                .ifPresentOrElse(
                                        System.out::println,
                                        () -> System.out.println("Funcionário não encontrado.")
                                );
                    }
                    case 8 -> {
                        System.out.print("Digite a matrícula do funcionário a remover: ");
                        String matricula = sc.nextLine();
                        funcionarioRepo.remover(matricula);
                        System.out.println("Funcionário removido.");
                    }
                    case 0 -> {
                        rodando = false;
                        System.out.println("Saindo...");
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (EntidadeNaoEncontradaException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite novamente.");
                sc.nextLine();
            }
        }

        sc.close();
    }
}