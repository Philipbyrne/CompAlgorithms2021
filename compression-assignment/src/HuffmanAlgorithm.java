/******************************************************************************
 *  Compilation:  javac HuffmanAlgorithm.java
 *
 *  Compress or expand a binary input stream using the Huffman algorithm.
 *
 *  Terminal used to run the Huffman Algorithm on any file.
 *  In order to execute the compress and decompress functions enter
 *      Compress : java HuffmanAlgorithm - < fileName.txt
 *      Decompress : java HuffmanAlgorithm + < fileName.txt
 *
 *  @author Philip Byrne
 ******************************************************************************/

public class HuffmanAlgorithm {
    // alphabet size of extended ASCII
    private static final int R = 256;

    // Do not instantiate.
    private HuffmanAlgorithm() { }

    // Huffman trie node
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress(){

        // read the input
        String inputString = BinaryStdIn.readString();
        char[] input = inputString.toCharArray();

        // tabulate frequency counts
        int[] frequency = new int[R];
        for (char value : input) {
            frequency[value]++;
        }

        // build Huffman trie
        Node trieRoot = buildTrie(frequency);

        // build code table
        String[] codeTable = new String[R];
        buildCode(codeTable, trieRoot, "");

        // print trie for decoder
        writeTrie(trieRoot.right);

        // print number of bytes in original uncompressed message
        BinaryStdOut.write(input.length);

        // use Huffman code to encode input
        for (char c : input) {
            String code = codeTable[c];
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == '0') {
                    BinaryStdOut.write(false);
                } else if (code.charAt(i) == '1') {
                    BinaryStdOut.write(true);
                } else {
                    throw new IllegalArgumentException("Value other than 0 or 1 detected.");
                }
            }
        }
        BinaryStdOut.close();

    }

    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress() {

        // read in Huffman trie from input stream
        Node trieRoot = readTrie();

        // number of bytes to write
        int numBytes = BinaryStdIn.readInt();

        // decode using the Huffman trie
        for (int i = 0; i < numBytes; i++) {
            Node temp = trieRoot;
            while (!temp.isLeaf()) {
                boolean bit = BinaryStdIn.readBoolean();
                if (bit) temp = temp.right;
                else     temp = temp.left;
            }
            BinaryStdOut.write(temp.ch, 8);
        }
        BinaryStdOut.close();

    }

    // build the Huffman trie given frequencies
    private static Node buildTrie(int[] freq) {
        // initialize priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
            else                 pq.insert(new Node('\1', 0, null, null));
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }

    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(), -1, null, null);
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }

    public static void main(String[] args){

        if(args[0].equals("-")){
            compress();
        }
        else if (args[0].equals("+")){
            decompress();
        }
        else{
            throw new IllegalArgumentException("Illegal command line argument.");
        }

    }
}