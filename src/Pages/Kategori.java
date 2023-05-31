/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pages;

/**
 *
 * @author VKFGLB
 */
public class Kategori {
    private int id;
    private String ad;

    public Kategori(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    @Override
    public String toString() {
        return ad; // Combobox'ta göstermek için toString() ile yazdık.
    }
}

