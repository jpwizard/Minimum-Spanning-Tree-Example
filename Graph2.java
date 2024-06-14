//James Panagis

package graph;
import java.util.*;
public class Graph2 {
public int n; //number of vertice
public int[][] A; //the adjacency matrix
public Graph2 () {
n = 0;
A = null;
}
public Graph2 (int _n, int[][] _A) {
this.n = _n;
this.A = _A;
}

//I implemented a minimum function where it will check the minimum value and assign it into variables for the mst
private int min(int k[], Boolean mstSet[])

{

int minimum = Integer.MAX_VALUE, min_index = -1;

for (int v = 0; v < n; v++)

if (mstSet[v] == false && k[v] < minimum)

{


minimum = k[v];

min_index = v;

}

return min_index;

}

public int prim(int r)

{
//I Implemented the calculation for prim to work, where it will check the values into valuables, then into an arrays, and then checks the weight of the mst
int p[] = new int[n];

int key[] = new int[n];

Boolean mstSet[] = new Boolean[n];


for (int i = 0; i < n; i++){

key[i] = Integer.MAX_VALUE;
mstSet[i] = false;
p[i] = -1;

}

key[r] = 0;

p[r] = -1;


for (int i = 0; i < n - 1; i++)

{

int u = min(key, mstSet);
mstSet[u] = true;


for (int v = 0; v < n; v++)
if (A[u][v] != 0 && mstSet[v] == false

&& A[u][v] < key[v])

{

p[v] = u;
key[v] = A[u][v];}
}

int weight = 0;
for (int i = 0; i < n; i++)

{

if (p[i] != -1)
weight += A[i][p[i]];

}

return weight;

}
public static void main(String[] args) {
// TODO Auto-generated method stub
int n = 9;
int A[][] = {
{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
{4, 0, 8, 0, 0, 0, 0, 11, 0}, 
{0, 8, 0, 7, 0, 4, 0, 0, 2}, 
{0, 0, 7, 0, 9, 14, 0, 0, 0}, 
{0, 0, 0, 9, 0, 10, 0, 0, 0}, 
{0, 0, 4, 14, 10, 0, 2, 0, 0}, 
{0, 0, 0, 0, 0, 2, 0, 1, 6}, 
{8, 11, 0, 0, 0, 0, 1, 0, 7}, 
{0, 0, 2, 0, 0, 0, 6, 7, 0} 
};
Graph2 g = new Graph2(n, A);
System.out.println(g.prim(0));
}
}