package logico;

import java.util.*;

class Grafo {
    private Map<Character, List<Character>> listaAdyacencia;
    
    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }
    
    // Metodo para agregar un vertice, agregar una arista no dirigida, Agregar la arista en ambas direcciones
    public void agregarVertice(char vertice) {
        if (!listaAdyacencia.containsKey(vertice)) {
            listaAdyacencia.put(vertice, new ArrayList<>());
        }
    }
    
    public void agregarArista(char v1, char v2) {
        agregarVertice(v1);
        agregarVertice(v2);
        
        // Agregar la arista en ambas direcciones
        listaAdyacencia.get(v1).add(v2);
        listaAdyacencia.get(v2).add(v1);
    }
    
    // Método para calcular la secuencia de grados, Ordenar la secuencia en orden descendente y Calcular el grado de cada vértice
    public List<Integer> calcularSecuenciaGrados() {
        List<Integer> secuencia = new ArrayList<>();
        
        for (char vertice : listaAdyacencia.keySet()) {
            int grado = listaAdyacencia.get(vertice).size();
            secuencia.add(grado);
        }
        
        Collections.sort(secuencia, Collections.reverseOrder());
        return secuencia;
    }
    
    
    public void mostrarListaAdyacencia() {
        for (char vertice : listaAdyacencia.keySet()) {
            System.out.print(vertice + " -> ");
            List<Character> adyacentes = listaAdyacencia.get(vertice);
            for (int i = 0; i < adyacentes.size(); i++) {
                System.out.print(adyacentes.get(i));
                if (i < adyacentes.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        
        
        grafo.agregarArista('A', 'B');
        grafo.agregarArista('A', 'C');
        grafo.agregarArista('B', 'D');
        grafo.agregarArista('B', 'E');
        grafo.agregarArista('C', 'F');
        grafo.agregarArista('C', 'G');
        grafo.agregarArista('D', 'E');
        grafo.agregarArista('D', 'H');
        grafo.agregarArista('E', 'I');
        grafo.agregarArista('F', 'G');
        grafo.agregarArista('G', 'H');
        grafo.agregarArista('H', 'I');
        grafo.agregarArista('I', 'F');
        
        
        System.out.println("Secuencia de grados:");
        List<Integer> secuenciaGrados = grafo.calcularSecuenciaGrados();
        System.out.println(secuenciaGrados);
        
        
        System.out.println("\nLista de adyacencia:");
        grafo.mostrarListaAdyacencia();
    }
}
