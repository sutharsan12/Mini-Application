import java.util.*;
class Railwaybooking
{
    public static Scanner sc=new Scanner(System.in);

    static List<String> username=new ArrayList<String>();//username
    static List<String> password=new ArrayList<String>();//password

    static List<String> username1 = new ArrayList<>();//username name
    static List<Integer> allotedseat = new ArrayList<>();//seat number
    static List<Integer> bookingidlist = new ArrayList<>();//seat number
    static List<String> startpoint = new ArrayList<>();//start point
    static List<String> landingpoint = new ArrayList<>();//landing point
    static List<Integer> startid = new ArrayList<>();//start location
    static List<Integer> landingid = new ArrayList<>();//landing location
    static List<String> status = new ArrayList<>();//seat status
    // waiting list
    static List<Integer> wstartid = new ArrayList<>();//start location
    static List<Integer> wlandingid = new ArrayList<>();//landing location
    static List<String> wusername1 = new ArrayList<>();//username name
    static List<Integer> wallotedseat = new ArrayList<>();//seat number
    static List<Integer> wbookingidlist = new ArrayList<>();//seat number
    static List<String> wstartpoint = new ArrayList<>();//start point
    static List<String> wlandingpoint = new ArrayList<>();//landing point
    static List<String> wstatus = new ArrayList<>();//seat status

    static String place[]={"Coimbatore","Tirupur","Dharapuram","Erode","Madurai","Salem","Chennai"};

    static int seat[][]=new int [10][7];
    static int waitseat[][]=new int [3][7];
    static int seatid=1;
    static int bookingid=1001;


    public static void user(){
        clearscreen();
        System.out.println();
        System.out.println("Welcome new User:");
        a1:while(true){
            System.out.println("Enter Username: ");
            String n=sc.next();
            sc.nextLine();
            int p=0;
            for(int i=0;i<username.size();i++){
                if(n.equals(username.get(i))){
                    System.out.println("name is already used try another name");
                    p=1;
                    break;
                }
            }
            if(p==0){
                username.add(n);
                break a1;
            }
        }
        a1:while(true){
            System.out.println("Enter password: ");
            String check=sc.next();
            sc.nextLine();
            int check1=0;
            for(int i=0;i<password.size();i++){
                if(check.equals(password.get(i))){
                    System.out.println("password is already used try another password");
                    System.out.println();
                    check1=1;
                    break;
                }
            }
            if(check1==0){
                password.add(check);
                break a1;
            }
        }
        System.out.println("User created sucessfully!.......");
        System.out.println();
        delay();
    }

    public static void booking(int i){
        ab:while(true){
            clearscreen();
            int seat1=-1;
            System.out.println("\tWelcome "+username.get(i));
            System.out.println();
            System.out.println(" 1.Coimbatore \n 2.Tirupur \n 3.Dharapuram \n 4.Erode \n 5.Madurai \n 6.Salem \n 7.Chennai \n 8.Exit");
            int start;
            while(true){
            System.out.println("Enter Starting Point....");
            start=sc.nextInt();
            if(start>0 && start<8){
                break;
            }else if(start==8){
                break ab;}
                else{
                System.out.println("Invalid Starting Point!......");
            }
            } 
            int landing; 
            while(true){
            System.out.println("Enter Landing Point...");
            landing=sc.nextInt();
            if(landing<8 && landing>start){
                break;
            }else if(landing==8){
                break ab;}else{
                System.out.println("Invalid Landing Point!......");
            }
            }
            int count =0;
            int check=0;
            int one=0;
            int seat2=0;
            a:while(one==0){
                one++;
               for(int j=0;j<10;j++){
                count =0;
                for(int t=0;t<7;t++){
                    if(t>=start-1 && t<landing){
                       count += seat[j][t];
                       check=t;
                    }
                }
                for(int t=start-1;t<check;t++){
                    if(count==0){
                        seat[j][t]=seatid;
                        seat1=j;
                        seat2=0;
                    }
                    
                }
                if(count==0){
                   
                    break a;
                }

            }
          
            for(int j=0;j<3;j++){
                count =0;
                for(int t=0;t<7;t++){
                    if(t>=start-1 && t<landing){
                       count += waitseat[j][t];
                       check=t;
                    }
                }
                for(int t=start-1;t<check;t++){
                    if(count==0){
                        waitseat[j][t]=seatid;
                        seat1=j;
                        seat2=1;
                    }
                    
                }
                if(count==0){
                   
                    break a;
                }

            }
            }
            seatid++;
            if(seat1!=-1 && seat2==0){
                username1.add(username.get(i));
                startpoint.add(place[start-1]);
                landingpoint.add(place[landing-1]);
                allotedseat.add(seat1+1);
                bookingidlist.add(bookingid);  
                startid.add(start);
                landingid.add(landing);
                status.add("Seat Alloted"); 

            System.out.println("Seat Alloted..... :"+(seat1+1));
            System.out.println("Booking id....... :"+bookingid);
            // for(int y=0;y<10;y++){
            //     for(int y1=0;y1<7;y1++){
            //         System.out.print(seat[y][y1]+" ");
                    
            //     }System.out.println();
            // }
            // System.out.println("ws");
            // for(int y=0;y<3;y++){
            //     for(int y1=0;y1<7;y1++){
            //         System.out.print(waitseat[y][y1]+" ");
                    
            //     }System.out.println();
            //  }
            bookingid++;
            }else if(seat1!=-1 && seat2==1){
                wusername1.add(username.get(i));
                wstartpoint.add(place[start-1]);
                wlandingpoint.add(place[landing-1]);
                wallotedseat.add(seat1+1);
                wbookingidlist.add(bookingid);
                wstartid.add(start);
                wlandingid.add(landing);
                wstatus.add("Seat Waitinglist"); 
                System.out.println("WaitSeat Alloted :"+(seat1+1));
                System.out.println("Booking id :"+bookingid);
                bookingid++;
                // for(int y=0;y<3;y++){
                //     for(int y1=0;y1<7;y1++){
                //         System.out.print(waitseat[y][y1]+" ");
                        
                //     }System.out.println();
                // }
                }
            else{
                System.out.println("Seat Unavailable!.........");
                System.out.println();
            }
            delay();
        }
    }

