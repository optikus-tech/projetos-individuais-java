package sptech.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtensaoProjeto {
    static void main() {

        List<String> empresasCadastradas = new ArrayList<>(List.of("Smart Sampa", "Grupo Vigile", "Grupo Stl"));
        List<String> cargosCadastrados = new ArrayList<>(List.of("Gerente de TI", "Analista de Sistemas", "Analista de Suporte de TI "));
        List<String> senhaCadastrar = new ArrayList<>();

        Scanner informacoesCliente = new Scanner(System.in);

        System.out.println("Continuando seu cadastro:");
        System.out.println("------");

        System.out.println("Em qual empresa você trabalha?:");
        String empresa = informacoesCliente.nextLine();

        Boolean empresaEncontrada = false;

        for (int i = 0; i < empresasCadastradas.toArray().length; i++) {
            if (empresa.equals(empresasCadastradas.toArray()[i])) {
                empresaEncontrada = true;
            }
        }

        if (empresaEncontrada == true) {
            System.out.println("------");
            System.out.println("Empresa encontrada");
        } else {
            System.out.println("------");
            System.out.println("Essa empresa não está cadastrada em nosso banco de dados!");
        }

        System.out.println("------");

        System.out.println("Qual cargo você exerce?:");
        String cargo = informacoesCliente.nextLine();

        Boolean cargoEncontrado = false;


        for (int i = 0; i < cargosCadastrados.toArray().length; i++) {
            if (cargo.equals(cargosCadastrados.toArray()[i])) {
                cargoEncontrado = true;
            }
        }

        if (cargoEncontrado == true){
            System.out.println("------");
            System.out.println("Cargo Encontrado");
        } else {
            System.out.println("------");
            System.out.println("Esse cargo não possui permissões de acesso!");
        }

        System.out.println("------");

        System.out.println("Criar senha:");
        String senha = informacoesCliente.nextLine();

        senhaCadastrar.add(senha);

        System.out.println("------");

        System.out.println("Confirmar senha:");
        String senhaConfirmar = informacoesCliente.nextLine();

        if (senha.equals(senhaConfirmar) == false) {
            System.out.println("------");
            System.out.println("Senhas diferentes!");
        } else {
            System.out.println("------");
            System.out.println("Cadastro confirmado!");
        }

        System.out.println("------");
        System.out.println("Bem vinda Ana!");
        System.out.println("Trabalha como " + (cargo) + " na empresa " + (empresa));
        System.out.println("------");
        System.out.println("Dirigindo-se para o Login");
    }
}
