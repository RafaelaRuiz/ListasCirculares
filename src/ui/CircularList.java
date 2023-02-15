package ui;
public class CircularList {
    private Node head;
    public void addNode(Node node){
        if(head==null){
            head = node;
            head.setNext(head);
            head.setPrevious(head);
        }else{
            Node tail= head.getPrevious();
            node.setNext(head);
            head.setPrevious(node);
            node.setPrevious(tail);
            tail.setNext(node);
        }
    }

    public void print(){
        print(head);
    }

    private void print(Node current){
        if(current == head.getPrevious()){
            System.out.println(current.getName());
            return;
        }
        System.out.println(current.getName());
        print(current.getNext());
    }

    public void delete(String goal){
        if(head==null){
            System.out.println("Empty list");
        }else if(head==head.getNext()){
        }else{
            delete(head, goal);
        }
        
    }

    private void delete(Node current, String goal){
        if(current.getName().equalsIgnoreCase(goal)){
            Node prev= current.getPrevious();
            Node next = current.getNext();
            next.setPrevious(prev);
            prev.setNext(next);
            if(current==head){
                head=next;
                return;
            }
            return;
        }
        delete(current.getNext(), goal);
    }
}
