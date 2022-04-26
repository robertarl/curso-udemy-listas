package aplicacao;

import entidades.Empregados;

import java.util.*;

public class Programa {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Empregados> empregados = new ArrayList<>();

        // PARTE 1 - Lendo os dados do empregado:

        System.out.print("Quantos funcionários serão cadastrados? ");
        int func = sc.nextInt();

        for (int i=1; i<=func; i++){
            System.out.println();
            System.out.println("Empregado #" + i + ": ");

            System.out.print("Id: ");
            int id = sc.nextInt();
            while (hasId(empregados, id)) {
                System.out.print("Id already taken. Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Salario: ");
            double salario = sc.nextDouble();
            empregados.add(new Empregados(id, nome, salario));
        }

        // PARTE 2 - Atualização do salário do empregado

        System.out.println();
        System.out.print("Insira o id do funcionário que terá aumento salarial: ");
        int id = sc.nextInt();

        Empregados emp = empregados.stream().filter(x -> x.getId() == id ).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This id does not exist!");
        }
        else{
            System.out.print("Digite a porcentagem: ");
            double porcentagem = sc.nextDouble();
            emp.aumentaSalario(porcentagem);
        }

        // PART 3 - Lista de funcionários:

        System.out.println();
        System.out.println("Lista de funcionários:");
        for (Empregados obj : empregados) {
            System.out.println(obj);
        }
        sc.close();
    }
    public static boolean hasId(List<Empregados> empregados, int id) {
        Empregados emp = empregados.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
