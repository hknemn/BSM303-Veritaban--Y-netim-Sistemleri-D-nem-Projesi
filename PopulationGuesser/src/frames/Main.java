package frames;

import dataaccess.DbHelper;
import entities.Country;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Main extends javax.swing.JFrame {
    
    private ArrayList<Country> countries;
    DefaultTableModel model;

    public Main() {
        initComponents();
        populateTable();
    }

    public void populateTable() {
        model = (DefaultTableModel) tblCountries.getModel();
        model.setRowCount(0);
        try {
            getCountries();
            for (Country country : countries) {
                Object[] row = {
                    country.getId(),
                    country.getName(),
                    country.getCode(),
                    country.getY2012(),
                    country.getY2013(),
                    country.getY2014(),
                    country.getY2015(),
                    country.getY2016(),
                    country.getY2017(),
                    country.getY2018(),
                    country.getY2019(),
                    country.getY2020(),
                    country.getY2021()
                };
                model.addRow(row);
            }
        } catch (SQLException exception) {

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCountries = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        lblTopic = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCountries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "NAME", "CODE", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCountries.getTableHeader().setReorderingAllowed(false);
        tblCountries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCountriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCountries);
        if (tblCountries.getColumnModel().getColumnCount() > 0) {
            tblCountries.getColumnModel().getColumn(0).setResizable(false);
            tblCountries.getColumnModel().getColumn(0).setPreferredWidth(25);
            tblCountries.getColumnModel().getColumn(1).setMinWidth(100);
            tblCountries.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblCountries.getColumnModel().getColumn(1).setMaxWidth(150);
            tblCountries.getColumnModel().getColumn(2).setResizable(false);
            tblCountries.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblCountries.getColumnModel().getColumn(3).setResizable(false);
            tblCountries.getColumnModel().getColumn(4).setResizable(false);
            tblCountries.getColumnModel().getColumn(5).setResizable(false);
            tblCountries.getColumnModel().getColumn(6).setResizable(false);
            tblCountries.getColumnModel().getColumn(7).setResizable(false);
            tblCountries.getColumnModel().getColumn(8).setResizable(false);
            tblCountries.getColumnModel().getColumn(9).setResizable(false);
            tblCountries.getColumnModel().getColumn(10).setResizable(false);
            tblCountries.getColumnModel().getColumn(11).setResizable(false);
            tblCountries.getColumnModel().getColumn(12).setResizable(false);
        }

        lblSearch.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        lblSearch.setText("Search");
        lblSearch.setToolTipText("");

        txtSearch.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        txtSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel1.setText("2012-2021 World Population");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(548, 548, 548)
                        .addComponent(lblTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTopic)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchKey = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tblCountries.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblCountriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCountriesMouseClicked

    }//GEN-LAST:event_tblCountriesMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTopic;
    private javax.swing.JTable tblCountries;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
