public class InventoryManagement {
    static class Item {String name;int id,quantity;double price;Item next;
        Item(String n,int i,int q,double p){name=n;id=i;quantity=q;price=p;}}
    private Item head;
    void addFirst(String n,int id,int q,double p){Item x=new Item(n,id,q,p);x.next=head;head=x;}
    void addLast(String n,int id,int q,double p){Item x=new Item(n,id,q,p);
        if(head==null){head=x;return;}Item t=head;while(t.next!=null)t=t.next;t.next=x;}
    void addAt(int pos,String n,int id,int q,double p){
        if(pos<1)throw new IllegalArgumentException("Position starts at 1");
        if(pos==1){addFirst(n,id,q,p);return;}Item t=head;
        for(int i=1;t!=null&&i<pos-1;i++)t=t.next;
        if(t==null)throw new IndexOutOfBoundsException("Invalid position");
        Item x=new Item(n,id,q,p);x.next=t.next;t.next=x;
    }
    boolean remove(int id){if(head==null)return false;if(head.id==id){head=head.next;return true;}
        Item t=head;while(t.next!=null&&t.next.id!=id)t=t.next;
        if(t.next==null)return false;t.next=t.next.next;return true;}
    boolean updateQuantity(int id,int q){Item x=findId(id);if(x==null)return false;x.quantity=q;return true;}
    Item findId(int id){for(Item x=head;x!=null;x=x.next)if(x.id==id)return x;return null;}
    void searchName(String name){boolean found=false;for(Item x=head;x!=null;x=x.next)
        if(x.name.equalsIgnoreCase(name)){print(x);found=true;}if(!found)System.out.println("Item not found.");}
    double totalValue(){double total=0;for(Item x=head;x!=null;x=x.next)total+=x.price*x.quantity;return total;}
    // Sorts by swapping item data; linked-list node connections remain unchanged.
    void sortByName(boolean ascending){for(Item i=head;i!=null;i=i.next)for(Item j=i.next;j!=null;j=j.next){
        int c=i.name.compareToIgnoreCase(j.name);if(ascending?c>0:c<0)swap(i,j);}}
    void sortByPrice(boolean ascending){for(Item i=head;i!=null;i=i.next)for(Item j=i.next;j!=null;j=j.next)
        if(ascending?i.price>j.price:i.price<j.price)swap(i,j);}
    private void swap(Item a,Item b){String n=a.name;a.name=b.name;b.name=n;
        int id=a.id;a.id=b.id;b.id=id;int q=a.quantity;a.quantity=b.quantity;b.quantity=q;
        double p=a.price;a.price=b.price;b.price=p;}
    void display(){if(head==null){System.out.println("Inventory empty.");return;}
        for(Item x=head;x!=null;x=x.next)print(x);}
    private void print(Item x){System.out.printf("%s | ID:%d | Qty:%d | Price:%.2f%n",x.name,x.id,x.quantity,x.price);}
    public static void main(String[] args){InventoryManagement inv=new InventoryManagement();
        inv.addLast("Mouse",1,10,500);inv.addFirst("Keyboard",2,5,900);inv.addAt(3,"Monitor",3,2,7000);
        inv.display();System.out.printf("Total inventory value: %.2f%n",inv.totalValue());
        inv.sortByPrice(true);System.out.println("Sorted by price (ascending):");inv.display();
        inv.updateQuantity(1,15);inv.remove(2);System.out.println("After update/removal:");inv.display();}
}
