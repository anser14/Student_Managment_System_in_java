
public class Node {
 public int roll_no;
    public String name;
    public String Semester;
   
    public String email;
    public String Project;
    public int pass;
    public Node next;
    
    Node(int rno,String nme,String sem,  String em, String pr,int pas){
        roll_no = rno;
        name = nme;
        Semester = sem;
      
        email = em;
        Project = pr;
        pass=pas;
        next = null;
    }
    Node(){
        
    }   
}
