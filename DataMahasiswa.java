/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package datmas;

/**
 * 3337210040
 * Anjeli Gusnawan
 */


import java.io.Serializable;

public class DataMahasiswa implements Serializable {
    private String nim;
    private String nama;
    private String asal;
    private String kelasPraktikum;

    public DataMahasiswa(String nim, String nama, String asal, String kelasPraktikum) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
        this.kelasPraktikum = kelasPraktikum;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    public String getKelasPraktikum() {
        return kelasPraktikum;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public void setKelasPraktikum(String kelasPraktikum) {
        this.kelasPraktikum = kelasPraktikum;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim='" + nim + '\'' +
                ", nama='" + nama + '\'' +
                ", asal='" + asal + '\'' +
                ", kelasPraktikum='" + kelasPraktikum + '\'' +
                '}';
    }
}
