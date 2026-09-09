package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        List<String> empresasCadastradas = new ArrayList<>(List.of("Smart Sampa", "Grupo Vigile", "Grupo Stl"));
        List<String> cargosCadastrados = new ArrayList<>(List.of("Gerente de TI", "Analista de Sistemas", "Analista de Suporte de TI "));
        List<String> listaCnpj = new ArrayList<>(List.of("05245375000135", "42840362000130", "64511079000106"));

        Scanner scanner = new Scanner(System.in);

        String razaoSocial = "";
        String endereco = "";
        String numero = "";
        String complemento = "";
        String cep = "";
        String emailCadastrado = "";
        String senhaCadastrada = "";
        String cargo = "";

        System.out.println("-------------- SISTEMA INICIADO --------------");
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

            String emailMocado = "admin@gmail.com";
            String senhaMocada = "admin@123";

            int tentativas = 3;
            boolean logou = false;

            while (tentativas > 0 && !logou) {
                System.out.println("-------------- LOGIN --------------");
                System.out.println("Digite seu e-mail: ");
                String emailDigitado = scanner.nextLine();

                System.out.println("Digite sua senha: ");
                String senhaDigitada = scanner.nextLine();

                if (emailDigitado.isEmpty() || senhaDigitada.isEmpty()) {
                    System.out.println("Por gentileza, preencha todos os dados.");
                } else if (emailDigitado.equals(emailMocado) && senhaDigitada.equals(senhaMocada)) {
                    System.out.println("Login realizado com sucesso!");
                    logou = true;
                } else {
                    tentativas--;
                    System.out.println("E-mail ou senha incorretos.");
                    if (tentativas == 1) {
                        System.out.println("Você ainda tem " + tentativas + " tentativa.");
                    } else if (tentativas > 1){
                        System.out.println("Você ainda tem " + tentativas + " tentativas.");
                    } else {
                        System.out.println("Número de tentativas excedido. Acesso bloqueado.");
                    }
                }
            }
        } else {
            System.out.println("Razão Social:");
            razaoSocial = scanner.nextLine();
            while (razaoSocial.isEmpty()) {
                System.out.println("Por favor, preencha a razão social.");
                System.out.println("Razão Social:");
                razaoSocial = scanner.nextLine();
            }

            System.out.println("Endereço:");
            endereco = scanner.nextLine();
            while (endereco.isEmpty()) {
                System.out.println("Por favor, preencha o endereço.");
                System.out.println("Endereço:");
                endereco = scanner.nextLine();
            }

            System.out.println("Número:");
            numero = scanner.nextLine();
            while (numero.isEmpty()) {
                System.out.println("Por favor, preencha o número.");
                System.out.println("Número:");
                numero = scanner.nextLine();
            }

            System.out.println("Complemento (opcional):");
            complemento = scanner.nextLine();

            System.out.println("CEP:");
            cep = scanner.nextLine();
            while (cep.isEmpty()) {
                System.out.println("Por favor, preencha o CEP.");
                System.out.println("CEP:");
                cep = scanner.nextLine();
            }

            System.out.println("Qual o seu cargo?:");
            cargo = scanner.nextLine();
            boolean cargoExiste = false;

            for (int i = 0; i < cargosCadastrados.size(); i++) {
                if (cargosCadastrados.get(i).equalsIgnoreCase(cargo)) {
                    cargoExiste = true;
                    break;
                }
            }

            while (cargo.isEmpty() || !cargoExiste) {
                System.out.println("Cargo inválido ou sem permissão de acesso! Cargos válidos: " + cargosCadastrados);
                System.out.println("Qual o seu cargo?:");
                cargo = scanner.nextLine();

                for (int i = 0; i < cargosCadastrados.size(); i++) {
                    if (cargosCadastrados.get(i).equalsIgnoreCase(cargo)) {
                        cargoExiste = true;
                        break;
                    }
                }
            }

            System.out.println("E-mail para login:");
            emailCadastrado = scanner.nextLine();
            while (emailCadastrado.isEmpty() || !emailCadastrado.contains("@")) {
                System.out.println("Por favor, informe um e-mail válido (deve conter '@').");
                System.out.println("E-mail para login:");
                emailCadastrado = scanner.nextLine();
            }

            System.out.println("Senha para login:");
            senhaCadastrada = scanner.nextLine();
            while (senhaCadastrada.isEmpty() || senhaCadastrada.length() < 6) {
                System.out.println("A senha deve ter no mínimo 6 caracteres.");
                System.out.println("Senha para login:");
                senhaCadastrada = scanner.nextLine();
            }

            listaCnpj.add(cnpjDigitado);
            System.out.println("\nEmpresa cadastrada com sucesso!");
            System.out.println("Redirecionando para o login...");

            int tentativas = 3;
            boolean logado = false;

            while (tentativas > 0 && !logado) {
                System.out.println("-------------- LOGIN --------------");
                System.out.println("Digite seu e-mail: ");
                String emailDigitado = scanner.nextLine();

                System.out.println("Digite sua senha: ");
                String senhaDigitada = scanner.nextLine();

                if (emailDigitado.isEmpty() || senhaDigitada.isEmpty()) {
                    System.out.println("Por gentileza, preencha todos os dados.");
                } else if (emailDigitado.equals(emailCadastrado) && senhaDigitada.equals(senhaCadastrada)) {
                    System.out.println("Login realizado com sucesso! Bem-vindo(a), " + razaoSocial + "!");
                    logado = true;
                } else {
                    tentativas--;
                    System.out.println("E-mail ou senha incorretos.");
                    if (tentativas == 1) {
                        System.out.println("Você ainda tem " + tentativas + " tentativa.");
                    } else if (tentativas > 1){
                        System.out.println("Você ainda tem " + tentativas + " tentativas.");
                    } else {
                        System.out.println("Número de tentativas excedido. Acesso bloqueado.");
                    }
                }
            }
        }
        scanner.close();
    }
}