package bessa.morangon.rafael;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("*************************************************************");
        System.out.println("Digite o seu CPF sem pontos: ");
        System.out.println();
        String cpfDigitado = scanner.nextLine();

        System.out.println(Validador.validar(cpfDigitado) ? "CPF VÁLIDO" : "CPF INVÁLIDO");
    }
}