import java.math.MathContext;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chucnang {
    Scanner scanner = new Scanner(System.in);
    ArrayList<User> user ;

    public Chucnang(){
        this.user= new ArrayList<>();
    }

    public Chucnang(ArrayList<User> user) {
        this.user = user;
    }

    // danh sach tai khoan ban đầu
    public void themtaikhoan(User user){
        this.user.add(user);
    }
    String  userName;
    //đăng nhập 
    public int dangnhap1 (){
        System.out.println("moi thong tin user");
     userName = scanner.nextLine();
           System.out.println("moi thong tin passwors");
          String password = scanner.nextLine();
        for (User user2 : user) {
            if( userName.equals(user2.getUserName())&& password.equals(user2.getPassword())){
                System.out.println("Chào mừng "+userName+", bạn có thể thực hiện các công việc sau:");

                return 1;

            }else{
                if(userName.equals(user2.getUserName())){
                    System.out.println(" sai password");
                    return 3;
                  
                }else {
                    System.out.println("sai username ");
                    return 2;
                }
            }     
        }
        return 0;
    }
    // thay đổi  username
    public void thaydoiuser (){
         System.out.println("nhap user moi");
    String  userNamemoii = scanner.nextLine();
           
          
        for (User user2 : user) {
            if(user2.getUserName().equals(userName)){
                user2.setUserName(userNamemoii);    
            }
        }
       
    }

    // thay đổi password
    public void thaydoimk (){
        System.out.println("nhap password moi");
        String  lpasswordmoi = scanner.nextLine();
        
        for (User user2 : user) {
            if(user2.getUserName().equals(userName)){
                user2.setPassword(lpasswordmoi);   
            }
        }
       
    }

    //thay đổi  email
    public void thaydoiamail (){
        System.out.println("nhap email moi");
        String  emailmoi = scanner.nextLine();
        for (User user2 : user) {
            if(user2.getUserName().equals(userName)){
                user2.setUserName(emailmoi);    
            }
        }
       
    }

    //in danh sách user
    public void show(){
        for (User user2 : user) {
            user2.xuatDSuser();

        }
    }

    // quên password
    public void quenpassword(){
        System.out.println("moi ban nhap email");
                  String email = scanner.nextLine();
        for (User user2 : user) {
            if(user2.getEmail().equals(email)){
                System.out.println("nhap password moi");
                String passwordmoi = scanner.nextLine();
                user2.setPassword(passwordmoi);   
            }else{
                System.out.println( " email khong dung");
               
            }
        }


    }
    // tạo tài khoản mới
    public void taotaikhoanmoi(){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
    System.out.println(" moi ban nhap username ");
    String usernamemoi = scanner.nextLine();
    for (User user2 : user) {
        if(user2.getUserName().equals(usernamemoi)){
            System.out.println("da ton tai user");
            System.out.println(" vui long nhap lai user");
            usernamemoi = scanner.nextLine();
        }
        
    }
    
    System.out.println(" moi ban nhap email ");
    String emailmoi = scanner.nextLine();
    Matcher matcher = pattern.matcher(emailmoi);
    if(matcher.matches()==false){
        System.out.println("sai dinh dang emai ");
        System.out.println(" vui long nhap lai email");
        emailmoi = scanner.nextLine();

    }
    
    System.out.println(" moi ban nhap password ");
    String passwordmoi = scanner.nextLine();
    String dinhdangpw  = "(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{7,15}";
    if(passwordmoi.matches(dinhdangpw)==false){
        System.out.println( "mat khau sai dinh dang");
        System.out.println( "nhap lai mat khau");
         passwordmoi = scanner.nextLine();
    }
    //tài khoản mới
    User usermoi = new User(usernamemoi, emailmoi, passwordmoi);
    user.add(usermoi);

   




    }
}
