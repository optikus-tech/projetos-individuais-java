package school.sptech;
import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro {
    public static void main(String[] args) {

        Usuario user1 = new Usuario();

        System.out.println("------------------------------------------------Cadastre o usuário------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        user1.nome = nome;
        user1.cpf = cpf;
        user1.telefone = telefone;
        user1.email = email;
        user1.senha = senha;

        usuarios.add(user1);
        System.out.println("\n");
        System.out.println("Usuário cadastrado com sucesso! \n");
        user1.exibirInformacoes();

        sc.close();
    }
}
