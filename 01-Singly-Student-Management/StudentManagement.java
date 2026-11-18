import java.util.*;

public class StudentManagement {
    static class Student {
        int roll, age; String name, grade; Student next;
        Student(int roll, String name, int age, String grade) {
            this.roll=roll; this.name=name; this.age=age; this.grade=grade;
        }
    }
    private Student head;

    // Positions are 1-based.
    void addFirst(int r, String n, int a, String g) {
        Student x=new Student(r,n,a,g); x.next=head; head=x;
    }
    void addLast(int r, String n, int a, String g) {
        Student x=new Student(r,n,a,g);
        if(head==null){head=x; return;}
        Student t=head; while(t.next!=null)t=t.next; t.next=x;
    }
    void addAt(int pos, int r, String n, int a, String g) {
        if(pos<1) throw new IllegalArgumentException("Position must be >= 1");
        if(pos==1){addFirst(r,n,a,g);return;}
        Student t=head;
        for(int i=1;t!=null && i<pos-1;i++)t=t.next;
        if(t==null) throw new IndexOutOfBoundsException("Invalid position");
        Student x=new Student(r,n,a,g); x.next=t.next; t.next=x;
    }
    boolean delete(int roll) {
        if(head==null)return false;
        if(head.roll==roll){head=head.next;return true;}
        Student t=head;
        while(t.next!=null && t.next.roll!=roll)t=t.next;
        if(t.next==null)return false;
        t.next=t.next.next; return true;
    }
    Student search(int roll) {
        for(Student t=head;t!=null;t=t.next)if(t.roll==roll)return t;
        return null;
    }
    boolean updateGrade(int roll,String grade) {
        Student s=search(roll); if(s==null)return false; s.grade=grade; return true;
    }
    void display() {
        if(head==null){System.out.println("No student records.");return;}
        for(Student t=head;t!=null;t=t.next)
            System.out.printf("Roll: %d | Name: %s | Age: %d | Grade: %s%n",t.roll,t.name,t.age,t.grade);
    }
    public static void main(String[] args) {
        StudentManagement list=new StudentManagement();
        list.addLast(101,"Aman",19,"A"); list.addFirst(100,"Riya",20,"B");
        list.addAt(2,102,"Karan",19,"A+");
        list.display();
        System.out.println("Search roll 102: "+(list.search(102)!=null));
        list.updateGrade(102,"A"); list.delete(100);
        System.out.println("After update and deletion:"); list.display();
    }
}
