package school.sptech;

public class Usuario {
    String nome;
    String cpf;
    String telefone;
    String email;
    String senha;

    void exibirInformacoes() {
        System.out.printf("""
                ====================================
                Nome: %s
                CPF: %s
                Telefone: %s
                Email: %s
                ====================================
                """,
                nome, cpf, telefone, email);
    }
}
