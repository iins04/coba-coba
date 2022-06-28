/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LayananEdukasiBertani;

/**
 *
 * @author ACER
 */
public class Data {
    int banyak;
    String Tanggal_Simpan;
    String nomorr;
    String Pilihan_Informasi;
    String Jenis_Informasi;
    Double[] element;


    String Nomor;
    String Tanggal;
    String PilihanInformasi;
    String Jenis;
    
    public Data(String a, String b, String c, String d) {
        this.Nomor = a;
        this.Tanggal = b;
        this.PilihanInformasi = c;
        this.Jenis = d;  
    }

    Data(String _juli_2003) {
      
    }


    Data() {
      
    }

    
    public String getNomor() {
        return Nomor;
    }
    
    public void setNomor(String Nomor){
        this.Nomor = Nomor;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }

    public String getPilihanInformasi() {
        return PilihanInformasi;
    }

    public void setPilihanInformasi(String PilihanInformasi) {
        this.PilihanInformasi = PilihanInformasi;
    }
    

    void setMateri_video(String newValue) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setJenisEdukasi(String newValue) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String Jenis) {
        this.Jenis = Jenis;
    }

    void tambah(String temp1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
}
