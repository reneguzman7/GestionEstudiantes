package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import BusinessLogic.Curso;
import DataBase.GestionEstudianteDTO;import Framework.AppException;



public class CursosUI extends JFrame {
    private JTable table;
    private int currentPage = 1;
    private int pageSize = 10; // Cantidad de registros por página
    private int totalPages;
    private GestionEstudianteDTO gestionEstudianteDTO = new GestionEstudianteDTO();

    public CursosUI() {
        setTitle("Tabla de Cursos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Nombre", "Descripción"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Botones de paginación
        JButton prevPageButton = new JButton("Página Anterior");
        JButton nextPageButton = new JButton("Página Siguiente");

        prevPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    loadTableData(model);
                }
            }
        });

        nextPageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentPage < totalPages) {
                    currentPage++;
                    loadTableData(model);
                }
            }
        });

        JPanel paginationPanel = new JPanel(new FlowLayout());
        paginationPanel.add(prevPageButton);
        paginationPanel.add(nextPageButton);
        panel.add(paginationPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
        setVisible(true);

        // Calcular el número total de páginas
        try {
            int totalRecords = gestionEstudianteDTO.countCursos();
            totalPages = (int) Math.ceil((double) totalRecords / pageSize);
        } catch (AppException e) {
            e.printStackTrace();
        }

        // Cargar los datos de la página actual
        loadTableData(model);
    }

    // Método para cargar los datos de la página actual en la tabla
    private void loadTableData(DefaultTableModel model) {
        model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
        try {
            List<Curso> cursos = gestionEstudianteDTO.cargarCursos(currentPage - 1, pageSize);
            for (Curso curso : cursos) {
                Object[] rowData = {curso.getId(), curso.getNombre(), curso.getDescripcion()};
                model.addRow(rowData);
            }
        } catch (AppException e) {
            e.printStackTrace();
        }
    }
}
