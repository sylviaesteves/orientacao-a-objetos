import com.orientacaoobjetos.entity.Carro;
import java.util.Scanner;

public class OrientacaoAObjetos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int qtdCarros;

        do{
            System.out.print("Digite a quantidade de carros que vc deseja inserir (Max. 50): ");
            qtdCarros = sc.hasNextInt() ? sc.nextInt() : -1;
            if(qtdCarros < 1 || qtdCarros > 50){
                System.out.println("#".repeat(50) +
                        "\nEntrada inválida. Digite um valor entre 1 e 50.\n" + "#".repeat(50));
                sc.nextLine();
            }
            sc.nextLine();
        }while(qtdCarros < 1 || qtdCarros > 50);
        
        Carro[] listaDeCarros = preencherLista(qtdCarros, sc);
        sc.close();

        System.out.println("Quantidade de carros inseridos: " + qtdCarros);
        for (int i = 0; i < qtdCarros; i++) {
            System.out.println(listaDeCarros[i]);
        }
    }

    private static Carro[] preencherLista(int qtdCarros, Scanner sc) {

        Carro[] listaDeCarros = new Carro[qtdCarros];
        String nome;
        double preco;

        System.out.println("-".repeat(65));
        System.out.println("INSIRA OS DADOS DO(S) CARRO(S)");
        for (int i = 0; i < qtdCarros; i++) {
            System.out.println("CARRO " + (i+1) + ":");
            System.out.print("\tNome: ");
            nome = sc.nextLine();
            System.out.print("\tPreço: ");
            while(!sc.hasNextDouble()){
                System.out.println("\t## Valor inválido ##");
                sc.nextLine();
                System.out.print("\tPreço: ");
            }
            preco = sc.nextDouble();
            sc.nextLine();
            listaDeCarros[i] = new Carro(nome, preco);
        }
        System.out.println("-".repeat(65));
        return listaDeCarros;
    }
}
