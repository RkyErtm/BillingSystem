/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pages;

import DatabaseConnection.DBConnect;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VKFGLB
 */
public class HomeTabPage extends javax.swing.JFrame {

    Connection conn = null;
    Statement st;
    private boolean isAdmin = false;
    String email;

    public HomeTabPage(String email) {
        initComponents();
        setKullaniciSayisi();
        setMusteriSayisi();
        KategoriComboBox();
        setUrunSayisi();
        this.email = email;
    }

    public HomeTabPage() {
        initComponents();
    }

    private void checkUserRole() {
        try {
            conn = DBConnect.connect();
            String sqlquery = "SELECT rol FROM public.\"Kullanicilar\" WHERE email = ?";
            PreparedStatement pst = conn.prepareStatement(sqlquery);
            pst.setString(1, this.email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String role = rs.getString("rol");
                if (role.equals("admin")) {
                    isAdmin = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setKullaniciSayisi() {
        try {
            conn = DBConnect.connect();
            String sqlquery = "SELECT COUNT(*) as kullanici_sayisi FROM public.\"Kullanicilar\"";
            PreparedStatement pst = conn.prepareStatement(sqlquery);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int kullaniciSayisi = rs.getInt("kullanici_sayisi");
                lbl_kullanicilar.setText(String.valueOf(kullaniciSayisi));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setMusteriSayisi() {
        try {
            conn = DBConnect.connect();
            String sqlquery = "SELECT COUNT(*) as musteri_sayisi FROM public.\"Musteriler\"";
            PreparedStatement pst = conn.prepareStatement(sqlquery);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int musteriSayisi = rs.getInt("musteri_sayisi");
                lbl_musteriler.setText(String.valueOf(musteriSayisi));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setUrunSayisi() {
        try {
            conn = DBConnect.connect();
            String sqlquery = "SELECT COUNT(*) as urun_sayisi FROM public.\"Urunler\"";
            PreparedStatement pst = conn.prepareStatement(sqlquery);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int urunSayisi = rs.getInt("urun_sayisi");
                lbl_urunler.setText(String.valueOf(urunSayisi));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void KategoriComboBox() {
        try {
            conn = DBConnect.connect();
            String query = "SELECT \"Id\", ad FROM public.\"Kategoriler\"";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            // Combobox'ı temizle
            cbx_urun.removeAllItems();

            // Kategorileri combobox'a ekle
            while (rs.next()) {
                int kategoriId = rs.getInt("Id");
                String kategoriAd = rs.getString("ad");
                Kategori kategori = new Kategori(kategoriId, kategoriAd);
                cbx_urun.addItem(kategori.toString());
            }

            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void clearTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_anasayfa = new javax.swing.JButton();
        btn_cikis = new javax.swing.JButton();
        btn_musteri = new javax.swing.JButton();
        btn_urun = new javax.swing.JButton();
        btn_fatura = new javax.swing.JButton();
        btn_kullanici = new javax.swing.JButton();
        TabbPanel = new javax.swing.JTabbedPane();
        anasayfa = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_musteriler = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbl_urunler = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbl_faturalar = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lbl_kullanicilar = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        musteri = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lbl_homePage9 = new javax.swing.JLabel();
        lbl_homePage10 = new javax.swing.JLabel();
        lbl_homePage11 = new javax.swing.JLabel();
        lbl_homePage12 = new javax.swing.JLabel();
        lbl_homePage13 = new javax.swing.JLabel();
        txt_musteriAd = new javax.swing.JTextField();
        txt_musteriSoyad = new javax.swing.JTextField();
        txt_musteriEmail = new javax.swing.JTextField();
        txt_musteriTel = new javax.swing.JTextField();
        btn_musteriEkle = new javax.swing.JButton();
        lbl_homePage14 = new javax.swing.JLabel();
        txt_musteriAdres = new javax.swing.JTextField();
        btn_musteriBul = new javax.swing.JButton();
        btn_musteriGuncelle = new javax.swing.JButton();
        btn_musteriSil = new javax.swing.JButton();
        lbl_musteriListele = new javax.swing.JLabel();
        cbx_musteri = new javax.swing.JComboBox<>();
        lbl_homePage15 = new javax.swing.JLabel();
        txt_musteriTc = new javax.swing.JTextField();
        kullaniciIslemleri = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lbl_homePage3 = new javax.swing.JLabel();
        lbl_homePage4 = new javax.swing.JLabel();
        lbl_homePage5 = new javax.swing.JLabel();
        lbl_homePage6 = new javax.swing.JLabel();
        lbl_homePage7 = new javax.swing.JLabel();
        txt_ad = new javax.swing.JTextField();
        txt_soyad = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_sifre = new javax.swing.JTextField();
        btn_ekle = new javax.swing.JButton();
        lbl_homePage8 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        btn_bul = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        lbl_listele = new javax.swing.JLabel();
        cbx_kullanici = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        kullaniciList = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsersTable = new javax.swing.JTable();
        urun = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btn_urunEkle = new javax.swing.JButton();
        btn_urunGuncelle = new javax.swing.JButton();
        btn_urunSil = new javax.swing.JButton();
        btn_urunBul = new javax.swing.JButton();
        btn_urunListele = new javax.swing.JButton();
        txt_urunAciklama = new javax.swing.JTextField();
        txt_urunAd = new javax.swing.JTextField();
        txt_urunAdet = new javax.swing.JTextField();
        txt_urunFiyat = new javax.swing.JTextField();
        cbx_urun = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txt_urunId = new javax.swing.JTextField();
        musteriList = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MusteriTable = new javax.swing.JTable();
        urunList = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        UrunTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        btn_anasayfa.setBackground(new java.awt.Color(0, 102, 153));
        btn_anasayfa.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        btn_anasayfa.setForeground(new java.awt.Color(255, 255, 255));
        btn_anasayfa.setText("Anasayfa");
        btn_anasayfa.setAlignmentY(0.0F);
        btn_anasayfa.setBorder(null);
        btn_anasayfa.setIconTextGap(0);
        btn_anasayfa.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_anasayfa.setPreferredSize(new java.awt.Dimension(135, 43));
        btn_anasayfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anasayfaActionPerformed(evt);
            }
        });

        btn_cikis.setBackground(new java.awt.Color(0, 102, 153));
        btn_cikis.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        btn_cikis.setForeground(new java.awt.Color(255, 255, 255));
        btn_cikis.setText("Çıkış");
        btn_cikis.setBorder(null);
        btn_cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cikisActionPerformed(evt);
            }
        });

        btn_musteri.setBackground(new java.awt.Color(0, 102, 153));
        btn_musteri.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        btn_musteri.setForeground(new java.awt.Color(255, 255, 255));
        btn_musteri.setText("Müşteri İşlemleri");
        btn_musteri.setBorder(null);
        btn_musteri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_musteriActionPerformed(evt);
            }
        });

        btn_urun.setBackground(new java.awt.Color(0, 102, 153));
        btn_urun.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        btn_urun.setForeground(new java.awt.Color(255, 255, 255));
        btn_urun.setText("Ürün İşlemleri");
        btn_urun.setBorder(null);
        btn_urun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urunActionPerformed(evt);
            }
        });

