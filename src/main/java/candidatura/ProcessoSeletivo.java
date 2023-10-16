package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoCandidato();
        imprimirListaSelecionados();

        String[] cadidatos = {"Felipe","Vivi","Maria","Mõnica","Cascão"};
        for (String candidato: cadidatos){
            ligarCandidato(candidato);

        }


    }
    public static void ligarCandidato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando =! atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }else {
                System.out.println("CONTATO REALIZADO COM SUCESSO.");
            }

        }while (continuarTentando && tentativasRealizadas <3);

        if (atendeu){
            System.out.println("Conseguimos contato com  "+candidato+", na "+tentativasRealizadas+" tentativa");
        }else {
            System.out.println("Não conseguimos contato com  "+candidato);
        }

    }
    public static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    public static void imprimirListaSelecionados(){
        String[] cadidatos = {"Felipe","Vivi","Maria","Mõnica","Cascão"};
        for (int i = 0 ;i < cadidatos.length; i++){
            System.out.println("O candidato de n° "+(i+1)+": "+ cadidatos[i]);

        }

        for (String candidato : cadidatos) {

            System.out.println("O candidato selecionado foi: "+candidato);

        }
    }


    public static void selecaoCandidato(){
        String[] cadidatos = {"Felipe","Vivi","Maria","Mõnica","Cascão","Bidu","Cebolinha","Magali","Zóio","Cabeça","Jalo"};
        int cadidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (cadidatosSelecionados < 5 && candidatoAtual < cadidatos.length){
            String candidato = cadidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato "+candidato+", solicitou R$"+salarioPretendido+" de salário.");

            if (salarioPretendido <= salarioBase){
                System.out.println("O candidato "+candidato+", foi selecionado para entrevista.");
                cadidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    public static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800.0,2200.0);
    }
    public static void analizarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioPretendido < salarioBase){
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioPretendido == salarioBase) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }

    }
}