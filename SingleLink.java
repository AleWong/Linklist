package ListNode;
import java.util.Scanner;
//双向链表“节点”对应的结构体
class Node<T>{
    //值
    public T val;
    //下一个
    public Node next;
    //节点值
    public Node(T val){
        this.val=val;
    }
}

public class ListNode<T>{
    //表头
    public Node<T> head=new Node<>(null);

    //删除
    public void delete(T value){
        //初始化pre
        Node pre=head;
        //节点p
        Node p=head.next;

        while(p!=null){
            //当p的值复合被删除的条件时
            if(p.val.equals(value)){
                p=p.next;
                pre.next=p;
            }
            //不符合时
            else {
                p=p.next;
                pre=pre.next;
            }
        }
    }
    /**
     * 按顺序打印
     */
    public void print(){
        Node p=head.next;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
    //插入
    public void insert(T value){
        Node p=head;
        while(p.next!=null){
            p=p.next;
        }
        p.next=new Node(value);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode<Integer> listNode=new ListNode<>();
//        System.out.println("请输入数值储存到链表：");
//        int[] m = new int[100];
         
        for(int i=1;i<=5;i++){
            listNode.insert(i);
        }
 //       System.out.println("");
        listNode.print();
        System.out.println("请输入需要删除的值：");
        int n= in.nextInt();
        listNode.delete(n);

        listNode.print();

    }
}
