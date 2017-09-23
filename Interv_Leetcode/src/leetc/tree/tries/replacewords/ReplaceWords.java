package leetc.tree.tries.replacewords;

public class ReplaceWords {

	public static void main(String[] args) {
		String[] sA = {"cat","cattle","bat","battle","i","am","ambur","ambulance","ambul"};
		ReplaceWords rw = new ReplaceWords();
		Trie trie = rw.new Trie();
		for(String w:sA){
			trie.insert(w);
		}
		
		trie.search("ambulance");
	}

	
	private class Trie{
		TrieNode root;
		public Trie(){
			root = new TrieNode();
		}
		
		public void insert(String w){
			int wL = w.length();
			TrieNode cN = root;
			for(int i=0; i<wL;i++){
				int cI = w.charAt(i)-'a';
				if(cN.next[cI]==null){
					cN.next[cI] = new TrieNode();
				}
				cN = cN.next[cI];
			}
			cN.word=w;
		}
		
		public void search(String w){
			int wL = w.length();
			TrieNode cN = root;
			for(int i=0; i<wL;i++){
				int cI = w.charAt(i)-'a';
				if(cN.next[cI]==null){
					break;
				}else if(null != cN.word){
					System.out.println(" "+cN.word);
				}
				cN = cN.next[cI];
			}
			if(cN.word!=null){
				System.out.println(" "+cN.word);
			}
			return;
		}
		
	}
	private class TrieNode{
		public TrieNode[] next;
		public String word;
		public TrieNode(){
			next = new TrieNode[26];
		}
	}
}

