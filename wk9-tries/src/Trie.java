public class Trie{

	// Alphabet size (# of symbols) we pick 26 for English alphabet
	static final int ALPHABET_SIZE = 26;

	// class for Trie node
	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		// isEndOfWord is true if the node represents end of a word i.e. leaf node
		boolean isEndOfWord;

		TrieNode(){
			isEndOfWord = false;

			for (int i = 0; i < ALPHABET_SIZE; i++)
			children[i] = null;
		}
	}

	static TrieNode root;
	// If not key present, inserts into trie
	// If the key is prefix of Trie node, 
	//  marks leaf node

	static void insert(String key){
		int level, index;
		int length = key.length();
		TrieNode crawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (crawl.children[index] == null) {
				crawl.children[index] = new TrieNode();
			}
			crawl = crawl.children[index];
		}
		crawl.isEndOfWord = true;
	}

	// Returns true if key presents in trie, else false
	static boolean search(String key) {
		int level, index;
		int length = key.length();
		TrieNode crawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (crawl.children[index] == null) {
				return false;
			}
			crawl = crawl.children[index];
		}
		return (crawl != null && crawl.isEndOfWord);
	}


	// Driver
	public static void main(String args[]) {

		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


		String output[] = {"Not present in trie", "Present in trie"};

		root = new TrieNode();

		// Construct trie
		for (int i = 0; i < keys.length ; i++) {
			insert(keys[i]);
		}

		// Search for different keys
		if(search("film")) {
			System.out.println("film " + output[1]);
		}else{
			System.out.println("film " + output[0]);
		}

		if(search("banana")) {
			System.out.println("banana " + output[1]);
		}else{
			System.out.println("banana " + output[0]);
		}

		if(search("simple")) {
			System.out.println("simple " + output[1]);
		}else{
			System.out.println("simple " + output[0]);
		}

		if(search("simpler")) {
			System.out.println("simpler " + output[1]);
		}else{
			System.out.println("simpler " + output[0]);
		}
	}

} 