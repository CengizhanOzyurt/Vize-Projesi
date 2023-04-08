import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        dosyayaz nesne = new dosyayaz();
        dosyayaz nesne2 = new dosyayaz();
        dosyaoku nesne3 = new dosyaoku();
        nesne.DosyaYaz("#ELİT UYELER#\n");
        nesne2.DosyaYaz2("#GENEL UYELER#\n");
        Scanner veri = new Scanner(System.in);
        Scanner veri2 = new Scanner(System.in);
        String islemler = "**********Uye Islemleri*************\n" + "1-Elit uye ekleme\n" + "2-Genel uye ekleme\n"
                + "3-Mail gonderme\n" + "4-cikis";
        String islemler2 = "**********Mail Islemleri************\n" + "1-Elit uyelere mail\n" + "2-Genel uyelere mail\n"
                + "3-Tum uyelere mail";
        int islem = 0;
        while (islem != 4) {
            System.out.println(islemler);
            System.out.println("islem seciniz");
            islem = veri.nextInt();

            switch (islem) {
                case 1:
                    // Elit uyelik islemlerinin yapıldığı bölüm
                    System.out.println("Uyenin adı:");
                    veri.nextLine();
                    String euad = veri2.nextLine();
                    System.out.println("Uyenin soyadi:");
                    String eusoy = veri2.nextLine();
                    System.out.println("Uyenin maili:");
                    String eumail = veri2.nextLine();
                    nesne.DosyaYaz(euad + "\t" + eusoy + "\t" + eumail + "\n");
                    break;
                case 2:
                    // Genel uyelik islemlerinin yapıldığı bölüm
                    System.out.println("Uyenin adı:");
                    veri.nextLine();
                    String guad = veri.nextLine();
                    System.out.println("Uyenin soyadi:");
                    String gusoy = veri.nextLine();
                    System.out.println("Uyenin maili:");
                    String gumail = veri.nextLine();
                    nesne2.DosyaYaz2(guad + "\t" + gusoy + "\t" + gumail + "\n");
                    break;
                case 3:
                    //Mail islemlerinin yapıldığı bölüm
                    System.out.println("Suanda hizmet veremiyoruz 4'u tuslayarak cıkıs yapabilirsiniz.");
                    System.out.println(islemler2);
                    System.out.println("islem seciniz:");
                    int islem2 = veri2.nextInt();
                    switch (islem2) {
                        case 1:
                            break;
                        case 2:

                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        // İkinci dosyanın okunup ilk dosyaya getirildiği method
        File Kaynakdosya = new File("uyeler2.txt");
        File Hedefdosya = new File("Kullanicilar.txt");
        nesne3.dosyaKopyala(Kaynakdosya, Hedefdosya);
        System.out.println("Bilgiler basariyla 'Kullanicilar.txt' dosyasina kaydolmustur.");
    }
}

// Dosya veri girişinin yapıldığı class
class dosyayaz extends Main {
    public void DosyaYaz(String metin) {
        File dosya = new File("Kullanicilar.txt");

        try {

            FileWriter yazar = new FileWriter(dosya, true);
            BufferedWriter yaz = new BufferedWriter(yazar);

            yaz.write(metin);
            yaz.close();
        } catch (Exception hata) {
            hata.printStackTrace();
        }
    }

    public void DosyaYaz2(String metin2) {
        File dosya2 = new File("uyeler2.txt");

        try {

            FileWriter yazar2 = new FileWriter(dosya2, true);
            BufferedWriter yaz2 = new BufferedWriter(yazar2);

            yaz2.write(metin2);
            yaz2.close();
        } catch (Exception hata) {
            hata.printStackTrace();
        }
    }

}

//Dosya okumasının yapıldığı class
class dosyaoku extends Main {
    public void dosyaKopyala(File Kaynakdosya, File Hedefdosya) {
        try {
            int veri = 0;
            FileInputStream fis = new FileInputStream(Kaynakdosya);
            BufferedInputStream okur = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream(Hedefdosya, true);
            BufferedOutputStream yazici = new BufferedOutputStream(fos);

            while ((veri = okur.read()) != -1) {
                byte veri2 = (byte) veri;
                yazici.write(veri2);

            }
            yazici.close();
            okur.close();
        } catch (Exception e) {
            System.out.println("Hata Kopyalama Başarısız");
            e.printStackTrace();
        }
    }
}