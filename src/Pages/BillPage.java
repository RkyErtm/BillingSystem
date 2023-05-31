/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages;

import DatabaseConnection.DBConnect;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VKFGLB
 */
public class BillPage extends javax.swing.JFrame {

    Connection conn = null;
    Statement st;
    Object billtype;
    int urunId;
    int musteriId;
    int toplam;
    int spinnerValue;

    public BillPage() {
        initComponents();
        listeleMusteriler();
        listUrunFatura();
        jComboBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    billtype = event.getItem();
                    System.out.println("Seçilen değer: " + billtype);
                }
            }
        });
    }

    private void getSelectedComboBoxValue() {
        String selectedValue = jComboBox1.getSelectedItem().toString();
        System.out.println("Seçilen değer: " + selectedValue);
    }

    private void clearTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public void listeleMusteriler() {
        DefaultTableModel model = (DefaultTableModel) FaturaMusteriTable.getModel();
        model.setRowCount(0); // Tabloyu temizle

        try {
            conn = DBConnect.connect();
            String Listquery = "SELECT * FROM public.\"Musteriler\"";
            PreparedStatement pst = conn.prepareStatement(Listquery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("Id"));
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String email = rs.getString("email");
                String adres = rs.getString("adres");
                String cinsiyet = rs.getString("cinsiyet");
                String tcNo = rs.getString("tcNo");
                String telefon = rs.getString("telefon");

                String dataTable[] = {id, ad, soyad, email, adres, cinsiyet, tcNo, telefon};
                model.addRow(dataTable); // Müşteriyi tabloya ekle
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void listUrunFatura() {
        try {
            clearTable(FaturaUrunTable);
            conn = DBConnect.connect();
            String listQuery = "SELECT * FROM public.\"Urunler\"";
            PreparedStatement pstList = conn.prepareStatement(listQuery);
            ResultSet rs = pstList.executeQuery();

            while (rs.next()) {
                int urunId = rs.getInt("Id");
                String urunAdi = rs.getString("urunAdi");
                int urunFiyat = rs.getInt("fiyat");
                int urunAdet = rs.getInt("adet");
                int urunKategori = rs.getInt("kategori");

                String kategoriAdi = "";
                String kategoriQuery = "SELECT * FROM public.\"Kategoriler\" WHERE \"Id\" = ?";
                PreparedStatement pstKategori = conn.prepareStatement(kategoriQuery);
                pstKategori.setInt(1, urunKategori);
                ResultSet kategoriRs = pstKategori.executeQuery();
                if (kategoriRs.next()) {
                    kategoriAdi = kategoriRs.getString("ad");
                }

                String[] dataTable = {String.valueOf(urunId), urunAdi, String.valueOf(urunFiyat), String.valueOf(urunAdet), kategoriAdi};
                DefaultTableModel model = (DefaultTableModel) FaturaUrunTable.getModel();
                model.addRow(dataTable);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void seciliMusteriYazdir() {
        int selectedRow = FaturaMusteriTable.getSelectedRow();
        if (selectedRow != -1) {
            String id = FaturaMusteriTable.getValueAt(selectedRow, 0).toString();
            musteriId = Integer.parseInt(id);
            String ad = FaturaMusteriTable.getValueAt(selectedRow, 1).toString();
            String soyad = FaturaMusteriTable.getValueAt(selectedRow, 2).toString();
            String email = FaturaMusteriTable.getValueAt(selectedRow, 3).toString();
            String adres = FaturaMusteriTable.getValueAt(selectedRow, 4).toString();
            String cinsiyet = FaturaMusteriTable.getValueAt(selectedRow, 5).toString();
            String tcNo = FaturaMusteriTable.getValueAt(selectedRow, 6).toString();
            String telefon = FaturaMusteriTable.getValueAt(selectedRow, 7).toString();

            txt_faturaAd.setText(ad);
            txt_faturaSoyad.setText(soyad);
            txt_faturaEmail.setText(email);
            txt_faturaAdres.setText(adres);
            txt_faturaCinsiyet.setText(cinsiyet);
            txt_faturaTcNo.setText(tcNo);
            txt_faturaTel.setText(telefon);
        } else {
            JOptionPane.showMessageDialog(null, "müşteri seçilemedi.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel22 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        musteriPane = new javax.swing.JScrollPane();
        FaturaMusteriTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        FaturaUrunTable = new javax.swing.JTable();
        Ad = new javax.swing.JLabel();
        txt_faturaAd = new javax.swing.JTextField();
        txt_faturaSoyad = new javax.swing.JTextField();
        Soyad = new javax.swing.JLabel();
        txt_faturaEmail = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        Cinsiyet = new javax.swing.JLabel();
        txt_faturaCinsiyet = new javax.swing.JTextField();
        txt_faturaTcNo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_faturaTel = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_faturaAdres = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lbl_toplam = new javax.swing.JLabel();
        btn_createFatura = new javax.swing.JButton();
        spinner = new javax.swing.JSpinner();
        txt_urunAd = new javax.swing.JTextField();
        txt_fiyat = new javax.swing.JTextField();
        txt_adet = new javax.swing.JTextField();
        txt_kategori = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel22.setBackground(new java.awt.Color(0, 102, 153));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("ZARİF GİYİM");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(22, 22, 22))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        FaturaMusteriTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ad", "Soyad", "Email", "Adres", "Cinsiyet", "T.C. No", "Telefon"
            }
        ));
        FaturaMusteriTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FaturaMusteriTableMouseClicked(evt);
            }
        });
        musteriPane.setViewportView(FaturaMusteriTable);

        FaturaUrunTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ürün Adı", "Fiyat", "Adet", "Kategori"
            }
        ));
        FaturaUrunTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FaturaUrunTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(FaturaUrunTable);

        Ad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Ad.setText("Ad :");

        Soyad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Soyad.setText("Soyad :");

        Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Email.setText("Email :");

        Cinsiyet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Cinsiyet.setText("Cinsiyet");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("T.C. No:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Telefon :");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Adres :");

        txt_faturaAdres.setColumns(20);
        txt_faturaAdres.setRows(5);
        jScrollPane5.setViewportView(txt_faturaAdres);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setText("Ürün Adı :");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Toplam Adet :");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Fiyat :");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Kategori :");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Toplam :");

        lbl_toplam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_toplam.setText("0");

        btn_createFatura.setText("Fatura Oluştur");
        btn_createFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createFaturaActionPerformed(evt);
            }
        });

        spinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("MÜŞTERİLER");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("ÜRÜNLER");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Fatura Tipi :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alış", "Satış", "İade" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Adet  :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(musteriPane, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Soyad)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel26)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel24)
                                        .addComponent(Cinsiyet)
                                        .addComponent(Email))
                                    .addGap(31, 31, 31)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_faturaSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_faturaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_faturaCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_faturaTcNo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_faturaTel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addComponent(txt_faturaAd, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(Ad)
                                    .addGap(62, 62, 62)
                                    .addComponent(btn_createFatura, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinner)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_kategori, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_adet, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_fiyat, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                            .addComponent(txt_urunAd, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(lbl_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(397, 397, 397))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addComponent(musteriPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txt_urunAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txt_fiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txt_adet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(lbl_toplam)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ad)
                            .addComponent(txt_faturaAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Soyad)
                            .addComponent(txt_faturaSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Email)
                            .addComponent(txt_faturaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cinsiyet)
                            .addComponent(txt_faturaCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(txt_faturaTcNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txt_faturaTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(btn_createFatura, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FaturaMusteriTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FaturaMusteriTableMouseClicked
        seciliMusteriYazdir();
    }//GEN-LAST:event_FaturaMusteriTableMouseClicked
    String fiyat;
    private void FaturaUrunTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FaturaUrunTableMouseClicked
        int selectedRow = FaturaUrunTable.getSelectedRow();
        if (selectedRow != -1) {
            String urunIdString = FaturaUrunTable.getValueAt(selectedRow, 0).toString();
            urunId = Integer.parseInt(urunIdString);
            String urunAd = FaturaUrunTable.getValueAt(selectedRow, 1).toString();
            fiyat = FaturaUrunTable.getValueAt(selectedRow, 2).toString();
            String adet = FaturaUrunTable.getValueAt(selectedRow, 3).toString();
            String kategori = FaturaUrunTable.getValueAt(selectedRow, 4).toString();

            txt_urunAd.setText(urunAd);
            txt_fiyat.setText(fiyat);
            txt_adet.setText(adet);
            txt_kategori.setText(kategori);

        } else {
            JOptionPane.showMessageDialog(null, "ürün seçilemedi.");
        }

    }//GEN-LAST:event_FaturaUrunTableMouseClicked

    private void btn_createFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createFaturaActionPerformed
        if (urunId == 0 || musteriId == 0 || toplam == 0 || spinnerValue == 0 || billtype == null) {
            JOptionPane.showMessageDialog(this, "Tüm alanları doldurmalısınız.", "Hata", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String query = "INSERT INTO public.\"Faturalar\"(\"urunId\", \"musteriId\", adet, toplam, \"faturaTipi\") "
                        + "VALUES (?, ?, ?, ?, ?)";
                System.out.println(urunId);
                System.out.println(musteriId);
                System.out.println(toplam);
                System.out.println(spinnerValue);
                System.out.println(billtype);

                PreparedStatement pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, urunId);
                pstmt.setInt(2, musteriId);
                pstmt.setInt(3, spinnerValue);
                pstmt.setInt(4, toplam);
                pstmt.setObject(5, billtype.toString());

                pstmt.executeUpdate();
                pstmt.close();

                JOptionPane.showMessageDialog(this, "Fatura başarıyla eklendi.", "Bilgi", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Fatura eklenirken bir hata oluştu: " + e.getMessage(),
                        "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btn_createFaturaActionPerformed

    private void spinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerStateChanged

        int fiyatValue = Integer.parseInt(fiyat);
        spinnerValue = (int) spinner.getValue();

        if (spinnerValue < 0) {
            spinnerValue = 0;
            spinner.setValue(spinnerValue);
        }

        toplam = spinnerValue * fiyatValue;
        lbl_toplam.setText(String.valueOf(toplam));
    }//GEN-LAST:event_spinnerStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BillPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ad;
    private javax.swing.JLabel Cinsiyet;
    private javax.swing.JLabel Email;
    private javax.swing.JTable FaturaMusteriTable;
    private javax.swing.JTable FaturaUrunTable;
    private javax.swing.JLabel Soyad;
    private javax.swing.JButton btn_createFatura;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbl_toplam;
    private javax.swing.JScrollPane musteriPane;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTextField txt_adet;
    private javax.swing.JTextField txt_faturaAd;
    private javax.swing.JTextArea txt_faturaAdres;
    private javax.swing.JTextField txt_faturaCinsiyet;
    private javax.swing.JTextField txt_faturaEmail;
    private javax.swing.JTextField txt_faturaSoyad;
    private javax.swing.JTextField txt_faturaTcNo;
    private javax.swing.JTextField txt_faturaTel;
    private javax.swing.JTextField txt_fiyat;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JTextField txt_urunAd;
    // End of variables declaration//GEN-END:variables
}
