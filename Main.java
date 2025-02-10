import java.util.Scanner;
import java.util.ArrayList;

public class Main {

  public static ArrayList<usuario> usuarios = new ArrayList<usuario>();
  public static ArrayList<livro> livros = new ArrayList<livro>();
  public static ArrayList<emprestimo> emprestimos = new ArrayList<emprestimo>();

  public static void menuRegistro(){
    Scanner subMenuRegistro = new Scanner(System.in);

    while (true) {
      System.out.print("************************************************\n");
      System.out.print("*  DIGITE O NUMERO OPÇÃO DA OPERAÇÃO DESEJADA  *\n");
      System.out.print("************************************************\n");
      System.out.print("*             1 - USUARIO                      *\n");
      System.out.print("*             2 - LIVRO                        *\n");
      System.out.print("*             3 - EMPRESTIMO                   *\n");
      System.out.print("************************************************\n");

      int opcao = subMenuRegistro.nextInt();

      if (opcao == 6) {
        System.out.println("\nPrograma encerrado\n");
        subMenuRegistro.close();
        break;
      }

      switch (opcao) {
        case 1:
          System.out.println("\nREGISTRAR USUARIO\n");
          // Add code to register user
          Scanner userScanner = new Scanner(System.in);
          System.out.print("Digite o nome do usuário: ");
          String nomeUsuario = userScanner.nextLine();
          System.out.print("Digite o cpf do usuário: ");
          String cpfUsuario = userScanner.nextLine();
          System.out.print("Digite o telefone do usuário: ");
          String telefoneUsuario = userScanner.nextLine();

          usuarios.add(new usuario(nomeUsuario, cpfUsuario, telefoneUsuario));
          break;
        case 2:
          System.out.println("\nREGISTRAR LIVRO\n");
          // Add code to register book
          Scanner bookScanner = new Scanner(System.in);
          System.out.print("Digite o título do livro: ");
          String nomeLivro = bookScanner.nextLine();
          System.out.print("Digite o autor do livro: ");
          String autorLivro = bookScanner.nextLine();
          System.out.print("Digite o editora do livro: ");
          String editoraLivro = bookScanner.nextLine();
          System.out.print("Digite o ano do livro: ");
          int anoLivro = bookScanner.nextInt();
          System.out.print("Digite o edição do livro: ");
          int edicaoLivro = bookScanner.nextInt();
          System.out.print("Digite o isbn do livro: ");
          int isbnLivro = bookScanner.nextInt();

          livros.add(new livro(nomeLivro, autorLivro, editoraLivro, anoLivro, edicaoLivro, isbnLivro));
          
          break;
        case 3:
          System.out.println("\nREGISTRAR EMPRESTIMO\n");
          // Add code to register loan
          Scanner loanScanner = new Scanner(System.in);
          System.out.print("Digite o cpf do usuário: ");
          String cpfUsuarioReg = loanScanner.nextLine(); 

          System.out.print("Digite o cpf do usuário: ");
          String loanUser = loanScanner.nextLine();
          System.out.print("Digite o cpf do usuário: ");
          String loanUser = loanScanner.nextLine();
          System.out.print("Digite o cpf do usuário: ");
          String loanUser = loanScanner.nextLine();
          // Save loan information
        default:
          System.out.println("\nOPÇÃO INVÁLIDA\n");
          break;

      }
    }
  }

  public static void main(String[] args) {
    Scanner menu = new Scanner(System.in);

    while (true) {
      System.out.print("************************************************\n");
      System.out.print("*  DIGITE O NUMERO OPÇÃO DA OPERAÇÃO DESEJADA  *\n");
      System.out.print("************************************************\n");
      System.out.print("*             1 - REGISTRAR                    *\n");
      System.out.print("*             2 - LISTAR                       *\n");
      System.out.print("*             3 - ATUALIZAR                    *\n");
      System.out.print("*             4 - DELETAR                      *\n");
      System.out.print("*             5 - SAIR                         *\n");
      System.out.print("************************************************\n");

      int opcao = menu.nextInt();

      if (opcao == 5) {
        System.out.println("\nPrograma encerrado\n");
        menu.close();
        break;
      }

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
        default:
          System.out.println("\nOPÇÃO INVÁLIDA\n");
          break;

      }
    }
  }
}
