package Etapa3;

public class PrincipalEtapa3 {
    public static void main(String[] args) {
        // Teste 1: Contar elementos em uma lista estática usando recursão
        System.out.println("Teste 1: Contagem de Elementos em uma Lista Estática");
        StaticList<String> lista = new StaticList<>(10);
        lista.insert("a", 0);
        lista.insert("b", 1);
        lista.insert("a", 2);
        lista.insert("d", 3);
        lista.insert("a", 4);

        int contagem = lista.contaElementos("a");
        System.out.println("O elemento 'a' aparece " + contagem + " vezes na lista.");
        System.out.println("---------------------------------------------------");

        // Teste 2: Verificação de parênteses agrupados corretamente
        System.out.println("Teste 2: Verificação de Parênteses Agrupados");
        Stack<Character> pilha = new StaticStack<>(5);
        pilha.push('(');
        pilha.push('A');
        pilha.push('+');
        pilha.push('B');
        pilha.push(')');

        Etapa3 etapa3 = new Etapa3();
        boolean resultado = etapa3.checkBrackets(pilha);

        System.out.println("A expressão tem parênteses agrupados corretamente? " + resultado);
        System.out.println("---------------------------------------------------");
    }
}


