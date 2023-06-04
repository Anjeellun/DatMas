/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datmas;

/**
 * 3337210040
 * Anjeli Gusnawan
 */

import java.util.Scanner;

public class Running {
    private static final Scanner input = new Scanner(System.in);
    private static MahasiswaCRUD dao;

    public static void main(String[] args) {
        dao = new MahasiswaCRUD("mahasiswa.ser");
        int choice = 0;
        do {
            printMenu();
             System.out.print("\nMasukkan menu pilihan anda: \n");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    perbaruiMahasiswa();
                    break;
                case 4:
                    hapusMahasiswa();
                    break;
                case 5:
                    dao.saveMahasiswas();
                    System.out.println("\nData mahasiswa berhasil disimpan.\n");
                    System.out.println("\nTerima kasih!\n");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid.\n");
                    break;
            }
        } while (choice != 5);
    }

    private static void printMenu() {
        System.out.println("\nSilakan pilih operasi yang diinginkan:\n");
        System.out.println("1. Tambah data mahasiswa");
        System.out.println("2. Tampilkan data mahasiswa");
        System.out.println("3. Perbarui data mahasiswa");
        System.out.println("4. Hapus data mahasiswa");
        System.out.println("5. Simpan data mahasiswa dan keluar");
    }

    private static void tambahMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Asal: ");
        String asal = input.nextLine();
        System.out.print("Masukkan Kelas Praktikum: ");
        String kelas = input.nextLine();

        DataMahasiswa mhs = new DataMahasiswa(nim, nama, asal, kelas);
        dao.insertMahasiswa(mhs);
        System.out.println("\nData mahasiswa berhasil ditambahkan.");
    }

    private static void tampilkanMahasiswa() {
        dao.printMahasiswa();
    }

    private static void perbaruiMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin diperbarui: ");
        String nim = input.nextLine();
        System.out.print("Masukkan Nama baru: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Asal baru: ");
        String asal = input.nextLine();
        System.out.print("Masukkan Kelas Praktikum baru: ");
        String kelas = input.nextLine();

        DataMahasiswa mhs = new DataMahasiswa(nim, nama, asal, kelas);
        dao.updateMahasiswa(mhs);
        System.out.println("\nData mahasiswa berhasil diperbarui.");
    }

    private static void hapusMahasiswa() {
        System.out.print("\nMasukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = input.nextLine();

        dao.deleteMahasiswa(nim);
        System.out.println("\nData mahasiswa berhasil dihapus.");
    }
}
