public class LinkStrand implements IDnaStrand{

    private class Node {
        String info;
        Node next;
   
        public Node(String s, Node n) {
             info = s;
             next = n;
        }
   }
   
    private Node myFirst, myLast;
    private long mySize;
    private int myAppends;
    private int myIndex;
    private Node myCurrent;
    private int myLocalIndex;  
       
    public LinkStrand() {
        this("");

    }

    public LinkStrand(String s) {
        initialize(s);
    }
    
    @Override
    public long size() {
        // TODO Auto-generated method stub
        return mySize;
    }

    @Override
    public void initialize(String source) {
        // TODO Auto-generated method stub
        Node newNode = new Node(source,null);
        // myFirst = new Node(source, null); // idk what to put for the second parameter // the first node in a linked list of nodes
        myFirst = newNode;
        myLast = myFirst; // the last node in a linked list of nodes
        myAppends = 0; // one less than the number of nodes in the linked list
        myIndex = 0;
        myCurrent = myFirst;
        myLocalIndex = 0;
        mySize = source.length(); // the total number of characters stored in all nodes together
    }

    @Override
    public IDnaStrand getInstance(String source) {
        // TODO Auto-generated method stub
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        // TODO Auto-generated method stub
        myLast.next = new Node (dna, null);
        myLast = myLast.next;
        mySize += dna.length();
        myAppends++;
        return this;
    }

    private void addFirst(String s) {
        Node add = new Node(s,null);
        mySize += s.length();
        add.next = myFirst;
        myFirst = add;
    }

    @Override
    public IDnaStrand reverse() {
        LinkStrand rev = new LinkStrand();
        Node currNode = myFirst;

        while (currNode != null) {
            StringBuilder strBld = new StringBuilder(currNode.info);
            rev.addFirst(strBld.reverse().toString());
            currNode = currNode.next;
        }

        return rev;
    }

    @Override
    public int getAppendCount() {
        // TODO Auto-generated method stub
        return this.myAppends;
    }

    @Override
    public char charAt(int index) {
        // TODO Auto-generated method stub

        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

//         if index > size of the node, throw index out of bounds exception
// if index < myIndex, reset the global variables myINdex, myLocal Index and myCurrent to 0 (myccurent = myFirst)
// while loop
 

        if (index <= myIndex) {
            myIndex = 0;
            myLocalIndex = 0;
            myCurrent = myFirst;

            while (myIndex < index) {
                myIndex += 1;
                myLocalIndex += 1;
                if (myLocalIndex == myCurrent.info.length()) {
                    myCurrent = myCurrent.next;
                    myLocalIndex = 0;
                }

            }
        }

        else if (index > myIndex) {
            while (myIndex < index) {
                myIndex += 1;
                myLocalIndex += 1;
                if (myLocalIndex == myCurrent.info.length()) {
                    myCurrent = myCurrent.next;
                    myLocalIndex = 0;
                }

            }
        }

        return myCurrent.info.charAt(myLocalIndex);
        }

    @Override
	public String toString() {
        StringBuilder ret = new StringBuilder();
        Node currNode = myFirst;

        while (currNode != null) {
            ret.append(currNode.info);
            currNode = currNode.next;
        }

		return ret.toString();
	}
    
}
