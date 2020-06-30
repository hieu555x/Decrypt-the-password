import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            // Nhập file Input
            System.out.print("Nhập đường dẫn file input:");
            String s = sc.nextLine();
            File file = new File(s);
            String s1 = "";
            while (!file.exists()) {
                System.out.print("Nhập sai nhập lại:");
                s = sc.nextLine();
                file = new File(s);
            }
            FileInputStream input = new FileInputStream(file);
            int c = input.read();
            while (c != -1) {
                s1 = s1 + (char) c;
                c = input.read();
            }
            input.close();
            // Dữ liệu của file đã được lưu vào biến s1

            // Nhập file chia khoa
            System.out.print("Nhập đường dẫn file chiakhoa:");
            s = sc.nextLine();
            File file1 = new File(s);
            String s2 = "";
            while (!file1.exists()) {
                System.out.print("Không tồn tại vui lòng nhập lại:");
                s = sc.nextLine();
                file1 = new File(s);
            }
            FileInputStream input1 = new FileInputStream(file1);
            c = input1.read();
            while (c != -1) {
                s2 = s2 + (char) c;
                c = input1.read();
            }
            input1.close();
            int hang = s1.split("\n").length;

            // Xử lý file chia khoa
            String[] chuoiKhoa = new String[s2.split("\n")[1].split(" ").length];
            int[] chiaKhoa = new int[s2.split("\n")[1].split(" ").length];
            for (int i = 0; i < s2.split("\n")[1].split(" ").length; i++) {
                chiaKhoa[i] = Integer.valueOf(s2.split("\n")[1].split(" ")[i]);
            }

            // Xử lý file Input
            String output = "";
            for (int i = 0; i < hang; i++) {
                output = output + s1.split("\n")[i].split("")[chiaKhoa[i]];
            }

            // Nhập kết quả vào file output
            System.out.print("Nhập nơi lưu file output:");
            s = sc.nextLine();
            file = new File(s + "\\output.txt");
            FileOutputStream fileOutput = new FileOutputStream(file);
            fileOutput.write(output.getBytes());
            System.out.println("Hoàn thành!!");
            fileOutput.close();
        } catch (Exception e) {
            System.out.print("Lỗi là " + e.getMessage() + "\n");
        }
    }
}