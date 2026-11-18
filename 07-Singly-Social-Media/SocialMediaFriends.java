import java.util.*;
public class SocialMediaFriends {
    static class User {int id,age;String name;Set<Integer> friends=new LinkedHashSet<>();User next;
        User(int i,String n,int a){id=i;name=n;age=a;}}
    private User head;
    void addUser(int id,String name,int age){if(findId(id)!=null)throw new IllegalArgumentException("Duplicate user ID");
        User x=new User(id,name,age);if(head==null){head=x;return;}User t=head;while(t.next!=null)t=t.next;t.next=x;}
    User findId(int id){for(User u=head;u!=null;u=u.next)if(u.id==id)return u;return null;}
    User findName(String name){for(User u=head;u!=null;u=u.next)if(u.name.equalsIgnoreCase(name))return u;return null;}
    boolean addFriend(int id1,int id2){User a=findId(id1),b=findId(id2);if(a==null||b==null||a==b)return false;
        a.friends.add(id2);b.friends.add(id1);return true;}
    boolean removeFriend(int id1,int id2){User a=findId(id1),b=findId(id2);if(a==null||b==null)return false;
        a.friends.remove(id2);b.friends.remove(id1);return true;}
    Set<Integer> mutualFriends(int id1,int id2){User a=findId(id1),b=findId(id2);Set<Integer> result=new LinkedHashSet<>();
        if(a!=null&&b!=null){result.addAll(a.friends);result.retainAll(b.friends);}return result;}
    void displayFriends(int id){User u=findId(id);if(u==null){System.out.println("User not found.");return;}
        System.out.println("Friends of "+u.name+": "+u.friends);}
    void displayAll(){for(User u=head;u!=null;u=u.next)
        System.out.printf("ID:%d | %s | Age:%d | Friends:%s | Count:%d%n",u.id,u.name,u.age,u.friends,u.friends.size());}
    public static void main(String[] args){SocialMediaFriends s=new SocialMediaFriends();
        s.addUser(1,"Aman",20);s.addUser(2,"Riya",19);s.addUser(3,"Karan",20);s.addUser(4,"Neha",19);
        s.addFriend(1,3);s.addFriend(1,4);s.addFriend(2,3);s.addFriend(2,4);
        s.displayAll();System.out.println("Mutual friends of 1 and 2: "+s.mutualFriends(1,2));s.displayFriends(1);
        s.removeFriend(1,4);System.out.println("After removing connection:");s.displayAll();}
}
