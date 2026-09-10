package pardinho.yuri;

import java.util.List;

public class Validador {

    private List<String> cargosValidos = List.of("Gerente de TI", "Analista de Sistemas", "Analista de Suporte de TI ");

    public boolean isEmailValido(String email) {
        return email != null && email.contains("@");
    }

    public boolean isSenhaValida(String senha) {
        return senha != null && senha.length() >= 6;
    }

    public boolean isCargoValido(String cargo) {
        for (String c : cargosValidos) {
            if (c.equalsIgnoreCase(cargo)) {
                return true;
            }
        }
        return false;
    }
}
