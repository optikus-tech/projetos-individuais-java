package pardinho.yuri;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Empresa> empresas = new ArrayList<>();

    private static Validador validador = new Validador();

    public static void main(String[] args) {
        inicializarDadosMockados();
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------- SISTEMA INICIADO --------------");
        String cnpjDigitado = lerInputObrigatorio(scanner, "Digite o CNPJ para iniciar:");

        Empresa empresaEncontrada = buscarEmpresaPorCnpj(cnpjDigitado);

        if (empresaEncontrada != null) {
            System.out.println("\nEmpresa já cadastrada! Redirecionando para o login...");
            realizarLogin(scanner, empresaEncontrada);
        } else {
            Empresa novaEmpresa = cadastrarEmpresa(scanner, cnpjDigitado);
            empresas.add(novaEmpresa);
            System.out.println("\nEmpresa cadastrada com sucesso!");
            System.out.println("Redirecionando para o login...");
            realizarLogin(scanner, novaEmpresa);
        }

        scanner.close();
    }

    private static void inicializarDadosMockados() {
        Empresa emp1 = new Empresa("05245375000135", "admin@gmail.com", "admin@123");
        emp1.setRazaoSocial("Smart Sampa");
        empresas.add(emp1);

        Empresa emp2 = new Empresa("42840362000130", "admin@gmail.com", "admin@123");
        emp2.setRazaoSocial("Grupo Vigile");
        empresas.add(emp2);

        Empresa emp3 = new Empresa("64511079000106", "admin@gmail.com", "admin@123");
        emp3.setRazaoSocial("Grupo Stl");
        empresas.add(emp3);
    }

    private static Empresa buscarEmpresaPorCnpj(String cnpj) {
        for (Empresa emp : empresas) {
            if (emp.getCnpj().equals(cnpj)) {
                return emp;
            }
        }
        return null;
    }

    private static void realizarLogin(Scanner scanner, Empresa empresa) {
        int tentativas = 3;

        while (tentativas > 0) {
            System.out.println("-------------- LOGIN --------------");
            System.out.println("Digite seu e-mail: ");
            String email = scanner.nextLine();

            System.out.println("Digite sua senha: ");
            String senha = scanner.nextLine();

            if (email.isEmpty() || senha.isEmpty()) {
                System.out.println("Por gentileza, preencha todos os dados.");
                continue;
            }

            if (empresa.autenticar(email, senha)) {
                String nome = empresa.getRazaoSocial() != null ? empresa.getRazaoSocial() : "Usuário";
                System.out.println("Login realizado com sucesso! Bem-vindo(a), " + nome + "!");
                return;
            }

            tentativas--;
            System.out.println("E-mail ou senha incorretos.");
            if (tentativas > 0) {
                System.out.println("Você ainda tem " + tentativas + " tentativa(s).");
            } else {
                System.out.println("Número de tentativas excedido. Acesso bloqueado.");
            }
        }
    }

    private static Empresa cadastrarEmpresa(Scanner scanner, String cnpj) {
        String razaoSocial = lerInputObrigatorio(scanner, "Razão Social:");
        String endereco = lerInputObrigatorio(scanner, "Endereço:");
        String numero = lerInputObrigatorio(scanner, "Número:");

        System.out.println("Complemento (opcional):");
        String complemento = scanner.nextLine();

        String cep = lerInputObrigatorio(scanner, "CEP:");

        String cargo = lerCargoValido(scanner);
        String email = lerEmailValido(scanner);
        String senha = lerSenhaValida(scanner);

        Empresa novaEmpresa = new Empresa(cnpj, email, senha);
        novaEmpresa.setRazaoSocial(razaoSocial);
        novaEmpresa.setEndereco(endereco);
        novaEmpresa.setNumero(numero);
        novaEmpresa.setComplemento(complemento);
        novaEmpresa.setCep(cep);
        novaEmpresa.setCargo(cargo);

        return novaEmpresa;
    }

    private static String lerInputObrigatorio(Scanner scanner, String mensagem) {
        System.out.println(mensagem);
        String input = scanner.nextLine();
        while (input.trim().isEmpty()) {
            System.out.println("Por favor, preencha este campo obrigatório.");
            System.out.println(mensagem);
            input = scanner.nextLine();
        }
        return input;
    }

    private static String lerCargoValido(Scanner scanner) {
        while (true) {
            String cargo = lerInputObrigatorio(scanner, "Qual o seu cargo?:");

            if (validador.isCargoValido(cargo)) {
                return cargo;
            }
            System.out.println("Cargo inválido ou sem permissão de acesso!(\"Gerente de TI\", \"Analista de Sistemas\", \"Analista de Suporte de TI \")");
        }
    }

    private static String lerEmailValido(Scanner scanner) {
        while (true) {
            String email = lerInputObrigatorio(scanner, "E-mail para login:");

            if (validador.isEmailValido(email)) {
                return email;
            }
            System.out.println("Por favor, informe um e-mail válido (deve conter '@').");
        }
    }

    private static String lerSenhaValida(Scanner scanner) {
        while (true) {
            String senha = lerInputObrigatorio(scanner, "Senha para login:");

            if (validador.isSenhaValida(senha)) {
                return senha;
            }
            System.out.println("A senha deve ter no mínimo 6 caracteres.");
        }
    }
}