        btn_fatura.setBackground(new java.awt.Color(0, 102, 153));
        btn_fatura.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        btn_fatura.setForeground(new java.awt.Color(255, 255, 255));
        btn_fatura.setText("Fatura İşlemleri");
        btn_fatura.setBorder(null);
        btn_fatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_faturaActionPerformed(evt);
            }
        });

        btn_kullanici.setBackground(new java.awt.Color(0, 102, 153));
        btn_kullanici.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        btn_kullanici.setForeground(new java.awt.Color(255, 255, 255));
        btn_kullanici.setText("Kullanıcı İşlemleri");
        btn_kullanici.setBorder(null);
        btn_kullanici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kullaniciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_cikis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_kullanici, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(btn_fatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_urun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_musteri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_anasayfa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btn_anasayfa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btn_musteri)
                .addGap(60, 60, 60)
                .addComponent(btn_urun)
                .addGap(60, 60, 60)
                .addComponent(btn_fatura)
                .addGap(60, 60, 60)
                .addComponent(btn_kullanici)
                .addGap(60, 60, 60)
                .addComponent(btn_cikis)
                .addGap(164, 164, 164))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));

        TabbPanel.setBackground(new java.awt.Color(255, 255, 255));

        anasayfa.setBackground(new java.awt.Color(255, 255, 255));
        anasayfa.setToolTipText("");
        anasayfa.setName(""); // NOI18N

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(0, 102, 153));
        jPanel9.setPreferredSize(new java.awt.Dimension(230, 230));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MÜŞTERİLER");

        lbl_musteriler.setBackground(new java.awt.Color(255, 255, 255));
        lbl_musteriler.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lbl_musteriler.setForeground(new java.awt.Color(255, 255, 255));
        lbl_musteriler.setText("20");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(lbl_musteriler)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addComponent(lbl_musteriler)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(0, 102, 153));
        jPanel10.setPreferredSize(new java.awt.Dimension(230, 230));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ÜRÜNLER");

        lbl_urunler.setBackground(new java.awt.Color(255, 255, 255));
        lbl_urunler.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lbl_urunler.setForeground(new java.awt.Color(255, 255, 255));
        lbl_urunler.setText("20");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(lbl_urunler)
                        .addGap(88, 88, 88))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel10)
                .addGap(42, 42, 42)
                .addComponent(lbl_urunler)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(0, 102, 153));
        jPanel11.setPreferredSize(new java.awt.Dimension(230, 230));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("FATURALAR");

        lbl_faturalar.setBackground(new java.awt.Color(255, 255, 255));
        lbl_faturalar.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lbl_faturalar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_faturalar.setText("20");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lbl_faturalar)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addComponent(lbl_faturalar)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 102, 153));
        jPanel12.setPreferredSize(new java.awt.Dimension(230, 230));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("KULLANICILAR");

        lbl_kullanicilar.setBackground(new java.awt.Color(255, 255, 255));
        lbl_kullanicilar.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lbl_kullanicilar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_kullanicilar.setText("20");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(lbl_kullanicilar)
                        .addGap(91, 91, 91))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel9)
                .addGap(28, 28, 28)
                .addComponent(lbl_kullanicilar)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("ZARİF GİYİM");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(529, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(177, 177, 177))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout anasayfaLayout = new javax.swing.GroupLayout(anasayfa);
        anasayfa.setLayout(anasayfaLayout);
        anasayfaLayout.setHorizontalGroup(
            anasayfaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anasayfaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(anasayfaLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        anasayfaLayout.setVerticalGroup(
            anasayfaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anasayfaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        TabbPanel.addTab("anasayfa", anasayfa);

        musteri.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("ZARİF GİYİM");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(529, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(177, 177, 177))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        lbl_homePage9.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage9.setText("Ad :");
        lbl_homePage9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage9MouseClicked(evt);
            }
        });

        lbl_homePage10.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage10.setText("Cinsiyet :");
        lbl_homePage10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage10MouseClicked(evt);
            }
        });

        lbl_homePage11.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage11.setText("Soyad :");
        lbl_homePage11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage11MouseClicked(evt);
            }
        });

        lbl_homePage12.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage12.setText("Email :");
        lbl_homePage12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage12MouseClicked(evt);
            }
        });

        lbl_homePage13.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage13.setText("Telefon :");
        lbl_homePage13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage13MouseClicked(evt);
            }
        });

        btn_musteriEkle.setBackground(new java.awt.Color(0, 102, 153));
        btn_musteriEkle.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_musteriEkle.setForeground(new java.awt.Color(255, 255, 255));
        btn_musteriEkle.setText("EKLE");
        btn_musteriEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_musteriEkleActionPerformed(evt);
            }
        });

        lbl_homePage14.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage14.setText("Adres :");
        lbl_homePage14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage14MouseClicked(evt);
            }
        });

        txt_musteriAdres.setForeground(new java.awt.Color(153, 153, 153));
        txt_musteriAdres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_musteriAdresFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_musteriAdresFocusLost(evt);
            }
        });

        btn_musteriBul.setBackground(new java.awt.Color(0, 102, 153));
        btn_musteriBul.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_musteriBul.setForeground(new java.awt.Color(255, 255, 255));
        btn_musteriBul.setText("BUL");
        btn_musteriBul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_musteriBulActionPerformed(evt);
            }
        });

        btn_musteriGuncelle.setBackground(new java.awt.Color(0, 102, 153));
        btn_musteriGuncelle.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_musteriGuncelle.setForeground(new java.awt.Color(255, 255, 255));
        btn_musteriGuncelle.setText("GÜNCELLE");
        btn_musteriGuncelle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_musteriGuncelleMouseClicked(evt);
            }
        });
        btn_musteriGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_musteriGuncelleActionPerformed(evt);
            }
        });

        btn_musteriSil.setBackground(new java.awt.Color(0, 102, 153));
        btn_musteriSil.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_musteriSil.setForeground(new java.awt.Color(255, 255, 255));
        btn_musteriSil.setText("SİL");
        btn_musteriSil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_musteriSilMouseClicked(evt);
            }
        });
        btn_musteriSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_musteriSilActionPerformed(evt);
            }
        });

        lbl_musteriListele.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_musteriListele.setForeground(new java.awt.Color(102, 102, 102));
        lbl_musteriListele.setText("Müşteri Listele");
        lbl_musteriListele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_musteriListeleMouseClicked(evt);
            }
        });

        cbx_musteri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "K", "E" }));

        lbl_homePage15.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage15.setText("T.C No :");
        lbl_homePage15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage15MouseClicked(evt);
            }
        });

        txt_musteriTc.setForeground(new java.awt.Color(153, 153, 153));
        txt_musteriTc.setText("TC ile müşteri arayabilir silebilirsiniz");
        txt_musteriTc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_musteriTcFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_musteriTcFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(lbl_musteriListele)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_homePage14)
                                    .addComponent(lbl_homePage10)
                                    .addComponent(lbl_homePage13)
                                    .addComponent(lbl_homePage12)
                                    .addComponent(lbl_homePage11)
                                    .addComponent(lbl_homePage9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_musteriAdres, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbx_musteri, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_musteriTc, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txt_musteriSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_musteriAd, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_musteriEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_musteriTel, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(btn_musteriSil, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(btn_musteriGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(btn_musteriEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(btn_musteriBul, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 19, Short.MAX_VALUE)))
                        .addGap(54, 54, 54))))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(lbl_homePage15)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_musteriListele)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_homePage9)
                    .addComponent(txt_musteriAd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_musteriSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_homePage11))
                .addGap(28, 28, 28)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_musteriEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_homePage12))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_musteriTel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_homePage13))
                .addGap(30, 30, 30)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_homePage10)
                    .addComponent(cbx_musteri, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_musteriAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_homePage14))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_homePage15)
                    .addComponent(txt_musteriTc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_musteriEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_musteriBul, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_musteriGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_musteriSil, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout musteriLayout = new javax.swing.GroupLayout(musteri);
        musteri.setLayout(musteriLayout);
        musteriLayout.setHorizontalGroup(
            musteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musteriLayout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(musteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, musteriLayout.createSequentialGroup()
                    .addContainerGap(38, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );
        musteriLayout.setVerticalGroup(
            musteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musteriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(748, Short.MAX_VALUE))
            .addGroup(musteriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, musteriLayout.createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        TabbPanel.addTab("tab2", musteri);

        kullaniciIslemleri.setBackground(new java.awt.Color(255, 255, 255));
        kullaniciIslemleri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        lbl_homePage3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage3.setText("Ad :");
        lbl_homePage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage3MouseClicked(evt);
            }
        });

        lbl_homePage4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage4.setText("Rol :");
        lbl_homePage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage4MouseClicked(evt);
            }
        });

        lbl_homePage5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage5.setText("Soyad :");
        lbl_homePage5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage5MouseClicked(evt);
            }
        });

        lbl_homePage6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage6.setText("Email :");
        lbl_homePage6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage6MouseClicked(evt);
            }
        });

        lbl_homePage7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage7.setText("Şifre :");
        lbl_homePage7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage7MouseClicked(evt);
            }
        });

        btn_ekle.setBackground(new java.awt.Color(0, 102, 153));
        btn_ekle.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_ekle.setForeground(new java.awt.Color(255, 255, 255));
        btn_ekle.setText("EKLE");
        btn_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ekleActionPerformed(evt);
            }
        });

        lbl_homePage8.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_homePage8.setText("Id :");
        lbl_homePage8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homePage8MouseClicked(evt);
            }
        });

        txt_Id.setForeground(new java.awt.Color(153, 153, 153));
        txt_Id.setText("Id ile kullanıcı arayınız");
        txt_Id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_IdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_IdFocusLost(evt);
            }
        });

        btn_bul.setBackground(new java.awt.Color(0, 102, 153));
        btn_bul.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_bul.setForeground(new java.awt.Color(255, 255, 255));
        btn_bul.setText("BUL");
        btn_bul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bulActionPerformed(evt);
            }
        });

        btn_guncelle.setBackground(new java.awt.Color(0, 102, 153));
        btn_guncelle.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_guncelle.setForeground(new java.awt.Color(255, 255, 255));
        btn_guncelle.setText("GÜNCELLE");
        btn_guncelle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guncelleMouseClicked(evt);
            }
        });

        btn_sil.setBackground(new java.awt.Color(0, 102, 153));
        btn_sil.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_sil.setForeground(new java.awt.Color(255, 255, 255));
        btn_sil.setText("SİL");
        btn_sil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_silMouseClicked(evt);
            }
        });

        lbl_listele.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_listele.setForeground(new java.awt.Color(102, 102, 102));
        lbl_listele.setText("Kullanıcı Listele");
        lbl_listele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_listeleMouseClicked(evt);
            }
        });

        cbx_kullanici.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "çalışan", "admin" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbl_listele)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_ekle, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_homePage8)
                                    .addComponent(lbl_homePage4)
                                    .addComponent(lbl_homePage7)
                                    .addComponent(lbl_homePage6)
                                    .addComponent(lbl_homePage5)
                                    .addComponent(lbl_homePage3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btn_sil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_Id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                                    .addComponent(btn_bul, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbx_kullanici, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_sifre, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(104, Short.MAX_VALUE))))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lbl_listele)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_homePage3)
                    .addComponent(txt_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_soyad, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_homePage5))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_homePage6))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_sifre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_homePage7))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_homePage4)
                    .addComponent(cbx_kullanici, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_homePage8))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_ekle, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(btn_bul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_sil, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btn_guncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );

        kullaniciIslemleri.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 690, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setText("ZARİF GİYİM");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(529, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(177, 177, 177))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        kullaniciIslemleri.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        TabbPanel.addTab("tab5", kullaniciIslemleri);

        kullaniciList.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setText("ZARİF GİYİM");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(529, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(177, 177, 177))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel12)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        UsersTable.setAutoCreateRowSorter(true);
        UsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ad", "Soyad", "Email", "Rol"
            }
        ));
        UsersTable.setRowHeight(30);
        jScrollPane1.setViewportView(UsersTable);

        javax.swing.GroupLayout kullaniciListLayout = new javax.swing.GroupLayout(kullaniciList);
        kullaniciList.setLayout(kullaniciListLayout);
        kullaniciListLayout.setHorizontalGroup(
            kullaniciListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kullaniciListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(kullaniciListLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kullaniciListLayout.setVerticalGroup(
            kullaniciListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kullaniciListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        TabbPanel.addTab("tab6", kullaniciList);

        urun.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("ZARİF GİYİM");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(529, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(177, 177, 177))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel14.setText("Ürün Adı :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel16.setText("Fiyat :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel17.setText("Adet :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel18.setText("Kategori :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel19.setText("Açıklama :");

        btn_urunEkle.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_urunEkle.setText("Ekle");
        btn_urunEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urunEkleActionPerformed(evt);
            }
        });

        btn_urunGuncelle.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_urunGuncelle.setText("Güncelle");
        btn_urunGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urunGuncelleActionPerformed(evt);
            }
        });

        btn_urunSil.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_urunSil.setText("Sil");
        btn_urunSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urunSilActionPerformed(evt);
            }
        });

        btn_urunBul.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_urunBul.setText("Bul");
        btn_urunBul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urunBulActionPerformed(evt);
            }
        });

        btn_urunListele.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        btn_urunListele.setText("Listele");
        btn_urunListele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urunListeleActionPerformed(evt);
            }
        });

        txt_urunAciklama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_urunAd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_urunAdet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_urunFiyat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel21.setText("Ürün Id :");

        txt_urunId.setForeground(new java.awt.Color(153, 153, 153));
        txt_urunId.setText("Id ile müşteri arayabilir ve silebilirsiniz");

        javax.swing.GroupLayout urunLayout = new javax.swing.GroupLayout(urun);
        urun.setLayout(urunLayout);
        urunLayout.setHorizontalGroup(
            urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(urunLayout.createSequentialGroup()
                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, urunLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(urunLayout.createSequentialGroup()
                        .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(urunLayout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(btn_urunEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btn_urunSil, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btn_urunGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(urunLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(57, 57, 57)
                                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_urunFiyat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                    .addComponent(txt_urunAciklama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_urunAdet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                    .addComponent(txt_urunAd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                    .addComponent(cbx_urun, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_urunId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(urunLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(btn_urunBul, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btn_urunListele, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        urunLayout.setVerticalGroup(
            urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(urunLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(txt_urunId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(txt_urunAd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(txt_urunAdet, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(urunLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addComponent(txt_urunFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_urunAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cbx_urun, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_urunEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_urunGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_urunSil, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(urunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_urunBul, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_urunListele, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        TabbPanel.addTab("tab3", urun);

        musteriList.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 51));
        jLabel20.setText("ZARİF GİYİM");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(529, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(177, 177, 177))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel20)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jScrollPane2.setBorder(null);

        MusteriTable.setAutoCreateRowSorter(true);
        MusteriTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ad", "Soyad", "Email", "Adres", "Cinsiyet", "T.C. No", "Telefon"
            }
        ));
        MusteriTable.setRowHeight(30);
        jScrollPane2.setViewportView(MusteriTable);

        javax.swing.GroupLayout musteriListLayout = new javax.swing.GroupLayout(musteriList);
        musteriList.setLayout(musteriListLayout);
        musteriListLayout.setHorizontalGroup(
            musteriListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musteriListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(musteriListLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        musteriListLayout.setVerticalGroup(
            musteriListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, musteriListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        TabbPanel.addTab("tab6", musteriList);

        urunList.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("ZARİF GİYİM");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(529, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(177, 177, 177))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel22)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jScrollPane3.setBorder(null);

        UrunTable.setAutoCreateRowSorter(true);
        UrunTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Ürün Adı", "Fiyat", "Adet", "Açıklama", "Kategori"
            }
        ));
        UrunTable.setRowHeight(30);
        jScrollPane3.setViewportView(UrunTable);

        javax.swing.GroupLayout urunListLayout = new javax.swing.GroupLayout(urunList);
        urunList.setLayout(urunListLayout);
        urunListLayout.setHorizontalGroup(
            urunListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(urunListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(urunListLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        urunListLayout.setVerticalGroup(
            urunListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, urunListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        TabbPanel.addTab("tab6", urunList);

        getContentPane().add(TabbPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, -48, 710, 850));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_anasayfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anasayfaActionPerformed
        TabbPanel.setSelectedIndex(0);
    }//GEN-LAST:event_btn_anasayfaActionPerformed

    private void btn_cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cikisActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_cikisActionPerformed

    private void btn_musteriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_musteriActionPerformed
        TabbPanel.setSelectedIndex(1);
    }//GEN-LAST:event_btn_musteriActionPerformed

    private void btn_kullaniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kullaniciActionPerformed
        checkUserRole();
        if (isAdmin) {
            TabbPanel.setSelectedIndex(2);
        } else {
            JOptionPane.showMessageDialog(null, "Bu işlem için yetkiniz yok!");
        }
    }//GEN-LAST:event_btn_kullaniciActionPerformed

    private void btn_urunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urunActionPerformed
        TabbPanel.setSelectedIndex(4);
    }//GEN-LAST:event_btn_urunActionPerformed

    private void btn_faturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_faturaActionPerformed
//        TabbPanel.setSelectedIndex(2);
        BillPage billpage = new BillPage();
        billpage.setVisible(true);
//        listeleMusteriler();
    }//GEN-LAST:event_btn_faturaActionPerformed

    private void lbl_homePage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage3MouseClicked

    private void lbl_homePage4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage4MouseClicked

    private void lbl_homePage5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage5MouseClicked

    private void lbl_homePage6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage6MouseClicked

    private void lbl_homePage7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage7MouseClicked

    private void btn_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ekleActionPerformed
        String ad = txt_ad.getText();
        String soyad = txt_soyad.getText();
        String email = txt_email.getText();
        String sifre = txt_sifre.getText();
        String rol = cbx_kullanici.getSelectedItem().toString();

        if (ad.isEmpty() || soyad.isEmpty() || email.isEmpty() || sifre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!");
        } else {
            try {
                conn = DBConnect.connect();
                String checkQuery = "SELECT * FROM public.\"Kullanicilar\" WHERE email = ?";
                PreparedStatement pstCheck = conn.prepareStatement(checkQuery);
                pstCheck.setString(1, email);
                ResultSet rs = pstCheck.executeQuery();
                //sorgu sonucu dönerse email var demektir.
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Bu email adresi daha önce kaydedilmiş!");
                } else {
                    String insertQuery = "INSERT INTO public.\"Kullanicilar\"(ad, soyad, sifre, email, rol) VALUES (?,?,?,?,?)";
                    PreparedStatement pstInsert = conn.prepareStatement(insertQuery);
                    pstInsert.setString(1, ad);
                    pstInsert.setString(2, soyad);
                    pstInsert.setString(3, sifre);
                    pstInsert.setString(4, email);
                    pstInsert.setString(5, rol);
                    int result = pstInsert.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Kullanıcı kaydı başarılı!");
                        txt_ad.setText("");
                        txt_soyad.setText("");
                        txt_email.setText("");
                        txt_sifre.setText("");
                        txt_Id.setText("");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btn_ekleActionPerformed

    private void lbl_homePage8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage8MouseClicked

    private void txt_IdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_IdFocusGained
        txt_Id.setText("");
    }//GEN-LAST:event_txt_IdFocusGained

    private void txt_IdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_IdFocusLost

    }//GEN-LAST:event_txt_IdFocusLost

    private void btn_bulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bulActionPerformed
        String id = txt_Id.getText();
        int IntId = Integer.parseInt(id);
        try {

            conn = DBConnect.connect();

            String selectQuery = "SELECT ad, soyad, sifre, email, rol FROM public.\"Kullanicilar\" WHERE \"Id\"=?";
            PreparedStatement pst = conn.prepareStatement(selectQuery);
            pst.setInt(1, IntId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String sifre = rs.getString("sifre");
                String email = rs.getString("email");
                String rol = rs.getString("rol");
                txt_ad.setText(ad);
                txt_soyad.setText(soyad);
                txt_sifre.setText(sifre);
                txt_email.setText(email);
                cbx_kullanici.setSelectedItem(rol);
            } else {
                JOptionPane.showMessageDialog(null, "Kullanıcı bulunamadı!");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_bulActionPerformed

    private void btn_guncelleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guncelleMouseClicked
        String ad = txt_ad.getText();
        String soyad = txt_soyad.getText();
        String email = txt_email.getText();
        String sifre = txt_sifre.getText();
        String id = txt_Id.getText();
        String rol = cbx_kullanici.getSelectedItem().toString();
        int IntId = Integer.parseInt(id);

        try {

            conn = DBConnect.connect();
            String updateQuery = "UPDATE public.\"Kullanicilar\" SET ad = ?, soyad = ?, sifre = ?, email = ?, rol = ? WHERE \"Id\" = ?";
            PreparedStatement pst = conn.prepareStatement(updateQuery);
            pst.setString(1, ad);
            pst.setString(2, soyad);
            pst.setString(3, sifre);
            pst.setString(4, email);
            pst.setString(5, rol);
            pst.setInt(6, IntId);
            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Kullanıcı güncellendi!");
                txt_ad.setText("");
                txt_soyad.setText("");
                txt_email.setText("");
                txt_sifre.setText("");
                cbx_kullanici.setSelectedIndex(0);
                txt_Id.setText("");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_guncelleMouseClicked

    private void btn_silMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_silMouseClicked
        String id = txt_Id.getText();
        int IntId = Integer.parseInt(id);

        try {

            conn = DBConnect.connect();
            String deleteQuery = "DELETE FROM public.\"Kullanicilar\" WHERE \"Id\"=?";
            PreparedStatement pst = conn.prepareStatement(deleteQuery);
            pst.setInt(1, IntId);
            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Kullanıcı silme işlemi başarılı!");
                txt_ad.setText("");
                txt_soyad.setText("");
                txt_email.setText("");
                txt_sifre.setText("");
                txt_Id.setText("");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_silMouseClicked

    private void lbl_listeleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_listeleMouseClicked

        try {
            clearTable(UsersTable);
            conn = DBConnect.connect();
            String Listquery = "SELECT * FROM public.\"Kullanicilar\"";
            PreparedStatement pst = conn.prepareStatement(Listquery);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("Id"));
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String email = rs.getString("email");
                String rol = rs.getString("rol");

                String dataTable[] = {id, ad, soyad, email, rol};
                DefaultTableModel model = (DefaultTableModel) UsersTable.getModel();
                model.addRow(dataTable);
                TabbPanel.setSelectedIndex(3);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_lbl_listeleMouseClicked

    private void btn_urunGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urunGuncelleActionPerformed
        try {
            conn = DBConnect.connect();
            String updateQuery = "UPDATE public.\"Urunler\" SET \"urunAdi\" = ?, fiyat = ?, adet = ?, aciklama = ?, kategori = ? WHERE \"Id\" = ?";
            PreparedStatement pstUpdate = conn.prepareStatement(updateQuery);

            String urunAdi = txt_urunAd.getText();
            int urunFiyat = Integer.parseInt(txt_urunFiyat.getText());
            int urunAdet = Integer.parseInt(txt_urunAdet.getText());
            String urunAciklama = txt_urunAciklama.getText();
            String selectedKategori = cbx_urun.getSelectedItem().toString();
            int urunKategori = -1;

            if (urunAdi.isEmpty() || txt_urunFiyat.getText().isEmpty() || txt_urunAdet.getText().isEmpty() || urunAciklama.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!");
            } else {
                String selectQuery = "SELECT \"Id\" FROM public.\"Kategoriler\" WHERE ad = ?";
                PreparedStatement pstSelect = conn.prepareStatement(selectQuery);
                pstSelect.setString(1, selectedKategori);
                ResultSet rs = pstSelect.executeQuery();
                if (rs.next()) {
                    urunKategori = rs.getInt("Id");
                }

                pstUpdate.setString(1, urunAdi);
                pstUpdate.setInt(2, urunFiyat);
                pstUpdate.setInt(3, urunAdet);
                pstUpdate.setString(4, urunAciklama);
                pstUpdate.setInt(5, urunKategori);

                int urunId = Integer.parseInt(txt_urunId.getText());
                pstUpdate.setInt(6, urunId);

                int result = pstUpdate.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Ürün güncelleme işlemi başarılı!");
                } else {
                    JOptionPane.showMessageDialog(null, "Ürün bulunamadı!");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btn_urunGuncelleActionPerformed

    private void btn_urunSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urunSilActionPerformed
        try {
            conn = DBConnect.connect();
            String deleteQuery = "DELETE FROM public.\"Urunler\" WHERE \"Id\" = ?";
            PreparedStatement pstDelete = conn.prepareStatement(deleteQuery);
            int urunId = Integer.parseInt(txt_urunId.getText());
            pstDelete.setInt(1, urunId);

            int result = pstDelete.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Ürün silme işlemi başarılı!");
            } else {
                JOptionPane.showMessageDialog(null, "Ürün bulunamadı!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_btn_urunSilActionPerformed

    private void btn_urunBulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urunBulActionPerformed
        try {
            conn = DBConnect.connect();
            String selectQuery = "SELECT * FROM public.\"Urunler\" WHERE \"Id\" = ?";
            PreparedStatement pstSelect = conn.prepareStatement(selectQuery);
            int urunId = Integer.parseInt(txt_urunId.getText());
            pstSelect.setInt(1, urunId);

            ResultSet rs = pstSelect.executeQuery();
            if (rs.next()) {

                String urunAdi = rs.getString("urunAdi");
                int urunFiyat = rs.getInt("fiyat");
                int urunAdet = rs.getInt("adet");
                String urunAciklama = rs.getString("aciklama");
                int urunKategori = rs.getInt("kategori");

                txt_urunAd.setText(urunAdi);
                txt_urunFiyat.setText(String.valueOf(urunFiyat));
                txt_urunAdet.setText(String.valueOf(urunAdet));
                txt_urunAciklama.setText(urunAciklama);

                String kategoriQuery = "SELECT * FROM public.\"Kategoriler\" WHERE \"Id\" = ?";
                PreparedStatement pstKategori = conn.prepareStatement(kategoriQuery);
                pstKategori.setInt(1, urunKategori);
                ResultSet kategoriRs = pstKategori.executeQuery();
                if (kategoriRs.next()) {
                    String kategoriAdi = kategoriRs.getString("ad");
                    cbx_urun.setSelectedItem(kategoriAdi);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ürün bulunamadı!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btn_urunBulActionPerformed

    private void btn_urunListeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urunListeleActionPerformed
        try {
            clearTable(UrunTable);
            conn = DBConnect.connect();
            String listQuery = "SELECT * FROM public.\"Urunler\"";
            PreparedStatement pstList = conn.prepareStatement(listQuery);
            ResultSet rs = pstList.executeQuery();

            while (rs.next()) {
                int urunId = rs.getInt("Id");
                String urunAdi = rs.getString("urunAdi");
                int urunFiyat = rs.getInt("fiyat");
                int urunAdet = rs.getInt("adet");
                String urunAciklama = rs.getString("aciklama");
                int urunKategori = rs.getInt("kategori");

                String kategoriAdi = "";
                String kategoriQuery = "SELECT * FROM public.\"Kategoriler\" WHERE \"Id\" = ?";
                PreparedStatement pstKategori = conn.prepareStatement(kategoriQuery);
                pstKategori.setInt(1, urunKategori);
                ResultSet kategoriRs = pstKategori.executeQuery();
                if (kategoriRs.next()) {
                    kategoriAdi = kategoriRs.getString("ad");
                }

                String[] dataTable = {String.valueOf(urunId), urunAdi, String.valueOf(urunFiyat), String.valueOf(urunAdet), urunAciklama, kategoriAdi};
                DefaultTableModel model = (DefaultTableModel) UrunTable.getModel();
                model.addRow(dataTable);
            }

            TabbPanel.setSelectedIndex(6);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_btn_urunListeleActionPerformed

    private void btn_urunEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urunEkleActionPerformed
        String urunAdi = txt_urunAd.getText();
        int urunFiyat = Integer.parseInt(txt_urunFiyat.getText());
        int urunAdet = Integer.parseInt(txt_urunAdet.getText());
        String urunAciklama = txt_urunAciklama.getText();
        String selectedKategori = cbx_urun.getSelectedItem().toString();
        int urunKategori = -1;

        if (urunAdi.isEmpty() || txt_urunFiyat.getText().isEmpty() || txt_urunAdet.getText().isEmpty() || urunAciklama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!");
        } else {
            try {
                conn = DBConnect.connect();
                String checkQuery = "SELECT * FROM public.\"Urunler\" WHERE \"urunAdi\" = ?";
                PreparedStatement pstCheck = conn.prepareStatement(checkQuery);
                pstCheck.setString(1, urunAdi);
                ResultSet rs = pstCheck.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Bu ürün adı daha önce kaydedilmiş!");
                } else {
                    String selectQuery = "SELECT \"Id\" FROM public.\"Kategoriler\" WHERE ad = ?";
                    PreparedStatement pstSelect = conn.prepareStatement(selectQuery);
                    pstSelect.setString(1, selectedKategori);
                    rs = pstSelect.executeQuery();
                    if (rs.next()) {
                        urunKategori = rs.getInt("Id");
                    }
                    String insertQuery = "INSERT INTO public.\"Urunler\"(\"urunAdi\", fiyat, adet, aciklama, kategori) VALUES (?,?,?,?,?)";
                    PreparedStatement pstInsert = conn.prepareStatement(insertQuery);
                    pstInsert.setString(1, urunAdi);
                    pstInsert.setInt(2, urunFiyat);
                    pstInsert.setInt(3, urunAdet);
                    pstInsert.setString(4, urunAciklama);
                    pstInsert.setInt(5, urunKategori);

                    int result = pstInsert.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Ürün kaydı başarılı!");
                        txt_urunAd.setText("");
                        txt_urunFiyat.setText("");
                        txt_urunAdet.setText("");
                        txt_urunAciklama.setText("");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_btn_urunEkleActionPerformed

    private void lbl_homePage9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage9MouseClicked

    private void lbl_homePage10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage10MouseClicked

    private void lbl_homePage11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage11MouseClicked

    private void lbl_homePage12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage12MouseClicked

    private void lbl_homePage13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage13MouseClicked

    private void btn_musteriEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_musteriEkleActionPerformed
        String musteriAd = txt_musteriAd.getText();
        String musteriSoyad = txt_musteriSoyad.getText();
        String musteriEmail = txt_musteriEmail.getText();
        String musteriTcNo = txt_musteriTel.getText();
        String musteriAdres = txt_musteriAdres.getText();
        String musteriTelefon = txt_musteriTc.getText();
        String musteriCinsiyet = cbx_musteri.getSelectedItem().toString();

        if (musteriAd.isEmpty() || musteriSoyad.isEmpty() || musteriEmail.isEmpty() || musteriTcNo.isEmpty() || musteriAdres.isEmpty() || musteriTelefon.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lütfen tüm alanları doldurun!");
        } else {
            try {
                conn = DBConnect.connect();
                String checkQuery = "SELECT * FROM public.\"Musteriler\" WHERE email = ?";
                PreparedStatement pstCheck = conn.prepareStatement(checkQuery);
                pstCheck.setString(1, musteriEmail);
                ResultSet rs = pstCheck.executeQuery();
                //sorgu sonucu dönerse email var demektir.
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Bu email adresi daha önce kaydedilmiş!");
                } else {
                    String insertQuery = "INSERT INTO public.\"Musteriler\"(ad, soyad, email, adres, cinsiyet, \"tcNo\", telefon) VALUES (?,?,?,?,?,?,?)";
                    PreparedStatement pstInsert = conn.prepareStatement(insertQuery);
                    pstInsert.setString(1, musteriAd);
                    pstInsert.setString(2, musteriSoyad);
                    pstInsert.setString(3, musteriEmail);
                    pstInsert.setString(4, musteriAdres);
                    pstInsert.setString(5, musteriCinsiyet);
                    pstInsert.setString(6, musteriTcNo);
                    pstInsert.setString(7, musteriTelefon);

                    int result = pstInsert.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(null, "Müşteri kaydı başarılı!");
                        txt_musteriAd.setText("");
                        txt_musteriSoyad.setText("");
                        txt_musteriEmail.setText("");
                        txt_musteriTel.setText("");
                        txt_musteriAdres.setText("");
                        txt_musteriTc.setText("");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_btn_musteriEkleActionPerformed

    private void lbl_homePage14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage14MouseClicked

    private void txt_musteriAdresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_musteriAdresFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_musteriAdresFocusGained

    private void txt_musteriAdresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_musteriAdresFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_musteriAdresFocusLost

    private void btn_musteriBulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_musteriBulActionPerformed
        String musteriTc = txt_musteriTc.getText();
        try {
            conn = DBConnect.connect();

            String selectQuery = "SELECT ad, soyad, email, adres, cinsiyet, \"tcNo\", telefon FROM public.\"Musteriler\" WHERE \"tcNo\"=?";
            PreparedStatement pst = conn.prepareStatement(selectQuery);
            pst.setString(1, musteriTc);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String email = rs.getString("email");
                String tcNo = rs.getString("tcNo");
                String adres = rs.getString("adres");
                String telefon = rs.getString("telefon");
                String cinsiyet = rs.getString("cinsiyet");

                txt_musteriAd.setText(ad);
                txt_musteriSoyad.setText(soyad);
                txt_musteriTel.setText(telefon);
                txt_musteriEmail.setText(email);
                txt_musteriAdres.setText(adres);
                txt_musteriTc.setText(tcNo);
                cbx_musteri.setSelectedItem(cinsiyet);
            } else {
                JOptionPane.showMessageDialog(null, "Müşteri bulunamadı!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btn_musteriBulActionPerformed

    private void btn_musteriGuncelleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_musteriGuncelleMouseClicked
        String ad = txt_musteriAd.getText();
        String soyad = txt_musteriSoyad.getText();
        String email = txt_musteriEmail.getText();
        String adres = txt_musteriAdres.getText();
        String tcNo = txt_musteriTc.getText();
        String telefon = txt_musteriTel.getText();
        String cinsiyet = cbx_musteri.getSelectedItem().toString();

        try {
            conn = DBConnect.connect();
            String updateQuery = "UPDATE public.\"Musteriler\" SET ad=?, soyad=?, email=?, adres=?, cinsiyet=?, \"tcNo\"=?, telefon=?  WHERE \"tcNo\" = ?";
            PreparedStatement pst = conn.prepareStatement(updateQuery);
            pst.setString(1, ad);
            pst.setString(2, soyad);
            pst.setString(3, email);
            pst.setString(4, adres);
            pst.setString(5, cinsiyet);
            pst.setString(6, tcNo);
            pst.setString(7, telefon);
            pst.setString(8, tcNo);
            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Müşteri bilgileri güncellendi!");
                txt_musteriAd.setText("");
                txt_musteriSoyad.setText("");
                txt_musteriEmail.setText("");
                txt_musteriAdres.setText("");
                txt_musteriTc.setText("");
                txt_musteriTel.setText("");
                cbx_musteri.setSelectedIndex(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btn_musteriGuncelleMouseClicked

    private void btn_musteriSilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_musteriSilMouseClicked

    }//GEN-LAST:event_btn_musteriSilMouseClicked

    private void lbl_musteriListeleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_musteriListeleMouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel) MusteriTable.getModel();
            model.setRowCount(0);
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
                model.addRow(dataTable);
                TabbPanel.setSelectedIndex(5);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_lbl_musteriListeleMouseClicked

    private void lbl_homePage15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homePage15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_homePage15MouseClicked

    private void txt_musteriTcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_musteriTcFocusGained
        txt_musteriTc.setText("");
    }//GEN-LAST:event_txt_musteriTcFocusGained

    private void txt_musteriTcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_musteriTcFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_musteriTcFocusLost

    private void btn_musteriSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_musteriSilActionPerformed
        String tcNo = txt_musteriTc.getText();

        try {
            conn = DBConnect.connect();
            String deleteQuery = "DELETE FROM public.\"Musteriler\" WHERE \"tcNo\"=?";
            PreparedStatement pst = conn.prepareStatement(deleteQuery);
            pst.setString(1, tcNo);
            int result = pst.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Müşteri silme işlemi başarılı!");
                txt_musteriAd.setText("");
                txt_musteriSoyad.setText("");
                txt_musteriEmail.setText("");
                txt_musteriTel.setText("");
                txt_musteriAdres.setText("");
                txt_musteriTc.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btn_musteriSilActionPerformed

    private void btn_musteriGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_musteriGuncelleActionPerformed

    }//GEN-LAST:event_btn_musteriGuncelleActionPerformed
    int newtotal;
    String fiyat;

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
            java.util.logging.Logger.getLogger(HomeTabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeTabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeTabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeTabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeTabPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MusteriTable;
    private javax.swing.JTabbedPane TabbPanel;
    private javax.swing.JTable UrunTable;
    private javax.swing.JTable UsersTable;
    private javax.swing.JPanel anasayfa;
    private javax.swing.JButton btn_anasayfa;
    private javax.swing.JButton btn_bul;
    private javax.swing.JButton btn_cikis;
    private javax.swing.JButton btn_ekle;
    private javax.swing.JButton btn_fatura;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_kullanici;
    private javax.swing.JButton btn_musteri;
    private javax.swing.JButton btn_musteriBul;
    private javax.swing.JButton btn_musteriEkle;
    private javax.swing.JButton btn_musteriGuncelle;
    private javax.swing.JButton btn_musteriSil;
    private javax.swing.JButton btn_sil;
    private javax.swing.JButton btn_urun;
    private javax.swing.JButton btn_urunBul;
    private javax.swing.JButton btn_urunEkle;
    private javax.swing.JButton btn_urunGuncelle;
    private javax.swing.JButton btn_urunListele;
    private javax.swing.JButton btn_urunSil;
    private javax.swing.JComboBox<String> cbx_kullanici;
    private javax.swing.JComboBox<String> cbx_musteri;
    private javax.swing.JComboBox<String> cbx_urun;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel kullaniciIslemleri;
    private javax.swing.JPanel kullaniciList;
    private javax.swing.JLabel lbl_faturalar;
    private javax.swing.JLabel lbl_homePage10;
    private javax.swing.JLabel lbl_homePage11;
    private javax.swing.JLabel lbl_homePage12;
    private javax.swing.JLabel lbl_homePage13;
    private javax.swing.JLabel lbl_homePage14;
    private javax.swing.JLabel lbl_homePage15;
    private javax.swing.JLabel lbl_homePage3;
    private javax.swing.JLabel lbl_homePage4;
    private javax.swing.JLabel lbl_homePage5;
    private javax.swing.JLabel lbl_homePage6;
    private javax.swing.JLabel lbl_homePage7;
    private javax.swing.JLabel lbl_homePage8;
    private javax.swing.JLabel lbl_homePage9;
    private javax.swing.JLabel lbl_kullanicilar;
    private javax.swing.JLabel lbl_listele;
    private javax.swing.JLabel lbl_musteriListele;
    private javax.swing.JLabel lbl_musteriler;
    private javax.swing.JLabel lbl_urunler;
    private javax.swing.JPanel musteri;
    private javax.swing.JPanel musteriList;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_musteriAd;
    private javax.swing.JTextField txt_musteriAdres;
    private javax.swing.JTextField txt_musteriEmail;
    private javax.swing.JTextField txt_musteriSoyad;
    private javax.swing.JTextField txt_musteriTc;
    private javax.swing.JTextField txt_musteriTel;
    private javax.swing.JTextField txt_sifre;
    private javax.swing.JTextField txt_soyad;
    private javax.swing.JTextField txt_urunAciklama;
    private javax.swing.JTextField txt_urunAd;
    private javax.swing.JTextField txt_urunAdet;
    private javax.swing.JTextField txt_urunFiyat;
    private javax.swing.JTextField txt_urunId;
    private javax.swing.JPanel urun;
    private javax.swing.JPanel urunList;
    // End of variables declaration//GEN-END:variables
}
