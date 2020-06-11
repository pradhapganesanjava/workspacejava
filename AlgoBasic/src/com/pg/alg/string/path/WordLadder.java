package com.pg.alg.string.path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		WordLadder_Solution sol = new WordLadder_Solution();
		String[] wordArr = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> wordList = new ArrayList<>(Arrays.asList(wordArr));
		int len = sol.ladderLength("hit", "cog", wordList);

		System.out.println("Len " + len);
	}

}

class WordLadder_Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		return wordLadderRecurImpl(beginWord, endWord, wordList);

	}

	private int wordLadderRecurImpl(String beginWord, String endWord, List<String> wordList) {
		Set<String> visit = new HashSet<>();
		Queue<String> explore = new LinkedList<>();
		Map<String, String> path = new HashMap<>();
		explore.add(beginWord);
		wordLadderRecur(endWord, wordList, explore, visit, path);

		if (!path.containsKey(endWord))
			return 0;

		List<String> pathLst = new ArrayList<>();

		String parent = endWord;
		pathLst.add(parent);
		while (parent != null) {
			String tparent = path.get(parent);
			parent = tparent;
			pathLst.add(parent);
			if (null == tparent || tparent.equals(beginWord))
				break;
		}
		for (int i = pathLst.size() - 1; i >= 0; --i) {
			System.out.print(pathLst.get(i) + " -> ");
		}
		return pathLst.size();
	}

	private void wordLadderRecur(String endWord, List<String> dicList, Queue<String> explore, Set<String> visit,
			Map<String, String> path) {

		while (!explore.isEmpty()) {

			if (path.containsKey(endWord))
				break;

			String startWord = explore.remove();

			// if(endWord.equals(startWord)) return;
			if (visit.contains(startWord)) {
				continue;
			}
			visit.add(startWord);

			char[] sw = startWord.toCharArray();
			for (int i = 0; i < sw.length; i++) {
				sw = startWord.toCharArray();
				for (int ic = 0; ic < 26; ic++) {
					char nch = (char) (ic + 'a');
					if (sw[i] == nch) {
						continue;
					}
					replace(sw, i, nch);
					final String strWord = String.valueOf(sw);

					if (visit.contains(strWord)) {
						continue;
					}

					if (dicList.stream().anyMatch(e -> {
						return e.equals(strWord);
					})) {
						explore.add(strWord);
						path.put(strWord, startWord);
					}
				}

			}
			// wordLadderRecur(endWord, dicList, explore, visit, path);
		}

	}

	private void replace(char[] arrch, int idx, char ch) {
		if (idx >= arrch.length)
			return;
		arrch[idx] = ch;
	}

}