

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
 // -starWarsProject: khởi tạo của sổ 
public class starWarsProject extends JFrame {
// Thiet lap cac cua
    final static int ARow = 5,ACol = 0, BRow = 0,BCol = 4,CRow = 0,CCol = 12,DRow = 5,DCol = 13,ERow = 10,ECol = 4;

    public starWarsProject(String title) throws HeadlessException {
        super(title);

    }

    public static ArrayList<Character> chr = new ArrayList<Character>();// mang dong chua cac nhan vat
    public ArrayList<Character> getCharacters() {
        return starWarsProject.chr;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        // đọc file bản đồ
        File harita = new File("harita.txt");
        int row = 0, i, j = 0;
        byte stormtrooperNum = 0, darthVaderNum = 0, kyloRenNum = 0;
        int[][] map = new int[11][14];
        String[] output = null;

        if (!harita.exists()) {// check file co ton tai hay khong
            System.out.println(harita.getName() + " Không tìm thấy tệp tin");
            System.exit(0); // thoat ra
        }

        BufferedReader reader = null; // duoc su dung de doc van ban tu luong dau vao nhu tep
        FileReader forMap = null; // duoc su dung de doc du lieu tu file harita
        try {
            reader = new BufferedReader(new FileReader(harita));
            forMap = new FileReader("harita.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(starWarsProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        String line = reader.readLine();

        while (!(line.startsWith("0") || line.startsWith("1"))) { // chay neu chuoi khong bat dau bang 0 hoac bat dau bang 1
            if (line.length() > 0) { // kiem tra xem do dai cua chuoi co lon hon 0
                row++;
                output = line.split("[,:]");
                System.out.println(output[1]); // tra ve ket qua ten nhan vat
                System.out.println(output[3]); // tra ve vi tri cua nhan vat
                
                /* Kiểm tra nếu phần tử thứ 2 của mảng "output" bằng "stormtrooper" thì sẽ tạo một đối tượng "Stormtrooper" và thêm vào danh sách "chr".
                 * Nếu phần tử thứ 2 của mảng "output" bằng "darth vader" thì sẽ tạo một đối tượng "DarthVader" và thêm vào danh sách "chr".
                 * Nếu phần tử thứ 2 của mảng "output" bằng "kylo ren" thì sẽ tạo một đối tượng "KyloRen" và thêm vào danh sách "chr". 
                 * Các đối tượng này sẽ được tạo dựa trên các giá trị trong mảng "output", bao gồm tọa độ của vị trí của đối tượng.
                 * 
                 */
                if (output[1].equalsIgnoreCase("stormtrooper")) {
                    if (output[3].equalsIgnoreCase("a")) {
                        chr.add(new Stormtrooper("Stormtrooper " + stormtrooperNum, "kotu", ARow, ACol,ARow, ACol));
                        stormtrooperNum++;
                    } else if (output[3].equalsIgnoreCase("b")) {
                        chr.add(new Stormtrooper("Stormtrooper " + stormtrooperNum, "kotu", BRow, BCol, BRow, BCol));
                        stormtrooperNum++;
                    } else if (output[3].equalsIgnoreCase("c")) {
                        chr.add(new Stormtrooper("Stormtrooper " + stormtrooperNum, "kotu", CRow, CCol, CRow, CCol));
                        stormtrooperNum++;
                    } else if (output[3].equalsIgnoreCase("d")) {
                        chr.add(new Stormtrooper("Stormtrooper " + stormtrooperNum, "kotu", DRow, DCol,DRow, DCol));
                        stormtrooperNum++;
                    } else if (output[3].equalsIgnoreCase("e")) {
                        chr.add(new Stormtrooper("Stormtrooper " + stormtrooperNum, "kotu", ERow, ECol,ERow, ECol));
                        stormtrooperNum++;
                    }

                } else if (output[1].equalsIgnoreCase("darth vader")) {
                      darthVaderNum++;
                    if (output[3].equalsIgnoreCase("a")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", ARow, ACol, ARow, ACol));
                        darthVaderNum++;
                    } else if (output[3].equalsIgnoreCase("b")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", BRow, BCol, BRow, BCol));
                        darthVaderNum++;
                    } else if (output[3].equalsIgnoreCase("c")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", CRow, CCol,CRow, CCol));
                        darthVaderNum++;
                    } else if (output[3].equalsIgnoreCase("d")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", DRow, DCol,DRow, DCol));
                        darthVaderNum++;
                    } else if (output[3].equalsIgnoreCase("e")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", ERow, ECol, ERow, ECol));
                        darthVaderNum++;
                    }

                } else if (output[1].equalsIgnoreCase("kylo ren")) {
                  if (output[3].equalsIgnoreCase("a")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", ARow, ACol, ARow, ACol));
                        kyloRenNum++;
                    } else if (output[3].equalsIgnoreCase("b")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", BRow, BCol, BRow, BCol));
                        kyloRenNum++;
                    } else if (output[3].equalsIgnoreCase("c")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", CRow, CCol, CRow, CCol));
                        kyloRenNum++;
                    } else if (output[3].equalsIgnoreCase("d")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", DRow, DCol,DRow, DCol));
                        kyloRenNum++;
                    } else if (output[3].equalsIgnoreCase("e")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", ERow, ECol,ERow, ECol));
                        kyloRenNum++;
                    }
                }
            }
            line = reader.readLine();
        }

        try {

            int value, say = 1;
            //biến say được gán để tính số cột.
            i = 0;
            while ((value = forMap.read()) != -1) { // kiem tra neu ki tu duoc doc khong phai la ky tu cuoi cung cua mang(ma ASCII)
                if (value == '0' || value == '1') {
                    if (value == 48) { // neu value = 48 (trong ASCII) => 0
                        map[i][j] = 0;
                    } else {
                        map[i][j] = 1;
                    }

                    say++; // so cot tang, bien vi tri j tang
                    j++;
                    if (say == 15) { // neu so cot 15 => gan so cot tro lai bang 1
                        say = 1;
                        // đặt lại giá trị cột = 0
                        j = 0; 
                        i++; // tang hang len +1
                    }
                }

            }
        } finally {
            forMap.close();
        }

        for (i = 0; i < 11; i++) {
            for (j = 0; j < 14; j++) {
                System.out.print(map[i][j] + "\t"); // in ra ma tran
            }
            System.out.println();
        }


  //      System.out.println("\n Số dòng  " + row);

        System.out.println("NHÂN VẬT:\nCác chỉ số sức mạnh của Master Yoda bị giảm một nửa. Hãy nhấn phím 'M' để chọn Master Yoda.\nLuke Skywalker không có bất kỳ đặc điểm đặc biệt nào.Hãy nhấn phím 'S' để chọn Luke Skywalker.");
        System.out.println("\nBắt đầu chọn nhân vật !\nLựa Chọn:");
        String gamerchr = input.nextLine();

        if (gamerchr.equalsIgnoreCase("m")) { // neu chon nhan vat la masterYoda
            chr.add(new MasterYoda("MasterYoda", "Iyi", 6,5,6,5,6)); // add nhan vat maater yoda voi vi tr da chi dinh
        } else if (gamerchr.equalsIgnoreCase("s")) {
            chr.add(new LukeSkywalker("LukeSkywalker", "Iyi", 3,5,6,5,6));
        } else {
            while (!(gamerchr.equalsIgnoreCase("m") || gamerchr.equalsIgnoreCase("s"))) { // ky tu dc nhap vao khong phai la 2 nhan vat dc thiet lap
                System.out.println("Lutfen S ya da M harfi giriniz!");
                gamerchr = input.nextLine(); // yeu cau nhap lai
                if (gamerchr.equalsIgnoreCase("m")) {
                    chr.add(new MasterYoda("MasterYoda", "Iyi", 6,5,6,5,6));
                } else if (gamerchr.equalsIgnoreCase("s")) {
                    chr.add(new LukeSkywalker("LukeSkywalker", "Iyi", 3,5,6,5,6));
                }
            }

        }

        Graphic graphic = new Graphic();
        graphic.grphcChr = chr; // mang nhan vat chua thong tin cua cac nhan vat duoc gui den do hoa
        /* Mảng bản đồ chứa thông tin vị trí bản đồ được gửi đến lớp Đồ họa */
        graphic.grphcMap = map;

        starWarsProject screen = new starWarsProject("Star Wars");
        screen.setSize(700, 700);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphic.requestFocus();
        graphic.addKeyListener(graphic);
        graphic.setFocusable(true);
        graphic.setFocusTraversalKeysEnabled(false);
        screen.add(graphic);
        screen.setVisible(true);
        screen.setResizable(false);
        graphic.choosenCharacter = gamerchr;
        for(i=0;i<chr.size()-1;i++) // mang dong chia cac nhan vat
        {
        	// goi den vi tri cua tung nhan vat trong ma tran
        	chr.get(i).shortestPath(map, chr.get(i).location.getMatrixRow(),chr.get(i).location.getMatrixCol(), chr.get(chr.size() - 1).getLocation().matrixRow, chr.get(chr.size() - 1).getLocation().matrixCol);
        }
        
    }
    
}