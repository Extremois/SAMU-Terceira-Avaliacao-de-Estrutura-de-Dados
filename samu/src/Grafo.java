import java.io.BufferedReader;
import java.io.FileReader;

public class Grafo {
    private final int[][] matrizDist;

    public Grafo(String caminho) {
        try{
            this.matrizDist = lerArquivoMatriz(caminho);
        }catch (IllegalArgumentException exception){
            throw new IllegalArgumentException("Erro ao ler o arquivo de matriz: " + exception.getMessage());
        }
    }

    private int[][] lerArquivoMatriz(String caminho) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            // Ler o número de vértices (primeira linha)
            String primeiraLinha = br.readLine();
            int numVertices = Integer.parseInt(primeiraLinha.trim());

            // Criar a matriz
            int[][] matrizInicializada = new int[numVertices][numVertices];

            // Ler cada linha da matriz
            int linhaAtual = 0;
            String linha;

            while ((linha = br.readLine()) != null && linhaAtual < numVertices) {
                String[] valores = linha.trim().split("\\s+");

                int colunaAtual = 0;
                for (String valor : valores) {
                    int v = Integer.parseInt(valor);

                    // Parar quando encontrar -1 (fim da linha)
                    if (v == -1) {
                        break;
                    }

                    if (colunaAtual < numVertices) {
                        matrizInicializada[linhaAtual][colunaAtual] = v;
                        colunaAtual++;
                    }
                }
                linhaAtual++;
            }
            return matrizInicializada;
        } catch (Exception exception) {
           throw new IllegalArgumentException(exception);
        }
    }

    public void imprimirMatrizDistancia() {
        if (this.matrizDist == null) {
            System.out.println("Matriz não carregada!");
            return;
        }

        int n = matrizDist.length;

        System.out.println("\n=== Matriz de Adjacência ===");
        System.out.println("Dimensão: " + n + "x" + n);
        System.out.println();

        // Cabeçalho com índices das colunas
        System.out.print("      ");
        for (int j = 0; j < n; j++) {
            System.out.printf("%6d ", j);
        }
        System.out.println();
        System.out.println("      " + "-".repeat(n * 7));

        // Linhas da matriz
        for (int i = 0; i < n; i++) {
            System.out.printf("%4d | ", i);
            for (int j = 0; j < n; j++) {
                if (this.matrizDist[i][j] == 9999) {
                    System.out.print("   INF ");
                } else {
                    System.out.printf("%6d ", this.matrizDist[i][j]);
                }
            }
            System.out.println();
        }
    }

    public int sortearNumeroValido(){
        int[] verticesEspeciais = {83, 82, 40, 19};
        boolean valido;
        int numero;
        do {
            valido = true;

            numero = (int) (Math.random()*110);

            for (int i : verticesEspeciais) {
                if (i == numero) {
                    valido = false;
                    break;
                }
            }
        }while(!valido);

        System.out.println("Numero valido: " + numero);

        return numero;
    }

}