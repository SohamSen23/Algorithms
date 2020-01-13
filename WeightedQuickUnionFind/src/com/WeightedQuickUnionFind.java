package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WeightedQuickUnionFind {

	private int[] component;
	private int[] size;
	private int count; // number of nodes

	public WeightedQuickUnionFind(int n) {
		count = n;
		component = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			component[i] = i;
			size[i] = 1;
		}
	}
	
	public int count() {
        return count;
    }

	private void validate(int index) {
		int length = component.length;
		if (index < 0 || index >= length)
			throw new IllegalArgumentException(index + " is out of range");
	}

	private int findRoot(int index) {
		this.validate(index);
		while (index != component[index]) {
			index = component[index];
		}
		return index;
	}
	
	public void union(int c1, int c2) {
		int firstRoot = this.findRoot(c1);
		int secondRoot = this.findRoot(c2);
		
		if(size[firstRoot]<size[secondRoot]) {
			component[firstRoot]=secondRoot;
			size[secondRoot]+=size[firstRoot];
		} else {
			component[secondRoot]=firstRoot;
			size[firstRoot]+=size[secondRoot];
		}
		count--;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader	(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        WeightedQuickUnionFind uf = new WeightedQuickUnionFind(n);
        boolean loop = true;
       do {
    	   System.out.println("First node");
            int p = Integer.parseInt(br.readLine());
            System.out.println("Second node");
            int q = Integer.parseInt(br.readLine());
            if (uf.findRoot(p) == uf.findRoot(q)) 
            	continue;
            uf.union(p, q);
            System.out.println(p + " is connected to " + q);
            System.out.println("Want to continue(Y/N)");
            String var = br.readLine();
            if("y".equalsIgnoreCase(var) || "Y".equalsIgnoreCase(var) || "YES".equalsIgnoreCase(var) || "yes".equalsIgnoreCase(var))
            	loop = true;
            else
            	loop = false;
        } while (loop);
        System.out.println(uf.count() + " components");
    }	

}

