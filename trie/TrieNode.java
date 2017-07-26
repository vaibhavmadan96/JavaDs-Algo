//package TextProcessing1;

import java.util.HashMap;

public class TrieNode {
	private final char data;
	private HashMap<Character, TrieNode> children;
	private boolean isTerminal;
	
	TrieNode(char data){
		this.data = data;
		children = new HashMap<>();
		isTerminal = false;
	}
	
	
	public TrieNode getChild(char c){
		return this.children.get(c);
	}
	
	public void setChild(char c, TrieNode child){
		this.children.put(c, child);
	}


	public void setTerminal(boolean b) {
		this.isTerminal = b;
	}
	
	public boolean getStatus(){
		return this.isTerminal;
	}


	public int numChild() {
		// TODO Auto-generated method stub
		return this.children.size();
	}


	public void removeChild(char c) {
		this.children.remove(c);
		
	}
	
}
