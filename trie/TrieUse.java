//package TextProcessing1;

public class TrieUse {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trie t = new Trie();
		t.addWord("new");
		t.addWord("news");
		t.addWord("at");
		System.out.println(t.findWord("new"));
	//	System.out.println("news");
		t.removeWord("new");
		System.out.println(t.findWord("new"));
		System.out.println();
	}

}
