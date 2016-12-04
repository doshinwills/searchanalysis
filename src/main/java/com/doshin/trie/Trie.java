package com.doshin.trie;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Trie {

	private Node root = new Node();

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.insert("he"));
		System.out.println(trie.insert("hell"));

		System.out.println(trie.insert("hello"));
		System.out.println(trie.insert("heart"));
		System.out.println(trie.insert("hello"));
		System.out.println(trie.insert("heart"));
		System.out.println(trie.insert("hellen"));

		System.out.println(trie.find("helle"));

		System.out.println(trie.bearthOrderTraversal("he"));
	}

	private Set<String> bearthOrderTraversal(String word) {
		Queue<Node> trieQueue = new LinkedList<Node>();
		Set<String> sugg = new LinkedHashSet<String>();

		Node current = findNode(word);

		trieQueue.add(current);

		while (!trieQueue.isEmpty()) {
			current = trieQueue.poll();
			if (current.isWord())
				sugg.add(current.getWord());

			for (Node value : current.getNodes().values()) {
				trieQueue.add(value);
			}

		}

		return sugg;

	}

	private boolean insert(String string) {
		if (string == null || string.trim().length() == 0)
			return false;
		Node current = root;
		Node node;
		char[] charArray = string.toCharArray();

		for (char ch : charArray) {
			if (current.getNodes().containsKey(ch)) {
				current = current.getNodes().get(ch);
			} else {
				node = new Node();
				current.getNodes().put(ch, node);
				current = node;
			}

		}

		if (!current.isWord()) {
			current.setWord(true);
			current.setWord(string);
			return true;
		}

		return false;
	}

	private boolean find(String word) {
		char[] wordChar = word.toCharArray();
		Node current = root;
		for (char ch : wordChar) {
			if (!current.getNodes().containsKey(ch))
				return false;
			current = current.getNodes().get(ch);
		}
		if (current.isWord)
			return true;

		return false;
	}

	private Node findNode(String word) {
		char[] wordChar = word.toCharArray();
		Node current = root;
		for (char ch : wordChar) {
			if (!current.getNodes().containsKey(ch))
				return null;
			current = current.getNodes().get(ch);
		}
		return current;
	}

}

class Node {
	boolean isWord;
	String word;
	Map<Character, Node> nodes = new HashMap<Character, Node>();

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Map<Character, Node> getNodes() {
		return nodes;
	}

	public void setNodes(Map<Character, Node> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "Node [isWord=" + isWord + ", word=" + word + ", nodes=" + nodes
				+ "]";
	}

}
