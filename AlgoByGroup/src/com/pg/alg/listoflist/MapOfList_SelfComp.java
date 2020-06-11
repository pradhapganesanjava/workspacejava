package com.pg.alg.listoflist;

/**
 * 
 * Sparse Similarity: The similarity of two documents (each with distinct words)
 * is defined to be the size of the intersection divided by the size of the
 * union. For example, if the documents consist of integers, the similarity of {
 * 1, 5, 3} and { 1, 7, 2, 3} is 0. 4, because the intersection has size 2 and
 * the union has size 5. We have a long list of documents (with distinct values
 * and each with an associated ID) where the similarity is believed to be
 * "sparse:'That is, any two arbitrarily selected documents are very likely to
 * have similarity 0. Design an algorithm that returns a list of pairs of
 * document IDs and the associated similarity. Print only the pairs with
 * similarity greater than 0. Empty documents should not be printed at all. For
 * simplicity, you may assume each document is represented as an array of
 * distinct integers. 
 * 
 * EXAMPLE 
 * Input: 
 * 13: { 14, 15, 100, 9, 3} 
 * 16: { 1, 9, 3, 5} 
 * 19: { 29, 2, 6, 8, 7} 
 * 24: { 7, 10} 
 * Output: 
 * ID1, ID2 SIMILARITY 
 * 13, 19 0.1 
 * 13, 16 0.25 
 * 19, 24 0.14285714285714285
 *
 */

/*
 * Naive approach: 
 * Handshake with all keys O ( K^2 )
 * Compare each values List with other List O ( L^2 )
 * Bottleneck : Doc numbers are unique; same doc shares with many ids.
 */
public class MapOfList_SelfComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
