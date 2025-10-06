import com.orientacaoobjetos.entity.Aluno;

import java.util.Scanner;

public class OrientacaoAObjetos {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Aluno[] alunos = new Aluno[100];
        boolean quit = false;
        String input;

        while (!quit){
            printMenu();
            System.out.print("CMD: ");
            input = sc.nextLine();
            switch (input){
                case "1":{
                    cadastroAlunos(alunos);
                    break;
                }
                case "2":{
                    consultaAlunos(alunos);
                    break;
                }
                case "3":{
                    quit = true;
                    break;
                }
                default:{
                    System.out.println("** COMANDO INVÁLIDO **");
                }
            }
        }
        sc.close();
    }

    private static void printMenu(){
        System.out.println("""
                  
                  //////////////////////////////////////////////////
                 //              CADASTRO DE ALUNOS              //
                //////////////////////////////////////////////////
                (1)Cadastrar Alunos (2)Consultar Alunos (3)Sair
                """);
    }

    private static void cadastroAlunos(Aluno[] alunos) throws Exception {

        String nome;
        String dataNascimento;
        String serie;
        int index = contagemAlunos(alunos);

        //System.out.println("-".repeat(50));
        System.out.println("TOTAL DE ALUNOS CADASTRADOS (Max 100): " + index);
        System.out.print("Digite quantos alunos deseja cadastar: ");
        int entrada = sc.hasNextInt() ? sc.nextInt() : -1;
        sc.nextLine();
        if(entrada < 0){
            System.out.println("*** ENTRADA INVÁLIDA ***");
            cadastroAlunos(alunos);
        } else if ((contagemAlunos(alunos) + entrada) > 100){
            System.out.println("*** O NÚMERO EXCEDE O LIMITE (100) ***");
            cadastroAlunos(alunos);
        } else {
            for (int i = 0; i < entrada; i++) {
                System.out.println("-".repeat(30));
                System.out.println("ENTRADA (" + (i+1) + ")");
                System.out.print("NOME: ");
                nome = sc.nextLine();
                System.out.print("DATA NASCIMENTO (YYYY/MM/DD): ");
                dataNascimento = sc.nextLine();
                System.out.print("SERIE: ");
                serie = sc.nextLine();

                try {
                    alunos[index + i] = new Aluno(nome, dataNascimento, serie);
                    inserirNotas(alunos[index + i].getNotas());
                } catch(Exception e){
                    System.out.println("#### ERRO : " + e + " ####");
                    System.out.println("### CRIAÇÃO ABORTADA ####");
                    break;
                }
            }
        }
    }

    private static void consultaAlunos(Aluno[] alunos) {

        System.out.println("TOTAL DE ALUNOS CADASTRADOS: " + contagemAlunos(alunos));

        for (int i = 0; i < contagemAlunos(alunos); i++){
            System.out.println("-------------------------" );
            System.out.println(alunos[i]);
            System.out.println("| NOTAS: ");
            for (int j = 0; j < 4; j++) {
                System.out.println("|\tTRIMESTRE " + (j+1) +
                        ": " + alunos[i].getNotas()[j]);
            }
            System.out.println("|\tMÉDIA: " + alunos[i].calcularMedia());
            System.out.println("-------------------------" );
        }

    }

    private static void inserirNotas(double[] notas){

        System.out.println("\tINSIRA AS NOTAS: ");
        for (int i = 0; i < notas.length;) {
            System.out.print("\tNota Semetre " + (i + 1) + ": ");
            if(sc.hasNextDouble()){
                notas[i] = sc.nextDouble();
                i++;
            } else{
                System.out.println("*** Nota inválida ***");
            }
            sc.nextLine();
        }
    }

    private static int contagemAlunos(Aluno[] alunos){

        int contador = 0;
        for (Aluno aluno : alunos) {
            if (aluno != null)
                contador++;
        }
        return contador;
    }
}
