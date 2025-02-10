public class usuario {
  String nome;
  String cpf;
  String telefone;

  public usuario(String nome, String cpf, String telefone) {
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
  }

  public void imprimirAtributos() {
    System.out.println("Nome: " + this.nome);
    System.out.println("CPF: " + this.cpf);
    System.out.println("Telefone: " + this.telefone);
    System.out.println();
  }
}
