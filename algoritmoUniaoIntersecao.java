import java.util.Scanner;

public class algoritmoUniaoIntersecao {
    public static void main(String[] args) {
        int qtd1;
        int qtd2;
        int qtdResultado;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade de elementos do primeiro vetor: ");
        qtd1 = scanner.nextInt();
        System.out.println("Digite a quantidade de elementos do segundo vetor: ");
        qtd2 = scanner.nextInt();

        int [] vetor1 = new int[qtd1];
        int [] vetor2 = new int[qtd2];
        int [] vetorResultado;
        if (qtd1 >= qtd2 ){
            qtdResultado = qtd2;
        }else{
            qtdResultado = qtd1;
        }
        vetorResultado = new int[qtdResultado];


        for (int i = 0; i < qtd1; i++) {          //preenchimento do primeiro vetor
            System.out.println("Digite o elemento " + (i+1) + " do primeiro vetor.");
            vetor1[i] = scanner.nextInt();
        }
        for (int i = 0; i < qtd2; i++) {           //preenchimento do segundo vetor
            System.out.println("Digite o elemento " + (i+1) + " do segundo vetor.");
            vetor2[i] = scanner.nextInt();
        }
        int k = 0;
        for (int i = 0; i < qtd1; i++) {                     //preenchimento do vetor Interseção (Resultado)
            for (int j = 0; j < qtd2; j++) {
                if (vetor1[i] == vetor2[j]){
                    if (checar(vetor1[i],vetorResultado, qtdResultado) == false) {
                        vetorResultado[k++] = vetor1[i];
                    }
                }
            }
        }
        System.out.println("Esse é o vetor formado pela interseção dos dois vetores: ");
        System.out.print(" Vetor Resultante = { ");
        for (int i = 0; i < qtdResultado; i++) {
            if (vetorResultado[i] == 0){
                System.out.print("");
            }else {
                System.out.print(vetorResultado[i]);
                System.out.print(", ");
            }
        }
        System.out.print("}");

        System.out.println();
        System.out.println("Esse é o vetor formado pela união dos dois vetores: ");
        System.out.print("Vetor Resultante = { ");
        int [] vetorUniao = new int[qtd1 + qtd2];

        for (int i = 0; i < vetor1.length; i++) {
            if (checar(vetor1[i], vetorUniao, k) == false)
                vetorUniao[i] = vetor1[i];
            k++;
        }
        for (int i = 0; i < vetor2.length; i++) {
            if(existe(vetor2[i], vetorUniao, k) == false){
                vetorUniao[k] = vetor2[i];
                k++;

            }
        }
        for (int i = 0; i < k; i++) {
            if (vetorUniao[i] == 0) {
                System.out.print("");
            }else{
                System.out.print(vetorUniao[i] + ", ");
            }
        }
        System.out.print("}");


    }
    private static boolean existe(int x, int [] vetorUniao, int k) {
        for (int i = 0; i < k; i++) {
            if (vetorUniao[i] == x ) {
                return true;
            }
        }
        return false;
    }
    private static boolean checar(int x, int [] vetor, int comp){
        for (int i = 0; i < comp; i++) {
            if (x == vetor[i]){
                return true;
            }
        }
        return false;
    }

}