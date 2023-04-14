package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1991_트리_순회 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Node node = new Node('A', null, null);

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String parent = st.nextToken();
            String child1 = st.nextToken();
            String child2 = st.nextToken();

            nodeInTree(node, parent.charAt(0), child1.charAt(0), child2.charAt(0));
        }

        preOrder(node);
        System.out.println();
        inOrder(node);
        System.out.println();
        postOrder(node);
    }

    static void nodeInTree(Node node, char parent, char child1, char child2) {
        if(node.now == parent) {
            if(child1 == '.')
                node.child1 = null;
            else
                node.child1 = new Node(child1, null, null);

            if(child2 == '.')
                node.child2 = null;
            else
                node.child2 = new Node(child2, null, null);
        }
        else {
            if(node.child1 != null)
                nodeInTree(node.child1, parent, child1, child2);

            if(node.child2 != null)
                nodeInTree(node.child2, parent, child1, child2);
        }
    }

    static void preOrder(Node node) {
        if(node == null)
            return;

        System.out.print(node.now);
        preOrder(node.child1);
        preOrder(node.child2);
    }

    static void inOrder(Node node) {
        if(node == null)
            return;

        inOrder(node.child1);
        System.out.print(node.now);
        inOrder(node.child2);
    }

    static void postOrder(Node node) {
        if(node == null)
            return;

        postOrder(node.child1);
        postOrder(node.child2);
        System.out.print(node.now);
    }

    static class Node {
        char now;
        Node child1;
        Node child2;

        public Node(char now, Node child1, Node child2) {
            this.now = now;
            this.child1 = child1;
            this.child2 = child2;
        }
    }
}
