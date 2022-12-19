package frames;

import business.Predict;
import dataaccess.DbHelper;
import entities.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Guess extends javax.swing.JFrame {

    private ArrayList<Country> countries;
    private Predict predict;
    DefaultTableModel model;

    public Guess() {
        initComponents();
        populateTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCountries = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCountries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "NAME", "CODE", "2024", "2025", "2026", "2030", "2035", "2040"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCountries);
        if (tblCountries.getColumnModel().getColumnCount() > 0) {
            tblCountries.getColumnModel().getColumn(0).setResizable(false);
            tblCountries.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblCountries.getColumnModel().getColumn(1).setMinWidth(100);
            tblCountries.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblCountries.getColumnModel().getColumn(1).setMaxWidth(150);
            tblCountries.getColumnModel().getColumn(2).setResizable(false);
            tblCountries.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblCountries.getColumnModel().getColumn(3).setResizable(false);
            tblCountries.getColumnModel().getColumn(4).setResizable(false);
            tblCountries.getColumnModel().getColumn(5).setResizable(false);
            tblCountries.getColumnModel().getColumn(6).setResizable(false);
            tblCountries.getColumnModel().getColumn(7).setResizable(false);
            tblCountries.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        public void populateTable() {
        model = (DefaultTableModel) tblCountries.getModel();
        model.setRowCount(0);
        try {
            getCountries();
            predict = new Predict(countries);
            for (Country country : predict.getPredictCountries()) {
                Object[] row = {
                    country.getId(),
                    country.getName(),
                    country.getCode(),
                    country.getY2024(),
                    country.getY2025(),
                    country.getY2026(),
                    country.getY2030(),
                    country.getY2035(),
                    country.getY2040()};
                model.addRow(row);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void getCountries() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from population");
            countries = new ArrayList<Country>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("code"),
                        resultSet.getInt("2012"),
                        resultSet.getInt("2013"),
                        resultSet.getInt("2014"),
                        resultSet.getInt("2015"),
                        resultSet.getInt("2016"),
                        resultSet.getInt("2017"),
                        resultSet.getInt("2018"),
                        resultSet.getInt("2019"),
                        resultSet.getInt("2020"),
                        resultSet.getInt("2021")
                ));
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCountries;
    // End of variables declaration//GEN-END:variables
}
