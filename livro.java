public class livro {
  String titulo;
  String autor;
  String editora;
  int ano;
  int edicao;
  int isbn;
  boolean emprestado;

  public livro(String titulo, String autor, String editora, int ano, int edicao, int isbn) {
    this.titulo = titulo;
    this.autor = autor;
    this.editora = editora;
    this.ano = ano;
    this.edicao = edicao;
    this.isbn = isbn;
    this.emprestado = false;
  }

  public void imprimirAtributos() {
    System.out.println("Título: " + this.titulo);
    System.out.println("Autor: " + this.autor);
    System.out.println("Editora: " + this.editora);
    System.out.println("Ano: " + this.ano);
    System.out.println("Edição: " + this.edicao);
    System.out.println("ISBN: " + this.isbn);
    System.out.println("Emprestado: " + (this.emprestado ? "Sim" : "Não"));
    System.out.println();
  }
}
