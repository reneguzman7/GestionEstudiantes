import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.Curso;
import BusinessLogic.Estudiante;
import Framework.AppException;
import UI.CursosUI;
import UI.EstudiantesUI;
import DataBase.GestionEstudianteDTO;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class MainGUI {
    private DefaultTableModel tableModel; // Variable para el modelo de la tabla
    private JTable table; // Variable para la tabla
    

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

        JButton estudiantesButton = new JButton("Tabla de Estudiantes");
        JButton cursosButton = new JButton("Tabla de Cursos");

        estudiantesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GestionEstudianteDTO gestionEstudianteDTO = new GestionEstudianteDTO();
                    List<Estudiante> estudiantes = gestionEstudianteDTO.cargarEstudiantes();

                    // Crear una matriz de datos para la tabla
                    Object[][] data = new Object[estudiantes.size()][3]; // 3 columnas para id, nombre y edad

                    for (int i = 0; i < estudiantes.size(); i++) {
                        Estudiante estudiante = estudiantes.get(i);
                        data[i][0] = estudiante.getId();
                        data[i][1] = estudiante.getNombre();
                        data[i][2] = estudiante.getEdad();
                    }

                    // Actualizar el modelo de la tabla con los nuevos datos
                    tableModel.setDataVector(data, new String[]{"ID", "Nombre", "Edad"});
                } catch (AppException ex) {
                    ex.printStackTrace();
                    // Manejar la excepción si ocurre algún error
                }
            }
        });

        cursosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    GestionEstudianteDTO gestionEstudianteDTO = new GestionEstudianteDTO();
                    List<Curso> cursos = gestionEstudianteDTO.cargarCursos();

                    // Crear una matriz de datos para la tabla
                    Object[][] data = new Object[cursos.size()][3]; // 3 columnas para id, nombre y descripción

                    for (int i = 0; i < cursos.size(); i++) {
                        Curso curso = cursos.get(i);
                        data[i][0] = curso.getId();
                        data[i][1] = curso.getNombre();
                        data[i][2] = curso.getDescripcion();
                    }

                    // Actualizar el modelo de la tabla con los nuevos datos
                    tableModel.setDataVector(data, new String[]{"ID", "Nombre", "Descripción"});
                } catch (AppException ex) {
                    ex.printStackTrace();
                    // Manejar la excepción si ocurre algún error
                }
            }
        });

        panel.add(estudiantesButton);
        panel.add(cursosButton);

        // Crear el modelo de la tabla vacío
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Nombre", "Edad"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
