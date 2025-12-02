//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Grafo grafo = new Grafo("DistSAMU_110.txt");

    grafo.imprimirMatrizDistancia();

    grafo.sortearNumeroValido();
}
