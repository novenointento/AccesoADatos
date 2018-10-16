package Persona;


import java.io.File;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 *
 * @author silvia
 */
public class ListaDeObjetos {

    // ATRIBUTOS
    private List lista;

    // METODOS
    public ListaDeObjetos() {
        lista = new LinkedList();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaDeObjetos other = (ListaDeObjetos) obj;
        if (!Objects.equals(this.lista, other.lista)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.lista);
        return hash;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    public List getLista() {
        return lista;
    }

    // CSV
    public void anadirObjetosDeFicheroCSV(File fichero, String separador) {
        FicheroDeTexto gestorFichero = new FicheroDeTexto(fichero);
        List lineas = new LinkedList();

        gestorFichero.abrirLector();
        lineas = gestorFichero.guardarLineasCSVEnColeccion();
        gestorFichero.cerrarLector();

        for (Object linea : lineas) {
            PersonaEjemplo persona = convertirLineaEnObjeto(linea.toString(), separador);
            if (persona != null) {
                lista.add(persona);
            }
        }
    }

    public void grabarObjetosEnFicheroCSV(File fichero, String separador, boolean anadir) {
        FicheroDeTexto gestorFichero = new FicheroDeTexto(fichero);
        gestorFichero.abrirEscritor(anadir);
        for (Object objeto : lista) {
            PersonaEjemplo persona = (PersonaEjemplo) objeto;
            gestorFichero.print(convertirPersonaEnLinea(persona, separador) + "\n");
        }
        gestorFichero.cerrarEscritor();
    }

    // LISTA
    public void verObjetosDeLista(String separador) {
        for (Object objeto : lista) {
            PersonaEjemplo persona = (PersonaEjemplo) objeto;
            System.out.print(convertirPersonaEnLinea(persona, separador) + "\n");
        }
    }

    public int contarElementos() {
        return lista.size();
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    // AÑADIR
    public boolean anadirObjetoAlFinal(PersonaEjemplo persona) {
        return lista.add(persona);
    }

    public void anadirObjeto(PersonaEjemplo persona, int posicion) {
        lista.add(posicion, persona);
    }

    // QUITAR
    public boolean borrarTodos(Collection coleccion) {
        if (coleccion.size() > 0) {
            return lista.removeAll(coleccion);
        } else {
            return false;
        }
    }

    public void borrarObjeto(PersonaEjemplo persona) {
        lista.remove(persona);
    }

    public void borrarObjeto(int posicion) {
        lista.remove(posicion);
    }

    public void vaciarLista() {
        lista.clear();
    }

    // ORDENAR
    public void ordenarLista(Comparator c) {
        lista.sort(c);
    }
    
    public void ordenarNumerosDePersonas(){
        for(Object persona : lista){
            ((PersonaEjemplo) persona).ordenarNumeros();
        }
    }

    // BUSCAR
    public boolean contiene(PersonaEjemplo persona) {
        return lista.contains(persona);
    }

    public int cuantosHay(PersonaEjemplo persona) {
        int contador = 0;
        PersonaEjemplo p;
        if (lista.contains(persona)) {
            for (Object objeto : lista) {
                p = (PersonaEjemplo) objeto;
                if (p.equals(persona)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public PersonaEjemplo buscar(int posicion) {
        return (PersonaEjemplo) lista.get(posicion);
    }

    public PersonaEjemplo buscarPrimero(PersonaEjemplo persona) {
        if (lista.contains(persona)) {
            return (PersonaEjemplo) lista.get(lista.indexOf(persona));
        } else {
            return null;
        }
    }

    public PersonaEjemplo buscarUltimo(PersonaEjemplo persona) {
        if (lista.contains(persona)) {
            return (PersonaEjemplo) lista.get(lista.lastIndexOf(persona));
        } else {
            return null;
        }
    }

    public List buscarTodos(PersonaEjemplo persona) {
        List encontrados = new LinkedList();
        PersonaEjemplo p;
        if (lista.contains(persona)) {
            for (Object objeto : lista) {
                p = (PersonaEjemplo) objeto;
                if (p.equals(persona)) {
                    encontrados.add(p);
                }
            }
        }
        return encontrados;
    }

    public List buscarTodosConNombre(String nombre) {
        List encontrados = new LinkedList();
        PersonaEjemplo persona;
        for (Object objeto : lista) {
            persona = (PersonaEjemplo) objeto;
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(persona);
            }
        }
        return encontrados;
    }

    public List buscarTodosConApellido(String apellido) {
        List encontrados = new LinkedList();
        PersonaEjemplo persona;
        for (Object objeto : lista) {
            persona = (PersonaEjemplo) objeto;
            if (persona.getApellido().equalsIgnoreCase(apellido)) {
                encontrados.add(persona);
            }
        }
        return encontrados;
    }

    //COLECCION DE NUMEROS
    public Integer total() {
        int total = 0;
        for (Object numero : lista) {
            total += (Integer) numero;
        }
        return total;
    }

    public Integer media() {
        int total = 0;
        for (Object numero : lista) {
            total += (Integer) numero;
        }
        return total / lista.size();
    }

    public Integer mayor() {
        int mayor = 0;
        for (Object numero : lista) {
            if (mayor < (Integer) numero) {
                mayor = (Integer) numero;
            }
        }
        return mayor;
    }
    
    public Integer menor() {
        int menor = 0;
        for (Object numero : lista) {
            if (menor > (Integer) numero) {
                menor = (Integer) numero;
            }
        }
        return menor;
    }

    // GESTION DEL OBJETO
    public PersonaEjemplo convertirLineaEnObjeto(String linea, String separador) {
        StringTokenizer tokenizador = new StringTokenizer(linea, separador);
        PersonaEjemplo persona = new PersonaEjemplo();
        if (tokenizador.countTokens() < 3) {
            return null;
        } else {
            persona.setNombre(tokenizador.nextToken().trim());
            persona.setApellido(tokenizador.nextToken().trim());
            while (tokenizador.hasMoreTokens()) {
                persona.getNumeros().add(Integer.parseInt(tokenizador.nextToken().trim()));
            }
        }
        return persona;
    }

    public String convertirPersonaEnLinea(PersonaEjemplo persona, String separador) {
        String linea = "";
        linea += persona.getNombre();
        linea += separador + persona.getApellido();
        for (Object numero : persona.getNumeros()) {
            linea += separador + numero.toString();
        }
        return linea;
    }

}
