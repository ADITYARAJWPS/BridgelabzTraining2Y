public class TextEditorUndoRedo {
    static class State {String text;State prev,next;State(String s){text=s;}}
    private State head,tail,current;private final int limit;private int size;
    TextEditorUndoRedo(int limit){if(limit<1)throw new IllegalArgumentException("Limit must be positive");this.limit=limit;}
    void addState(String text){
        if(current!=null){current.next=null;tail=current;}
        State x=new State(text);
        if(tail==null)head=tail=current=x;
        else{tail.next=x;x.prev=tail;tail=current=x;}
        size++;
        while(size>limit){head=head.next;head.prev=null;size--;}
    }
    boolean undo(){if(current==null||current.prev==null)return false;current=current.prev;return true;}
    boolean redo(){if(current==null||current.next==null)return false;current=current.next;return true;}
    String getCurrentText(){return current==null?"":current.text;}
    void displayHistory(){for(State x=head;x!=null;x=x.next)
        System.out.println((x==current?"-> ":"   ")+x.text);}
    public static void main(String[] args){TextEditorUndoRedo editor=new TextEditorUndoRedo(10);
        editor.addState("");editor.addState("Hello");editor.addState("Hello world");editor.addState("Hello world!");
        editor.undo();System.out.println("After undo: "+editor.getCurrentText());
        editor.redo();System.out.println("After redo: "+editor.getCurrentText());
        editor.addState("New text");System.out.println("History:");editor.displayHistory();}
}
