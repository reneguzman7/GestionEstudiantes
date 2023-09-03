package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import BusinessLogic.Estudiante;

public class EstudiantesUI extends JFrame {
    private JTable table;

    public EstudiantesUI(List<Estudiante> estudiantes) {
        setTitle("Tabla de Estudiantes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Nombre", "Edad"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Estudiante estudiante : estudiantes) {
            Object[] rowData = {estudiante.getId(), estudiante.getNombre(), estudiante.getEdad()};
            model.addRow(rowData);
        }

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);
        setVisible(true);
        
    }
}
