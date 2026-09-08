package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        List<String> listaCnpj = new ArrayList<>();

        String razaoSocial = "";
        String endereco = "";
        String numero = "";
        String complemento = "";
        String cep = "";
        String emailCadastrado = "";
        String senhaCadastrada = "";

        System.out.println("-------- SISTEMA INICIADO --------");
        System.out.println("Digite o CNPJ para iniciar:");
        String cnpjDigitado = scanner.nextLine();
        boolean cnpjExiste = false;

        for (int i = 0; i < listaCnpj.size(); i++) {
            if (listaCnpj.get(i).equals(cnpjDigitado)){
                cnpjExiste = true;
                break;
            }
        }

        if (cnpjExiste) {
            System.out.println("\nEmpresa já cadastrada! Redirecionando para o login...");

            System.out.println("-------- LOGIN --------");
            System.out.println("Digite seu e-mail: ");
            String emailDigitado = scanner.nextLine();

            System.out.println("Digite sua senha: ");
            String senhaDigitada = scanner.nextLine();

            if (emailDigitado.equals(emailCadastrado) && senhaDigitada.equals(senhaCadastrada)) {
                System.out.println("Login realizado com sucesso!");
            } else {
                System.out.println("E-mail ou senha incorretos.");
            }
        } else {
            System.out.println("Razão Social:");
            razaoSocial = scanner.nextLine();

            System.out.println("Endereço:");
            endereco = scanner.nextLine();

            System.out.println("Número:");
            numero = scanner.nextLine();

            System.out.println("Complemento:");
            complemento = scanner.nextLine();

            System.out.println("CEP:");
            cep = scanner.nextLine();

            System.out.println("E-mail para login:");
            emailCadastrado = scanner.nextLine();

            System.out.println("Senha para login:");
            senhaCadastrada = scanner.nextLine();

            listaCnpj.add(cnpjDigitado);
            System.out.println("\nEmpresa cadastrada com sucesso!");

            System.out.println("\n-------- LOGIN --------");
            System.out.println("Digite seu e-mail:");
            String emailDigitado = scanner.nextLine();

            System.out.println("Digite sua senha:");
            String senhaDigitada = scanner.nextLine();

            if (emailDigitado.equals(emailCadastrado) && senhaDigitada.equals(senhaCadastrada)) {
                System.out.println("Login realizado com sucesso! Bem-vindo(a), " + razaoSocial + "!");
            } else {
                System.out.println("E-mail ou senha incorretos.");
            }
        }
        scanner.close();
    }
}