/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datmas;

/**
 *
 * @author ASUS
 */
import java.io.*;
import java.util.ArrayList;

public class MahasiswaCRUD {
    private ArrayList<DataMahasiswa> mahasiswas;
    private final File file;

    public MahasiswaCRUD(String fileName) {
        mahasiswas = new ArrayList<>();
        file = new File(fileName);
        if (file.exists()) {
            readMahasiswas();
        }
    }

    public ArrayList<DataMahasiswa> getMahasiswas() {
        return mahasiswas;
    }

    public void setMahasiswas(ArrayList<DataMahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    public void insertMahasiswa(DataMahasiswa mahasiswa) {
        mahasiswas.add(mahasiswa);
    }

    public void updateMahasiswa(DataMahasiswa mahasiswa) {
        for (DataMahasiswa mhs : mahasiswas) {
            if (mhs.getNim().equals(mahasiswa.getNim())) {
                mhs.setNama(mahasiswa.getNama());
                mhs.setAsal(mahasiswa.getAsal());
                mhs.setKelasPraktikum(mahasiswa.getKelasPraktikum());
                break;
            }
        }
    }

    public void deleteMahasiswa(String nim) {
        for (DataMahasiswa mhs : mahasiswas) {
            if (mhs.getNim().equals(nim)) {
                mahasiswas.remove(mhs);
                break;
            }
        }
    }

    public void printMahasiswa() {
        System.out.println("-----------------------");
        System.out.println("Daftar Mahasiswa:");
        for (DataMahasiswa mhs : mahasiswas) {
            System.out.println("NIM: " + mhs.getNim());
            System.out.println("Nama: " + mhs.getNama());
            System.out.println("Asal: " + mhs.getAsal());
            System.out.println("Kelas: " + mhs.getKelasPraktikum());
            System.out.println("-----------------------");
        }
    }

    public void saveMahasiswas() {
        try {
            try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(mahasiswas);
            }
        } catch (IOException e) {
        }
    }

    @SuppressWarnings("unchecked")
    private void readMahasiswas() {
        try {
            try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
                mahasiswas = (ArrayList<DataMahasiswa>) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
