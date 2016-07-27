package sun.java.algorithms;

public class Whitelist {
	 /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument. Reads in integers from standard input and
     * prints to standard output those integers that are not in the file.
     */
    public static void main(String[] args) {
        int[] white = {2,8,5,7,33,55};
        StaticSETofInts set = new StaticSETofInts(white);

            int key = 8;
            if (!set.contains(key))
                StdOut.println(key);
    }
}
