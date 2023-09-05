//package UI;
//
//import BusinessLogic.Estudiante;
//import BusinessLogic.Inscripcion;
//import DataBase.GestionEstudianteDTO;
//import DataBase.GestionInscripcionDTO;
//import Framework.AppException;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class InscripcionesUI extends JFrame {
//    private JTable table;
//    private int currentPage = 1;
//    private int pageSize = 10; // Cantidad de registros por página
//    private int totalPages;
//    private GestionInscripcionDTO gestionInscripcionDTO = new GestionInscripcionDTO();
//
//    public InscripcionesUI() {
//        // Configurar la ventana principal
//        setTitle("Tabla de Inscripciones");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//
//        String[] columnNames = {"ID", "Nombre", "Edad"};
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        table = new JTable(model);
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        panel.add(scrollPane, BorderLayout.CENTER);
//
//        // Botones de paginación
//        JButton prevPageButton = new JButton("Página Anterior");
//        JButton nextPageButton = new JButton("Página Siguiente");
//
//        prevPageButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (currentPage > 1) {
//                    currentPage--;
//                    loadTableData(model);
//                }
//            }
//        });
//
//        nextPageButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                if (currentPage < totalPages) {
//                    currentPage++;
//                    loadTableData(model);
//                }
//            }
//        });
//
//        JPanel paginationPanel = new JPanel(new FlowLayout());
//        paginationPanel.add(prevPageButton);
//        paginationPanel.add(nextPageButton);
//        panel.add(paginationPanel, BorderLayout.SOUTH);
//
//        getContentPane().add(panel);
//        setVisible(true);
//
//        // Calcular el número total de páginas
//        try {
//            int totalRecords = gestionInscripcionDTO.countInscripciones();
//            totalPages = (int) Math.ceil((double) totalRecords / pageSize);
//        } catch (AppException e) {
//            e.printStackTrace();
//        }
//
//        // Cargar los datos de la página actual
//        loadTableData(model);
//    }
//
//    // Método para cargar los datos de la página actual en la tabla
//    private void loadTableData(DefaultTableModel model) {
//        model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
//        try {
//            List<Inscripcion> estudiantes = gestionInscripcionDTO.cargarInscripciones(currentPage - 1, pageSize);
//            for (Inscripcion estudiante : estudiantes) {
//                Object[] rowData = {estudiante.getId(), estudiante.getNombre(), estudiante.getEdad()};
//                model.addRow(rowData);
//            }
//        } catch (AppException e) {
//            e.printStackTrace();
//        }
//    }
//}
