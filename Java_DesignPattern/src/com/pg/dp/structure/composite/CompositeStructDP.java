package com.pg.dp.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeStructDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphicClient.invokeGraphicClient();
	}
}

class GraphicClient { // Initialize four ellipses

	public static void invokeGraphicClient() {
		GraphicLeaf GraphicLeaf1 = new GraphicLeaf();
		GraphicLeaf GraphicLeaf2 = new GraphicLeaf();
		GraphicLeaf GraphicLeaf3 = new GraphicLeaf();
		GraphicLeaf GraphicLeaf4 = new GraphicLeaf();

		// Initialize three composite graphics
		GraphicComposite graphic = new GraphicComposite();
		GraphicComposite graphic1 = new GraphicComposite();
		GraphicComposite graphic2 = new GraphicComposite();

		// Composes the graphics
		graphic1.add(GraphicLeaf1);
		graphic1.add(GraphicLeaf2);
		graphic1.add(GraphicLeaf3);

		graphic2.add(GraphicLeaf4);

		graphic.add(graphic1);
		graphic.add(graphic2);

		// Prints the complete graphic (four times the string "GraphicLeaf").
		graphic.print();
	}
}

/** Component */
/*
 * its the abstraction for all components, including composite ones declares the
 * interface for objects in the composition
 */
interface Graphic {
	public void print();
}

/** "Composite" */
/*
 * represents a composite Component (component having children) implements
 * methods to manipulate children implements all Component methods, generally by
 * delegating them to its children
 */
class GraphicComposite implements Graphic {

	private List<Graphic> childGraphics = new ArrayList<Graphic>();

	@Override
	public void print() {
		for (Graphic graphic : childGraphics) {
			graphic.print();
		}
	}

	public void add(Graphic grapic) {
		childGraphics.add(grapic);
	}

	public void remove(Graphic grapic) {
		childGraphics.remove(grapic);
	}
}

/** Leaf */
/*
 * represents leaf objects in the composition implements all Component methods
 */
class GraphicLeaf implements Graphic {
	@Override
	public void print() {
		System.out.println(" GraphicLeaf ");
	}
}