class LinkedNode{
    int value; 
    LinkedNode next; 
    LinkedNode(int input) { //constructor
        this.value = input; 
    }
}
public class AddTwoNumbers{
     AddTwoNumbers(){}; 
     public static void main(String []args){
        LinkedNode tmp1 = null, tmp2 = null; 
        
        LinkedNode n1 = new LinkedNode (1); 
        tmp1=n1; 
        tmp1.next= new LinkedNode(3); 
        tmp1 = tmp1.next; 
        tmp1.next = new LinkedNode(8); 
        
        LinkedNode n2 = new LinkedNode(5);
        tmp2 = n2; 
        tmp2.next = new LinkedNode(9); 
        tmp2 = tmp2.next; 
        tmp2.next = new LinkedNode(7); 
        tmp2=tmp2.next; 
        tmp2.next = new LinkedNode(4); 
        
        LinkedNode n3 = null, tmp3=null;
        AddTwoNumbers atn = new AddTwoNumbers(); 
        n3 = atn.solution(n1, n2); 
        tmp3 = n3; 
        while (tmp3!=null) {
            System.out.print("the value is: "+tmp3.value+"\n");
            tmp3 = tmp3.next; 
        }
     }
     
     public LinkedNode solution(LinkedNode l1, LinkedNode l2) { //l1 and l2 are the two heads pointing to 2 Linked Lists.
        if (l1==null && l2==null) return null; //two linked lists are both null
 //       else if (l1==null) return l2; //l2 isn't null but l1 is
 //       else return l1; //l2 is null
        
        LinkedNode tmp1 = l1; 
        LinkedNode tmp2 = l2; 
        LinkedNode l3 = null, currentNode = null; 
        int carry=0, sum=0;  
        
        while (tmp1!=null || tmp2!= null) {
            //carry is what's coming from a carry over from a digit
            //consider if tmp1 is null but tmp2 isn't, and vice versa
            sum = carry+(tmp1==null? 0:tmp1.value) + (tmp2==null? 0:tmp2.value);
            //whenever "carry" is added to the sum, need to reset carry
            carry = 0;  
            if (sum>9) { //that means a digit should be carried over
                carry = sum / 10;
                sum = sum % 10; 
            }    
            //create a new node for sum of tmp1.value and tmp2.value
            LinkedNode newNode = new LinkedNode(sum);
            //Now think if it's the first element for l3
            if (l3 ==null) { //that means it's the first element
                l3 = newNode; 
                currentNode = newNode; 
            }
            else {
                //"connect" this new node after the current node
                currentNode.next = newNode; 
                //now each link list should move to the next node
                currentNode = newNode; 
            }
            if (tmp1!=null) tmp1 = tmp1.next; 
            if (tmp2!=null) tmp2 = tmp2.next; 
        }
        //one last thing is that if both tmp1 and tmp2 become null, that means no more values to be added, but it's possible that carry over still has value, for example, 8+5=12, it should have value 1 appended after 2
        if (carry!=0) {
            LinkedNode newNode = new LinkedNode(carry);
            currentNode.next = newNode;
        }
        return l3; 
    }
}
