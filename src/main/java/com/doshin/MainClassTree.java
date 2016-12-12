package com.doshin;

import com.doshin.tree.BTreePrinter;
import com.doshin.tree.BinarySearchTree;

public class MainClassTree {

	public static void main(String[] args) {
		BinarySearchTree searchTree = new BinarySearchTree();
		try {
//		searchTree.insertRecursive(6);
//		searchTree.insertRecursive(8);
//		searchTree.insertRecursive(1);
//		searchTree.insertRecursive(7);
//		searchTree.insertRecursive(9);
//		searchTree.insertRecursive(2);
//		searchTree.insertRecursive(5);
//		searchTree.insertRecursive(4);
//		searchTree.insertRecursive(3);
//		searchTree.insertRecursive(3);
			
			searchTree.insertRecursive(6);
			searchTree.insertRecursive(16);
			searchTree.insertRecursive(1);
			searchTree.insertRecursive(7);
			searchTree.insertRecursive(9);
			searchTree.insertRecursive(2);
			searchTree.insertRecursive(5);
			searchTree.insertRecursive(4);
			searchTree.insertRecursive(3);
			searchTree.insertRecursive(8);
			searchTree.insertRecursive(20);
			searchTree.insertRecursive(10);


		} catch(Exception e) {
			e.printStackTrace();
		}
		BTreePrinter.printNode(searchTree.getRoot());
		
		searchTree.preOrderTraversal();
		searchTree.preOrderTraversalStackWay();
		searchTree.inOrderTraversal();
		searchTree.inOrderTraversalStackWay();
		searchTree.postOrderTraversal();
		searchTree.postOrderTraversalStackWay();
		
		searchTree.levelOrderTraversalByCoRecursion();
		
		searchTree.height();

		searchTree.search(3);

		searchTree.searchPath(9);
		
		
		searchTree.delete(16);
		BTreePrinter.printNode(searchTree.getRoot());

		

	}

}
