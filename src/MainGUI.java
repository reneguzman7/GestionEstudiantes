import javax.swing.*;
import UI.CursosUI;
import UI.EstudiantesUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI mainGUI = new MainGUI();
            mainGUI.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Gestión de Estudiantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton estudiantesButton = new JButton("Estudiantes");
        JButton cursosButton = new JButton("Cursos");

        estudiantesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EstudiantesUI(); // Abre la interfaz de usuario de estudiantes
            }
        });

        cursosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CursosUI(); // Abre la interfaz de usuario de cursos
            }
        });

        panel.add(estudiantesButton);
        panel.add(cursosButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
    }
}

