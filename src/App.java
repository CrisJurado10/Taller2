import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton agregarBtn;
    private JButton eliminarLibroButton;
    private JTextField textField3;
    private JButton buscarButton;
    private JTextField textField4;
    private JButton buscarButton1;
    private JTextArea textArea1;
    private JTextField textField5;
    private JTextField textField6;
    private JButton eliminarButton;
    private JTextArea textArea2;
    private JButton calcularButton;
    private JTextArea textArea3;
    private JButton generarButton;
    private JTextArea textArea4;
    private Biblioteca b = new Biblioteca();

    public App() {
        setContentPane(panel1);

        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });
        eliminarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibroNombre();
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibroId();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorNombre();
            }
        });
        buscarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorId();
            }
        });
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarLibros();
            }
        });
    }

    //Funciones
    public void agregarLibro() {
        if (b.agregarLibro(textField1.getText(), Integer.parseInt(textField2.getText()))) {
            JOptionPane.showMessageDialog(null, "Se ha agregado el libro correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Erro. Ya se ha agregado este libro.");
        }
    }

    public void eliminarLibroNombre() {
        Libro l = b.eliminarLibroPorNombre(textField5.getText());
        if (l != null) {
            textArea1.setText(l.toString());
        } else {
            textArea1.setText("No se ha encontrado ningun libro con ese nombre.");
        }
    }

    public void eliminarLibroId() {
        Libro l = b.eliminarLibroPorId(Integer.parseInt(textField6.getText()));
        if (l != null) {
            textArea1.setText("Se ha eliminado el libro: \n" + l.toString());
        } else {
            textArea1.setText("No se ha encontrado ningun libro con ese nombre.");
        }
    }

    public void buscarPorNombre() {
        Libro l = b.buscarSecuencial(textField3.getText());
        if (l != null) {
            textArea2.setText(l.toString());
        } else {
            textArea2.setText("No se ha encontrado ningun libro con ese nombre.");
        }
    }

    public void buscarPorId() {
        Libro l = b.buscarBinario(Integer.parseInt(textField4.getText()));
        if (l != null) {
            textArea2.setText(l.toString());
        } else {
            textArea2.setText("No se ha encontrado ningun libro con ese id.");
        }
    }

    public void calcular() {
        textArea3.setText("Este es el numero total de paginas en la biblioteca: " + String.valueOf(b.totalPaginas()));
    }

    public void generarLibros() {
        String text = "Los libros que se han generado son: \n";
        for (Libro libro : b.generarLibros()) {
            text += libro.toString() + "\n";
        }
        textArea4.setText(text);
    }
}
