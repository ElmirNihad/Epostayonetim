import java.util.Scanner;

public class eposta {
        private String isim;
        private String soyisim;
        private String birim;
        private String eposta;
        private String sifre;
        private String epostaelave;
        public eposta() {
            Scanner input = new Scanner(System.in);
            System.out.print("Isminizi Giriniz : ");
            isim = input.nextLine();
            System.out.print("Soyisminizi Giriniz : ");
            soyisim = input.nextLine();
            System.out.println("Isim ve Soyisim : " +isim + " " + soyisim);
            birimbilgisi();
            System.out.println("Biriminiz : " + birim);
            epostaolusdur();
            System.out.println("Epostaniz : " + eposta);
            sifreolusdur();
            System.out.println("Sifreniz : " + sifre);
            yenisifre();
            alternativ();
            System.out.println(toString());
        }
        private String birimbilgisi(){
            Scanner input = new Scanner(System.in);
            System.out.println("Birimler : \n1 - Pazarlama\n2 - Gelisdirme\n3 - Muhasebe ");
            System.out.print("Biriminizi seciniz : ");
            String secilenbirim = input.nextLine();
            switch (secilenbirim){
                case "1":
                    birim = "Pazarlama";
                    break;
                case "2":
                    birim = "Gelisdirme";
                    break;
                case "3":
                    birim = "Muhasebe";
                    break;
                default:
                    System.out.println("Yalnis giris,lutfen tekrar deneyiniz");
                    birimbilgisi();
            }
            return birim;
        }
        private String sifreolusdur(){
            String karakterler = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789!@#$%%^&*,.";
            sifre ="";
            for (int i = 0; i < 8; i++){
                int rastgelesayi = (int)(Math.random() * karakterler.length());
                sifre = sifre + karakterler.charAt(rastgelesayi);
            }
            return sifre;
        }
        private String epostaolusdur(){
            String yeniad = isim.toLowerCase().replaceAll(" ","");
            String yenisoyisim = soyisim.toLowerCase().replaceAll(" ","");
            String yenibirim = birim.toLowerCase().replaceAll(" ","");
            eposta = yeniad + yenisoyisim + "@" + yenibirim + ".qateam04.com";
            eposta.trim();
            return eposta;
        }
        public void yenisifre(){
            Scanner input = new Scanner(System.in);
            String sifre2 = "";
            System.out.print("Sifrenizi degisdirmek istermisiniz ?(E/H)");
            String yanit = input.nextLine().toUpperCase();
            if (yanit.equals("E")){
                System.out.print("Yeni sifrenizi giriniz (en az 8 haneli) : ");
                String yeni = input.nextLine();
                sifre = yeni;
                if (sifre.length() < 8){
                    System.out.println("Sifreniz azi 8 haneli olmali!!!");
                    yenisifre();
                }
                System.out.print("Sifrenizi tekrar giriniz : ");
                sifre2 = input.nextLine();
                if (sifre.equals(sifre2)) {
                    System.out.println("Sifreniz degisdirildi !");
                    System.out.println("Yeni sifreniz : " + sifre);
                }else {
                    System.out.println("Yeni sifrenizi dogru girdiginize dikkat edin !,sifre degisdirilmedi");
                    yenisifre();
                }
            }else if (yanit.equals("H")){

            }else {
                System.out.println("Yalnis giris!");
                yenisifre();
            }
        }
        public void alternativ(){
            Scanner input = new Scanner(System.in);
            System.out.print("Alternativ eposta adresinizi giriniz : ");
            epostaelave = input.nextLine();
            String elave2=epostaelave.substring(1,epostaelave.length()-1);
            if (elave2.contains("@")){
                System.out.println("Alternativ eposta adresiniz : " + epostaelave);
            }else {
                System.out.println("Gecersiz eposta adresi,lutfen tekrar deneyiniz");
                alternativ();
            }
        }

        @Override
        public String toString() {
            return "eposta{" +
                    "isim='" + isim + '\'' +
                    ", soyisim='" + soyisim + '\'' +
                    ", birim='" + birim + '\'' +
                    ", eposta='" + eposta + '\'' +
                    ", sifre='" + sifre + '\'' +
                    ", epostaelave='" + epostaelave + '\'' +
                    '}';
        }
    }

