package school.sptech;


import java.util.Scanner;

public class Main {

    static Login fazerLogin(Scanner leitor) {
        Login login = new Login();
        System.out.println("Insira seu email: ");
        login.email = leitor.nextLine();

        System.out.println("Insira sua senha: ");
        login.senha = leitor.nextLine();

        return login;
    }


    static void main() {

        Scanner leitor = new Scanner(System.in);
        Login login = fazerLogin(leitor);
        while (true) {
            if (login.email.contains("@") && login.email.contains(".")) {
                if (login.email.equalsIgnoreCase("admin@admin.com") && login.senha.equalsIgnoreCase("admin")) {
                    System.out.println("Login Aprovado!!");
                    break;
                } else {
                    System.out.println("Login Inválido!");
                    login = fazerLogin(leitor);
                }
            } else {
                System.out.println("Email em formato errado.  \n Digite 2 para tentar novamente | 0 para sair.");
                Integer escolha = Integer.parseInt(leitor.nextLine());
                if (escolha == 2) {
                    login = fazerLogin(leitor);
                } else if (escolha == 0) {
                    break;
                }
            }
        }


    }
}