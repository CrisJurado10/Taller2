import java.util.ArrayList;

public class Biblioteca {
    private int count = 0;
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public boolean agregarLibro(String nombre, int numPaginas) {
        // Verificar si un libro con el mismo nombre ya existe
        for (Libro libro : libros) {
            if (libro.getNombre().equals(nombre)) {
                return false; // Libro ya existe
            }
        }

        // Si no existe, agregarlo
        Libro l = new Libro(nombre, numPaginas);
        count++;
        l.setId(count);
        libros.add(l);
        return true; // Libro agregado exitosamente
    }

    public Libro buscarSecuencial(String nombre) {
        for (Libro libro : libros) {
            if (libro.getNombre().equals(nombre)) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarBinario(int id) {
        int left = 0;
        int right = libros.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (libros.get(mid).getId() == id) {
                return libros.get(mid);
            }
            if (libros.get(mid).getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Libro eliminarLibroPorNombre(String nombre) {
        for (Libro libro : libros) {
            if (libro.getNombre().equals(nombre)) {
                Libro l = libro;
                libros.remove(l);
                return l; // Libro eliminado exitosamente
            }
        }
        return null; // Libro no encontrado
    }

    public Libro eliminarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                Libro l = libro;
                libros.remove(l);
                return l; // Libro eliminado exitosamente
            }
        }
        return null; // Libro no encontrado
    }


    public int totalPaginas() {
        return totalPaginasRecursivo(0, 0);
    }

    public int totalPaginasRecursivo(int index, int total) {
        if (index == libros.size()) {
            return total;
        } else {
            return totalPaginasRecursivo(index + 1, total + libros.get(index).getNumPaginas());
        }
    }

    public ArrayList<Libro> generarLibros(){
        ArrayList<Libro> librosG = new ArrayList<>();

        //Libros generados
        Libro l1 = new Libro("Harry Potter", 1000);
        Libro l2 = new Libro("El diario de Greg", 390);
        Libro l3 = new Libro("La Biblia", 2918);
        Libro l4 = new Libro("El Huasipungo", 192);
        Libro l5 = new Libro("El diario de mi vida", 900);

        //Verificamos si esta libro
        if(agregarLibro(l1.getNombre(), l1.getNumPaginas())){
            if(buscarSecuencial(l1.getNombre()) != null){
                //Agregamos al arrayList al libro encontrado
                librosG.add(buscarSecuencial(l1.getNombre()));
            }
        }
        if(agregarLibro(l2.getNombre(), l2.getNumPaginas())){
            if(buscarSecuencial(l2.getNombre()) != null){
                librosG.add(buscarSecuencial(l2.getNombre()));
            }
        }
        if(agregarLibro(l3.getNombre(), l3.getNumPaginas())){
            if(buscarSecuencial(l3.getNombre()) != null){
                librosG.add(buscarSecuencial(l3.getNombre()));
            }
        }
        if(agregarLibro(l4.getNombre(), l4.getNumPaginas())){
            if(buscarSecuencial(l4.getNombre()) != null){
                librosG.add(buscarSecuencial(l4.getNombre()));
            }
        }
        if(agregarLibro(l5.getNombre(), l5.getNumPaginas())){
            if(buscarSecuencial(l5.getNombre()) != null){
                librosG.add(buscarSecuencial(l5.getNombre()));
            }
        }
        return librosG;
    }

}
