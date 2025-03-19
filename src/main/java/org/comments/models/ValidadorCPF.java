package org.comments.models;

// Reescreva o código abaixo removendo apenas os comentários que explicam o funcionamento do código de maneira redundante:

public class ValidadorCPF {

    /**
     * Método responsável por validar um CPF.
     * Um CPF válido deve ter 11 dígitos numéricos e passar pelo cálculo de verificação.
     *
     * @param cpf Número do CPF em formato de string (somente números).
     * @return Retorna `true` se o CPF for válido e `false` caso contrário.
     */
    public static boolean validarCPF(String cpf) {
        // Remove possíveis pontos e traços do CPF
        cpf = cpf.replace(".", "").replace("-", "");

        // Verifica se o CPF tem exatamente 11 caracteres após a remoção
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais, o que tornaria o CPF inválido
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Vetor para armazenar os números do CPF como inteiros
        int[] numeros = new int[11];

        // Converte cada caractere da string CPF em um número inteiro
        for (int i = 0; i < 11; i++) {
            numeros[i] = Character.getNumericValue(cpf.charAt(i));
        }

        // Cálculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += numeros[i] * (10 - i); // Multiplica os 9 primeiros dígitos por valores decrescentes de 10 a 2
        }
        int primeiroDigito = (soma * 10) % 11;
        if (primeiroDigito == 10) primeiroDigito = 0; // Se o resto for 10, considera-se 0

        // Se o primeiro dígito verificador não corresponder ao CPF informado, retorna falso
        if (numeros[9] != primeiroDigito) {
            return false;
        }

        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += numeros[i] * (11 - i); // Multiplica os 10 primeiros dígitos por valores decrescentes de 11 a 2
        }
        int segundoDigito = (soma * 10) % 11;
        if (segundoDigito == 10) segundoDigito = 0;

        // Se o segundo dígito verificador não corresponder ao CPF informado, retorna falso
        return numeros[10] == segundoDigito;
    }

    /**
     * Método responsável por formatar um CPF para o padrão XXX.XXX.XXX-XX.
     *
     * @param cpf Número do CPF em formato de string (somente números).
     * @return Retorna o CPF formatado ou null se o CPF não tiver exatamente 11 números.
     */
    public static String formatarCPF(String cpf) {
        // Remove caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return null;
        }

        // Retorna o CPF no formato XXX.XXX.XXX-XX usando substring
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }

    public static void main(String[] args) {
        // Exemplo de CPF válido
        String cpf = "12345678909";

        if (validarCPF(cpf)) {
            System.out.println("CPF válido!");
            System.out.println("CPF formatado: " + formatarCPF(cpf));
        } else {
            System.out.println("CPF inválido!");
        }
    }
}

