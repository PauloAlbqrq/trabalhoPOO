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
}
