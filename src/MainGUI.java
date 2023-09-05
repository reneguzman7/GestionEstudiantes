import javax.swing.*;
import UI.CursosUI;
import UI.EstudiantesUI;
import UI.InscripcionesUI;

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
        JButton inscripcionesButton = new JButton("Inscripciones"); // Add the button for Inscripciones

        estudiantesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EstudiantesUI(); // Open the EstudiantesUI interface
            }
        });

        cursosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CursosUI(); // Open the CursosUI interface
            }
        });

        inscripcionesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add the code to open the InscripcionesUI interface or navigate to the Inscripciones table
                new InscripcionesUI();
            }
        });

        panel.add(estudiantesButton);
        panel.add(cursosButton);
        panel.add(inscripcionesButton); // Add the Inscripciones button to the panel

        frame.add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

}

