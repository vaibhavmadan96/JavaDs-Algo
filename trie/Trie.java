//package TextProcessing1;

public class Trie {

	private TrieNode root;
	private int numWords;

	Trie(){
		root = new TrieNode('\0');
	}


	public int numWords(){
		return numWords;
	}

	public void addWord(String word){
		/*	if(findWord(word)){
			return;
		}*/
		if(addWord(root, word)){
			numWords++;
		}
	}

	private boolean addWord(TrieNode node, String word) {
		if(word.length() == 0){
			if(node.getStatus()){
				return false;
			}
			node.setTerminal(true);
			return true;
		}

		TrieNode child = node.getChild(word.charAt(0));
		if(child == null){
			child = new TrieNode(word.charAt(0));
			node.setChild(word.charAt(0), child);
		}
		return addWord(child, word.substring(1));	
	}

	public void removeWord(String word){

		removeWord(root,word);
		numWords--;
	}


	private boolean removeWord(TrieNode node, String word) {
		if(word.length() == 0){//first this checking takes place
			if(!node.getStatus()){
				return false;
			}
			node.setTerminal(false);
			return true;
		}
		TrieNode child = node.getChild(word.charAt(0));
		if(child == null){
			return false;
		}

		boolean ans = removeWord(child, word.substring(1));
		if(!child.getStatus() && child.numChild()==0){//main step
			node.removeChild(word.charAt(0));
		}
		return ans;
	}

	public boolean findWord(String word){
		TrieNode currentNode = root;

		for(int i =0; i < word.length(); i++){
			TrieNode child = currentNode.getChild(word.charAt(i));
			if(child == null){
				return false;
			}
			currentNode = child;
		}

		return currentNode.getStatus();

	}

}
