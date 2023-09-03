package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import BusinessLogic.Curso;

public class CursosUI extends JFrame {
    private JTable table;

    public CursosUI(List<Curso> cursos) {
        setTitle("Tabla de Cursos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Nombre", "Descripción"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Curso curso : cursos) {
            Object[] rowData = {curso.getId(), curso.getNombre(), curso.getDescripcion()};
            model.addRow(rowData);
        }

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);
        setVisible(true);
    }
}