    public static void cancelling(int i){
        clearscreen();
        System.out.println("\tWelcome "+username.get(i));
        System.out.println();
        System.out.println("Enter Booking ID:");
        int check=sc.nextInt();
        int count =0;
        int check1=0;
        int st=0;
        int seat1=-1;    
        for(int j=0;j<bookingidlist.size();j++){                    
           if(check==bookingidlist.get(j) ){
            username1.remove(j);
            startpoint.remove(j);
            landingpoint.remove(j);
            bookingidlist.remove(j);  
            status.remove(j);
            startid.remove(j);
            landingid.remove(j); 
            b:for(int y=allotedseat.get(j)-1;y<10;y++){
                for(int t=0;t<7;t++){
                    if(t>=startid.get(j)-1 && t<landingid.get(j)-1){
                      seat[y][t]=0;
                    }  
                }break b;
            }
            allotedseat.remove(j);
            // for(int y=0;y<10;y++){
            //     for(int y1=0;y1<7;y1++){
            //         System.out.print(seat[y][y1]+" ");
                    
            //     }System.out.println();
            // }
            int ws=0,wl=0;
            a:for(int g=0;g<wstartid.size();g++){
            for(int k=0;k<10;k++){
                count =0;
                for(int t=0;t<7;t++){
                    if(t>=wstartid.get(g)-1 && t<=wlandingid.get(g)-1){
                       count += seat[k][t];
                       check1=t;
                    }
                }
                for(int t=wstartid.get(g)-1;t<check1;t++){
                    if(count==0){
                        
                        seat[k][t]=seatid;
                        ws=wstartid.get(g)-1 ;
                        wl=wlandingid.get(g)-1;
                        seat1=j;
                        st=g;
                    }
                    
                }
                if(count==0){
                   
                    break a;
                }

            }
            }
            if(seat1!=-1 ){
                username1.add(username.get(i));
                startpoint.add(place[wstartid.get(st)-1]);
                landingpoint.add(place[wlandingid.get(st)-1]);
                allotedseat.add(seat1+1);
                bookingidlist.add(wbookingidlist.get(j));  
                status.add("Seat Alloted"); 
            System.out.println("Seat Alloted :"+(seat1+1));
            System.out.println("Booking id :"+wbookingidlist.get(j));
            bb:for(int y=st;y<3;y++){
                for(int t=0;t<7;t++){
                    if(t>=ws && t<wl){
                      waitseat[y][t]=0;
                      
                    }  
                }break bb;
            }
            wusername1.remove(st);
            wstartpoint.remove(st);
            wlandingpoint.remove(st);
            wbookingidlist.remove(st);  
            wstatus.remove(st); 
            wallotedseat.remove(st);
            wstartid.remove(st);
            wlandingid.remove(st);
            // for(int y=0;y<10;y++){
            //     for(int y1=0;y1<7;y1++){
            //         System.out.print(seat[y][y1]+" ");
                    
            //     }System.out.println();
            // }
            // System.out.println("ws");
            // for(int y=0;y<3;y++){
            //     for(int y1=0;y1<7;y1++){
            //         System.out.print(waitseat[y][y1]+" ");
                    
            //     }System.out.println();
            // }
            }

            

           }
        }
        delay();
    }

