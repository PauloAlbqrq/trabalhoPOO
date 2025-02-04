import java.util.Scanner;

public class Main {
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
            System.out.print("*             5 - REMUNERAÇÃO TOTAL            *\n");
            System.out.print("*             6 - SAIR                         *\n");
            System.out.print("************************************************\n");

            int opcao = menu.nextInt();

            if (opcao == 6) {
                System.out.println("\nPrograma encerrado\n");
                menu.close();
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\nREGISTRAR\n");
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
                    System.out.println("\nREMUNERAÇÃO TOTAL\n");
                    break;
                default:
                    System.out.println("\nOPÇÃO INVÁLIDA\n");
                    break;
            }
        }
    }
}