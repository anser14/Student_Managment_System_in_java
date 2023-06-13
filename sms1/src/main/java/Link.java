
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class Link {
    
    public Node head;
    public Node tail;
    int count  = 0;
    Link(){
        
        head = null;
        tail = null;
    }
    
    public void add(int rno,String nme,String sem, String em, String pr,int pas){
        Node new_node = new Node(rno,nme,sem, em,pr,pas);
        count++;
        if(head == null){
            head = new_node;
            tail = new_node;
        }
        else {
            tail.next = new_node;
            tail = new_node;
        }
    }
    //sorting using bubble sort
     //Sorting Function()
    public void sort(){
        Node current = head.next;
        Node prev = head;
        int temp;
        String tem;
        for(int i=0; i<count-1; i++){
            for(int j=0; j<count-1; j++){
                if((prev.roll_no) > (current.roll_no)){
                    temp = prev.roll_no;
                    prev.roll_no = current.roll_no;
                    current.roll_no = temp;

                    tem = prev.name;
                    prev.name = current.name;
                    current.name = tem;
                    
                    tem = prev.Semester;
                    prev.Semester = current.Semester;
                    current.Semester = tem;
                    
                    tem = prev.email;
                    prev.email = current.email;
                    current.email = tem;
                    
                    tem = prev.Project;
                    prev.Project = current.Project;
                    current.Project = tem;
                    
                    temp = prev.pass;
                    prev.pass = current.pass;
                    current.pass = temp;
                }
                current = current.next;
                prev = prev.next;
            }
            if(current == null){
                current = head.next;
                prev = head;
            }
    }
    }

    //Node Search()
    public String search(int position){

        Node ptr = head;
        String i="";
        if(ptr == null)
        System.out.println("--------------------[WE HAVE NO RECORD FOR YOUR REQUESTED ROLLNO#]--------------------");

        else{
            while(ptr != null){
                if(ptr.roll_no == position){
     i += "STUDENT NAME : "+"    "+ptr.name+"\t\t\n";
     i +="STUDENT ROLL NO# : "+"    "+ ptr.roll_no+"\t\t\n";
     i +="STUDENT E-MAIL : "+ "    "+ptr.email+"\t\t\n";
     i +="STUDENT SEMESTER : "+"    "+ ptr.Semester+"\t\t\n";
     i += "STUDENT PROJECT : "+"    "+ptr.Project+"\n";
     i +="STUDENT PASSWORD : "+ "    "+ptr.pass;
                  System.out.println("\n-------------------[RECORD FOUND]-------------------");
                  System.out.println("*****************************************************************************************************************************************************************************************************");
                  System.out.println("\nStudent Name: " + ptr.name + "||  Student Roll No: " + ptr.roll_no+"||   Student Semester"+ptr.Semester+" ||  Student Email"+ptr.email+" ||  Student Project"+ptr.Project);
                  System.out.println("*****************************************************************************************************************************************************************************************************");
                    break;
                }
                ptr = ptr.next;
            }
            if(ptr == null){
              System.out.println("--------------[WE HAVE NO RECORD FOR YOUR REQUESTED ROLLNO#]--------------");
              
            }
        }
        return i;
        
    }

    //Delete Function()
    public void delete(int rno){
        Node current = head;
        Node prev = null;
        if(current.roll_no == rno){
            head = head.next;
            over_write();
        }

        else{
            while(current!= null){
                prev = current;
                current = current.next;

                if(current == null){
                
                System.out.println("---------------[WE HAVE NO RECORD FOR YOUR REQUESTED ROLLNO#]---------------");
                
                break;
                }

                if(current.roll_no == rno){
                    System.out.println("---------------------------------[RECORD DELETED!!!!!!!]---------------------------------");
                    prev.next = current.next;
                    over_write();
                    break;
                }
            }
            
        }
        
    }



    public String print(){
        
        Node ptr = head;
        String i = "      ";
        
       while(ptr != null){
     i += ptr.roll_no+"\t\t";
    i += ptr.name+"\t\t";
     i += ptr.email+"\t\t";
     i += ptr.Semester+"\t\t";
     i += ptr.Project+"\t\t";
     i += ptr.pass+"\t\t\n";
    if(ptr.next != null)
                i += " ==> ";
            ptr = ptr.next;
         
        }
        return i;
     
    }
    
     public void write(int rno,String nme,String sem,String em,String pr,int pas){
        
        try {
            FileWriter obj;
            add(rno,nme,sem,em,pr,pas);
            obj = new FileWriter("names.txt",true);
               
               obj.write(rno + "\n" + nme + "\n" + sem+ "\n" + em+ "\n"+pr+ "\n" +pas+"\n");
                 
                
     
               obj.close();
        }
            catch (IOException e) {
        }
        } 
    

    public void read(){
        
        int rno;
        String nme,sem,em,pr;
        int pas;
        try {
        
        File obj = new File("names.txt");
        Scanner s = new Scanner(obj);
        while(s.hasNextLine()){
            
            rno = Integer.parseInt(s.nextLine());
            nme = s.nextLine();
            sem = s.nextLine();
            em = s.nextLine();
            pr = s.nextLine();
            pas = Integer.parseInt(s.nextLine());
            
            add(rno,nme,sem,em,pr,pas);
        }
        
       
        } catch (FileNotFoundException e) {
        }
        
    }
    public void over_write(){
        
        try {
            FileWriter obj;
            Node ptr = head;
            obj = new FileWriter("names.txt");
               while(ptr != null){
               obj.write(ptr.roll_no + "\n" + ptr.name + "\n" + ptr.Semester+ "\n" + ptr.email+ "\n"+ptr.Project+ "\n" +ptr.pass+"\n");
               ptr = ptr.next;
               }
                
     
               obj.close();
        }
            catch (IOException e) {
        }
        }
    
    
    public String Student_print(String usr, int pwd){
        
        Node ptr = head;
        String i = "      ";
        
       while(ptr != null){
           if(usr.equals(ptr.email) && ptr.pass == pwd){
     i += ptr.roll_no+"\t\t";
    i += ptr.name+"\t\t";
     i += ptr.email+"\t\t";
     i += ptr.Semester+"\t\t";
     i += ptr.Project+"\t\t";
     i += ptr.pass+"\t\t\n";
     break;
           }
    if(ptr.next != null)
                i += " ==> ";
            ptr = ptr.next;
         
        }
        return i;
     
    }
}