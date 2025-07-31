package bessa.morangon.rafael;

public class Validador {

    public static boolean validar(String cpf) {

        if(cpf.matches("\\d{11}") && !cpf.chars().allMatch(c -> c == cpf.charAt(0)) && cpf != null){
            //\\d é para indicar 0-9 somente digitos e só pode ter 11
            // a segunda expressão impede que todos os digitos sejam iguais, detalhe para o ! na frente
            return verificador(cpf);
        }
        return false;
    }

    private static boolean verificador(String cpf){

        return decimoDigito(cpf).toString().charAt(0) == cpf.charAt(9) &&
                decimoPrimeiroDigito(cpf).toString().charAt(0) == cpf.charAt(10);
    }
    private static Integer decimoDigito(String cpf){

        // Primeiro descobrir o décimo digito
        // fazer a soma com os pesos dos 9 primeiros digitos
        // como eu pego os 9 primeiros digitos?

        Integer soma = 0;
        Integer auxiliar = 10;
        Integer resto;

        for (int i = 0; i <= 8; i++){
            // 8 por que vai de 0 a 10 o indice do char, eu nao quero os digitos verificadores
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (auxiliar - i);
        }

        resto = soma % 11;
        //esse 11 é a regra do cpf
        // (condição) ? valorSeVerdadeiro : valorSeFalso
        return (resto < 2) ? 0 : 11 - resto;
    }

    private static Integer decimoPrimeiroDigito(String cpf){

        Integer soma = 0;
        Integer auxiliar = 11;
        Integer resto;

        //Agora saber o Décimo primeiro digito

        for(int j = 0; j <= 9; j++){
            soma += Integer.parseInt(String.valueOf(cpf.charAt(j))) * (auxiliar - j);
        }

        resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}
