import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //khai báo 
        User user1 = new User("dangnhap1", "vudung1@gmail.com", "vudung1");
        User user2 = new User("dangnhap2", "vudung2@gmail.com", "vudung2");
        User user3 = new User("dangnhap3", "vudung3@gmail.com", "vudung3");
        User user4 = new User("dangnhap4", "vudung4@gmail.com", "vudung4");
        User user5 = new User("dangnhap5", "vudung5@gmail.com", "vudung5");
        Scanner scanner = new Scanner(System.in);

        //tạo mảng vào thêm giá trị
        ArrayList<User> users = new ArrayList<>();
        Chucnang chucnang = new Chucnang();

        chucnang.themtaikhoan(user1);
        chucnang.themtaikhoan(user2);
        chucnang.themtaikhoan(user3);
        chucnang.themtaikhoan(user4);
        chucnang.themtaikhoan(user5);
        
        boolean cunt = true;
        do {
            System.out.println("chon chuc nang ");
            System.out.println("1  dang nhap ");
            System.out.println("2  dang ki ");

            String userName;

            int chon = scanner.nextInt();
            switch (chon) {
                case 1://đăng nhập
                    int check = chucnang.dangnhap1();
                    if (check == 1) {

                        System.out.println("1  Thay đổi username");
                        System.out.println("2  Thay đổi email");
                        System.out.println("3  Thay đổi password");
                        System.out.println("4   xuat danh sach user");
                        System.out.println("5  dang xuat");
                        System.out.println("0  exit");
                        int chon1 = scanner.nextInt();
                        //chọn 1 trong các chức năng sau khi đăng nhập thành công
                        switch (chon1) {
                            case 1:
                                chucnang.thaydoiuser();

                                break;
                            case 2:
                                chucnang.thaydoiamail();
                                break;

                            case 3:
                                chucnang.thaydoimk();
                                break;
                            case 4:
                        
                                System.out.printf("%-12s%-20s%-12s\n", "username", "email", "password");
                            chucnang.show();
                                break;

                            case 5:
                                cunt = true;
                                break;

                            case 0:
                                cunt = false;

                            default:
                                break;
                        }

                    } else {//đăng nhập không thành công
                        if (check == 2) {//nhập sai username
                            chucnang.dangnhap1();

                        } else {//nhập sai mật khẩu
                            System.out.println("  1 dang nhap  lai ");
                            System.out.println("  2 quen mat khau ");
                            int chon2 = scanner.nextInt();
                            switch (chon2) {
                                case 1:
                                    chucnang.dangnhap1();

                                    break;

                                case 2:
                                    chucnang.quenpassword();
                                    break;

                                default:
                                    break;
                            }

                        }

                    }

                    break;
                case 2://đăng kí
                
                    chucnang.taotaikhoanmoi();
                    break;

                default:
                    break;
            }

        } while (cunt);

    }
}
