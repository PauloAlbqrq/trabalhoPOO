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

  public static void menuRegistro(){
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
          String nomeUsuario = scanner.nextLine();
          scanner.nextLine();
          System.out.print("Digite o cpf do usuário: ");
          String cpfUsuario = scanner.nextLine();
          System.out.print("Digite o telefone do usuário: ");
          String telefoneUsuario = scanner.nextLine();

          usuarios.add(new usuario(nomeUsuario, cpfUsuario, telefoneUsuario));
          break;
        case 2:
          System.out.println("\nREGISTRAR LIVRO\n");

          System.out.print("Digite o título do livro: ");
          String nomeLivro = scanner.nextLine();
          scanner.nextLine();
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
          
          break;
        case 3:
          System.out.println("\nREGISTRAR EMPRESTIMO\n");
          scanner.nextLine(); // evita que o scanner do cpf receba o /n deixado pelo ultimo nextLine e não receba o cpf
          System.out.print("Digite o cpf do usuário: ");
          String cpfUsuarioReg = scanner.nextLine();

          if (checarCPF(cpfUsuarioReg)) {
            System.out.print("Digite o ISBN do livro: ");
            int isbnInput = scanner.nextInt();
            if (checarISBN(isbnInput)) {
              System.out.print("Digite a data de emprestimo: ");
              String dataEmprestimo = scanner.nextLine();
              scanner.nextLine();
              System.out.print("Digite a data de devolução: ");
              String dataDevolucao = scanner.nextLine();
              emprestimos.add(new emprestimo(livros.get(getIndexComISBN(isbnInput)), usuarios.get(getIndexComCPF(cpfUsuarioReg) ), dataEmprestimo, dataDevolucao));
            }
            else {
              System.out.print("O livro não existe.");
            }
          }
          else {
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
          break;
        case 3:
          System.out.println("\nATUALIZAR\n");
          break;
        case 4:
          System.out.println("\nDELETAR\n");
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
