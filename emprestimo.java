public class emprestimo {
  public livro livro;
  public usuario usuario;
  public String dataEmprestimo;
  public String dataDevolucao;

  public emprestimo(livro livro, usuario usuario, String dataEmprestimo, String dataDevolucao) {
    this.livro = livro;
    this.usuario = usuario;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
  }

  public void imprimirAtributos() {
    System.out.println("Livro: " + livro.titulo);
    System.out.println("Usuário: " + usuario.nome);
    System.out.println("Data de Empréstimo: " + dataEmprestimo);
    System.out.println("Data de Devolução: " + dataDevolucao);
    System.out.println();
  }
}
