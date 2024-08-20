// Implement Queue using Stacks

import java.io.*;
import java.util.*;

class CustomQueue {
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    
    public void Enqueue(int input) {
        if (st1.isEmpty() && st2.isEmpty()) {
            st1.push(input);
        } else if(st1.isEmpty() && !st2.isEmpty()) {
            while(!st2.isEmpty()) {
                st1.push(st2.pop());
            }
            st1.push(input);
        } else {
            while(!st2.isEmpty()) {
                st1.push(st2.pop());
            }
            st1.push(input);
        }
    }
    
    public int Dequeue() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
    
        if(!st2.isEmpty()) {
            return st2.pop();
        } else {
            System.out.print("No element found / Empty");
            return 0;
        }
    }

}

class GFG {
	public static void main (String[] args) {
		CustomQueue qu = new CustomQueue();
		qu.Enqueue(13);
		qu.Enqueue(4);
		qu.Enqueue(7);
		qu.Enqueue(2);
		qu.Enqueue(78);
		
		System.out.println("dequeue 1: "  +  qu.Dequeue());
		System.out.println("dequeue 2: " + qu.Dequeue());
		
		qu.Enqueue(6);
		qu.Enqueue(1);
		
		System.out.println("dequeue 3: " + qu.Dequeue());
		System.out.println("dequeue 1: " + qu.Dequeue());
	}
}