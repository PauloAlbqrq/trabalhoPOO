import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static ArrayList<usuario> usuarios = new ArrayList<usuario>();
  public static ArrayList<livro> livros = new ArrayList<livro>();
  public static ArrayList<emprestimo> emprestimos = new ArrayList<emprestimo>();

  public static Scanner scanner = new Scanner(System.in);

  public static boolean checarCPF(String cpf) {
    for (usuario user : usuarios) {
      if (cpf.equals(user.cpf)) {
        return true;
      }
    }
    return false;
  }

  public static boolean checarISBN(int isbn) {
    for (livro exemplar : livros) {
      if (exemplar.isbn == isbn) {
        return true;
      }
    }
    return false;
  }

  public static int getIndexComCPF(String cpf) {
    for (int i = 0; i < usuarios.size(); i++) {
      if (cpf.equals(usuarios.get(i).cpf)) {
        return i;
      }
    }
    return 0;
  }

  public static int getIndexComISBN(int isbn) {
    for (int i = 0; i < livros.size(); i++) {
      if (isbn == livros.get(i).isbn) {
        return i;
      }
    }
    return 0;
  }

  public static void menuRegistro() {
    boolean continuar = true;

    while (continuar) {
      System.out.print("************************************************\n");
      System.out.print("*  DIGITE O NUMERO OPÇÃO DA OPERAÇÃO DESEJADA  *\n");
      System.out.print("************************************************\n");
      System.out.print("*             1 - USUARIO                      *\n");
      System.out.print("*             2 - LIVRO                        *\n");
      System.out.print("*             3 - EMPRESTIMO                   *\n");
      System.out.print("*             4 - VOLTAR                       *\n");
      System.out.print("************************************************\n");

      int opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.println("\nREGISTRAR USUARIO\n");

          System.out.print("Digite o nome do usuário: ");
          scanner.nextLine();
          String nomeUsuario = scanner.nextLine();
          System.out.print("Digite o cpf do usuário: ");
          String cpfUsuario = scanner.nextLine();
          System.out.print("Digite o telefone do usuário: ");
          String telefoneUsuario = scanner.nextLine();

          usuarios.add(new usuario(nomeUsuario, cpfUsuario, telefoneUsuario));
          System.out.println("Usuário Registrado!");
          break;
        case 2:
          System.out.println("\nREGISTRAR LIVRO\n");

          System.out.print("Digite o título do livro: ");
          scanner.nextLine();
          String nomeLivro = scanner.nextLine();
          System.out.print("Digite o autor do livro: ");
          String autorLivro = scanner.nextLine();
          System.out.print("Digite o editora do livro: ");
          String editoraLivro = scanner.nextLine();
          System.out.print("Digite o ano do livro: ");
          int anoLivro = scanner.nextInt();
          System.out.print("Digite o edição do livro: ");
          int edicaoLivro = scanner.nextInt();
          System.out.print("Digite o isbn do livro: ");
          int isbnLivro = scanner.nextInt();

          livros.add(new livro(nomeLivro, autorLivro, editoraLivro, anoLivro, edicaoLivro, isbnLivro));
          System.out.println("Livro Registrado!");

          break;
        case 3:
          System.out.println("\nREGISTRAR EMPRESTIMO\n");
          scanner.nextLine(); // evita que o scanner do cpf receba o /n deixado pelo ultimo nextLine e não
                              // receba o cpf
          System.out.print("Digite o cpf do usuário: ");
          String cpfUsuarioReg = scanner.nextLine();

          if (checarCPF(cpfUsuarioReg)) {
            System.out.print("Digite o ISBN do livro: ");
            int isbnInput = scanner.nextInt();
            if (checarISBN(isbnInput)) {
              if (livros.get(getIndexComISBN(isbnInput)).emprestado) {
                System.out.println("Livro não disponível");
                break;
              }
              System.out.print("Digite a data de emprestimo: ");
              scanner.nextLine();
              String dataEmprestimo = scanner.nextLine();
              System.out.print("Digite a data de devolução: ");
              String dataDevolucao = scanner.nextLine();
              livros.get(getIndexComISBN(isbnInput)).emprestado = true;
              emprestimos.add(new emprestimo(livros.get(getIndexComISBN(isbnInput)),
                  usuarios.get(getIndexComCPF(cpfUsuarioReg)), dataEmprestimo, dataDevolucao));
              System.out.println("Empréstimo Registrado!");
            } else {
              System.out.print("O livro não existe.");
            }
          } else {
            System.out.print("Usuário não existe.\n");
          }
          break;
        case 4:
          continuar = false;
          break;
        default:
          System.out.println("\nOPÇÃO INVÁLIDA\n");
          break;

      }
    }
  }

  public static void menuEdicao() {
    boolean continuar = true;

    while (continuar) {
      System.out.print("************************************************\n");
      System.out.print("*  DIGITE O NUMERO OPÇÃO DA OPERAÇÃO DESEJADA  *\n");
      System.out.print("************************************************\n");
      System.out.print("*             1 - USUARIO                      *\n");
      System.out.print("*             2 - LIVRO                        *\n");
      System.out.print("*             3 - EMPRESTIMO                   *\n");
      System.out.print("*             4 - VOLTAR                       *\n");
      System.out.print("************************************************\n");

      int opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.println("\nEDITAR USUARIO\n");

          System.out.print("Digite o cpf do usuário: ");
          scanner.nextLine();
          String cpfUsuario = scanner.nextLine();

          if (checarCPF(cpfUsuario)) {
            int index = getIndexComCPF(cpfUsuario);
            System.out.print("Digite o novo nome do usuário: ");
            String nomeUsuario = scanner.nextLine();
            System.out.print("Digite o novo telefone do usuário: ");
            String telefoneUsuario = scanner.nextLine();

            usuarios.get(index).nome = nomeUsuario;
            usuarios.get(index).telefone = telefoneUsuario;
            System.out.println("Usuário Editado!");
          } else {
            System.out.println("Usuário não encontrado.");
          }
          break;
        case 2:
          System.out.println("\nEDITAR LIVRO\n");

          System.out.print("Digite o ISBN do livro: ");
          scanner.nextLine();
          int isbnLivro = scanner.nextInt();

          if (checarISBN(isbnLivro)) {
            int index = getIndexComISBN(isbnLivro);
            System.out.print("Digite o novo título do livro: ");
            scanner.nextLine();
            String nomeLivro = scanner.nextLine();
            System.out.print("Digite o novo autor do livro: ");
            String autorLivro = scanner.nextLine();
            System.out.print("Digite a nova editora do livro: ");
            String editoraLivro = scanner.nextLine();
            System.out.print("Digite o novo ano do livro: ");
            int anoLivro = scanner.nextInt();
            System.out.print("Digite a nova edição do livro: ");
            int edicaoLivro = scanner.nextInt();

            livros.get(index).titulo = nomeLivro;
            livros.get(index).autor = autorLivro;
            livros.get(index).editora = editoraLivro;
            livros.get(index).ano = anoLivro;
            livros.get(index).edicao = edicaoLivro;
            System.out.println("Livro Editado!");
          } else {
            System.out.println("Livro não encontrado.");
          }
          break;
        case 3:
          System.out.println("\nEDITAR EMPRESTIMO\n");

          System.out.print("Digite o cpf do usuário: ");
          scanner.nextLine();
          String cpfUsuarioEmp = scanner.nextLine();

          if (checarCPF(cpfUsuarioEmp)) {
            System.out.print("Digite o ISBN do livro: ");
            int isbnEmp = scanner.nextInt();

            if (checarISBN(isbnEmp)) {
              for (emprestimo emp : emprestimos) {
                if (emp.usuario.cpf.equals(cpfUsuarioEmp) && emp.livro.isbn == isbnEmp) {
                  System.out.print("Digite a nova data de emprestimo: ");
                  scanner.nextLine();
                  String dataEmprestimo = scanner.nextLine();
                  System.out.print("Digite a nova data de devolução: ");
                  String dataDevolucao = scanner.nextLine();

                  emp.dataEmprestimo = dataEmprestimo;
                  emp.dataDevolucao = dataDevolucao;
                  System.out.println("Empréstimo Editado!");
                  break;
                }
              }
            } else {
              System.out.println("Livro não encontrado.");
            }
          } else {
            System.out.println("Usuário não encontrado.");
          }
          break;
        case 4:
          continuar = false;
          break;
        default:
          System.out.println("\nOPÇÃO INVÁLIDA\n");
          break;
      }
    }
  }

  public static void menuApagar() {
    boolean continuar = true;

    while (continuar) {
      System.out.print("************************************************\n");
      System.out.print("*  DIGITE O NUMERO OPÇÃO DA OPERAÇÃO DESEJADA  *\n");
      System.out.print("************************************************\n");
      System.out.print("*             1 - USUARIO                      *\n");
      System.out.print("*             2 - LIVRO                        *\n");
      System.out.print("*             3 - EMPRESTIMO                   *\n");
      System.out.print("*             4 - VOLTAR                       *\n");
      System.out.print("************************************************\n");

      int opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.println("\nAPAGAR USUARIO\n");

          System.out.print("Digite o cpf do usuário: ");
          scanner.nextLine();
          String cpfUsuario = scanner.nextLine();

          if (checarCPF(cpfUsuario)) {
            int index = getIndexComCPF(cpfUsuario);
            usuarios.remove(index);
            System.out.println("Usuário Deletado!");
          } else {
            System.out.println("Usuário não encontrado.");
          }
          break;
        case 2:
          System.out.println("\nAPAGAR LIVRO\n");

          System.out.print("Digite o ISBN do livro: ");
          scanner.nextLine();
          int isbnLivro = scanner.nextInt();

          if (checarISBN(isbnLivro)) {
            int index = getIndexComISBN(isbnLivro);
            livros.remove(index);
            System.out.println("Livro Deletado!");
          } else {
            System.out.println("Livro não encontrado.");
          }
          break;
        case 3:
          System.out.println("\nAPAGAR EMPRESTIMO\n");

          System.out.print("Digite o cpf do usuário: ");
          scanner.nextLine();
          String cpfUsuarioEmp = scanner.nextLine();

          if (checarCPF(cpfUsuarioEmp)) {
            System.out.print("Digite o ISBN do livro: ");
            int isbnEmp = scanner.nextInt();

            if (checarISBN(isbnEmp)) {
              for (emprestimo emp : emprestimos) {
                if (emp.usuario.cpf.equals(cpfUsuarioEmp) && emp.livro.isbn == isbnEmp) {
                  emp.livro.emprestado = false;
                  emprestimos.remove(emp);
                  System.out.println("Empréstimo Deletado!");
                  break;
                }
              }
            } else {
              System.out.println("Livro não encontrado.");
            }
          } else {
            System.out.println("Usuário não encontrado.");
          }
          break;
        case 4:
          continuar = false;
          break;
        default:
          System.out.println("\nOPÇÃO INVÁLIDA\n");
          break;
      }
    }
  }

  public static void main(String[] args) {
    boolean continuar = true;

    while (continuar) {
      System.out.print("************************************************\n");
      System.out.print("*  DIGITE O NUMERO OPÇÃO DA OPERAÇÃO DESEJADA  *\n");
      System.out.print("************************************************\n");
      System.out.print("*             1 - REGISTRAR                    *\n");
      System.out.print("*             2 - LISTAR                       *\n");
      System.out.print("*             3 - ATUALIZAR                    *\n");
      System.out.print("*             4 - DELETAR                      *\n");
      System.out.print("*             5 - SAIR                         *\n");
      System.out.print("************************************************\n");

      int opcao = scanner.nextInt();

      switch (opcao) {
        case 1:
          System.out.println("\nREGISTRAR\n");
          menuRegistro();
          break;
        case 2:
          System.out.println("\nLISTAR\n");
          System.out.print("************************************************\n");
          System.out.print("*             1 - USUÁRIOS                     *\n");
          System.out.print("************************************************\n");
          for (usuario user : usuarios) {
            user.imprimirAtributos();
          }
          System.out.println();
          System.out.print("************************************************\n");
          System.out.print("*             2 - LIVROS                       *\n");
          System.out.print("************************************************\n");
          for (livro book : livros) {
            book.imprimirAtributos();
          }
          System.out.println();
          System.out.print("************************************************\n");
          System.out.print("*             3 - EMPRÉSTIMOS                  *\n");
          System.out.print("************************************************\n");
          for (emprestimo loan : emprestimos) {
            loan.imprimirAtributos();
          }
          break;
        case 3:
          System.out.println("\nATUALIZAR\n");
          menuEdicao();
          break;
        case 4:
          System.out.println("\nDELETAR\n");
          menuApagar();
          break;
        case 5:
          System.out.println("\nPrograma encerrado\n");
          scanner.close();
          continuar = false;
          break;
        default:
          System.out.println("\nOPÇÃO INVÁLIDA\n");
          break;

      }
    }
  }
}