    public static void history(int i){
        clearscreen();
        System.out.println("\tWelcome "+username.get(i));
        System.out.println();
        for(int j=0;j<username1.size();j++){
            
          if(username.get(i).equals(username1.get(j))){
           
            System.out.println("Ticket number "+(j+1));
            System.out.println("Starting Point :"+startpoint.get(j));  
            System.out.println("Landing Point  :"+landingpoint.get(j));  
            System.out.println("Seat number    :"+allotedseat.get(j));
            System.out.println("Booking id     :"+bookingidlist.get(j));
            System.out.println(status.get(j));
            System.out.println();
          }}for(int j=0;j<wusername1.size();j++){
           
          if(username.get(i).equals(wusername1.get(j))){
         
            System.out.println("Ticket number  :"+(j+1));
            System.out.println("Starting Point :"+wstartpoint.get(j));  
            System.out.println("Landing Point  :"+wlandingpoint.get(j));  
            System.out.println("Seat number    :"+wallotedseat.get(j));
            System.out.println("Booking id     :"+wbookingidlist.get(j));
            System.out.println(wstatus.get(j));
            System.out.println();
          
        }
        }
        delay();
    }

    public static void pingeneration(int i){
        clearscreen();
        System.out.println();
        System.out.println("Welcome "+username.get(i));
        System.out.println("Enter your new pin");
        String newpin=sc.next();
        sc.nextLine();
        System.out.println("Confirm new Pin:");
        String repin=sc.next();
        sc.nextLine();
        if(newpin.equals(repin)){
            password.set(i,newpin);
            System.out.println("Pin changed Succesfully!......");
            System.out.println();
        }else{
            System.out.println("Pin mismatch...");
            System.out.println();
        }
    }

    public static void olduser(){
        System.out.println();
        System.out.println("Enter Username: ");
        String q=sc.next();
        sc.nextLine();
        System.out.println("Enter Password: ");
        String r=sc.next();
        sc.nextLine();
        int s=0;
        a:while(true){
        for(int i=0;i<username.size();i++){
            if(username.get(i).equals(q) && password.get(i).equals(r)){
                s=1;
                while(true){
                    clearscreen();
                    System.out.println("\tWelcome "+username.get(i));
                    System.out.println();
                    System.out.println("1.Seat booking");
                    System.out.println("2.Seat Cancelling");
                    System.out.println("3.History");
                    System.out.println("4.Password change");
                    System.out.println("5.Exit");
                    System.out.println();
                    System.out.println("Enter your choice:");
                    int t=sc.nextInt();
                    if(t==1){
                        booking(i);
                    }else if(t==2){
                        cancelling(i);
                    }else if(t==3){
                        history(i);
                    }else if(t==4){
                        pingeneration(i);
                    }else if(t==5){
                        System.out.println("Exit Sucessfully!......");
                        System.out.println();
                        break a;
                    }else{
                        System.out.println("Invalid Input!");
                        break a;
                    }
                }
            }
        }
        }
    }

    public static void delay(){
        System.out.println("Press 1 to continue");
        int one =sc.nextInt();
        if(one==1){

        }
    }

    public static void add(){
        username.add("Suthan");
        password.add("1234");
    }

    public static void clearscreen(){
        //System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void main(String[] args)
    {
    add();
    while(true){
        clearscreen();
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println("*********************Welcome to railwaybooking******************************");
        System.out.println();
        System.out.println("1.New User");
        System.out.println("2.Existing User");
        System.out.println("3.Exit");
        System.out.println();
        System.out.println("Enter your choice : ");
        int d=sc.nextInt();
        if(d==1){
            user();
        }else if(d==2){
            olduser();
        }else if(d==3){
            System.out.println("Exit sucessfully!..........");
            break;
        }else{
            System.out.println("Invalid Input!...");
            delay();
        }
    }
    }
}