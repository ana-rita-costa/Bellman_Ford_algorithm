import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        //double inf = Double.POSITIVE_INFINITY;
        //Implementation based on: https://www.youtube.com/watch?v=lyw4FaxrwHg

        //Building the Tree
        int nNodes=5;
        int nEdges=8;

        //Filling nodes List
        ArrayList<Character> nodes=new ArrayList<>();
        nodes.add('A');
        nodes.add('B');
        nodes.add('C');
        nodes.add('D');
        nodes.add('E');

        ArrayList<Tree.Edge> edgesList=new ArrayList<>();

        //Filling the Edges
        Tree.Edge Edge1= new Tree.Edge('A','D',3);
        Tree.Edge Edge2= new Tree.Edge('A','C',6);
        Tree.Edge Edge3= new Tree.Edge('B','A',3);
        Tree.Edge Edge4= new Tree.Edge('C','D',2);
        Tree.Edge Edge5= new Tree.Edge('D','C',1);
        Tree.Edge Edge6= new Tree.Edge('D','B',1);
        Tree.Edge Edge7= new Tree.Edge('E','B',4);
        Tree.Edge Edge8= new Tree.Edge('E','D',2);

        //Filling edges List
        edgesList.add(Edge1);
        edgesList.add(Edge2);
        edgesList.add(Edge3);
        edgesList.add(Edge4);
        edgesList.add(Edge5);
        edgesList.add(Edge6);
        edgesList.add(Edge7);
        edgesList.add(Edge8);

        //Building tree
        Tree tree=new Tree(nNodes,nodes,nEdges,edgesList);

        double[] shortestPaths= bellman_Ford(tree);
        String shortestPathsStrings= Arrays.toString(shortestPaths);
        System.out.println(shortestPathsStrings);
    }

    public static double[] bellman_Ford(Tree tree){

        /*
        *declaration and initialization of VARIABLE OF STUDY maxWeight
        * maxWeight: corresponds to shortest path(according to weights):
            *One edge
            *Group of Edges
        *maxWeight corresponds to the FINAL result of the method: RETURN
            ----> array of all the SHORTEST "distances" between START node and all the others nodes
         */
        double[] totalWeight=new double[tree.nNodes];

        char startNode= 'E';

        /*
        * distance between startNode and the others node is set to INFINITY
        * distance between startNode and itself is 0
        * INITIALIZATION TIME: O(nNodes)
        * */

        java.util.Arrays.fill(totalWeight, Double.POSITIVE_INFINITY);
        totalWeight[tree.nodes.indexOf('E')]=0;

        //Real start of BELLMAN-FORD ALGORITHM

        for(int i=0; i< (tree.nNodes)-1 ; i++){
            /*
            *goes through all edges in edgesList
             ---->Better for DISTRIBUTED Systems

            *Shortest path found utmost at nNodes-1 TIMES
                   Nº of ITERATIONS: (tree.nNodes)-1
             */

            for (Tree.Edge edge: tree.edgesList){

                /*RELAXATION*:
                *compares continuously "distance" between two nodes

                * calculating and shortening continuously distance between those two nodes

                   ---->in C3_PROJECT: corresponds to continuously shorten the distance between start and end cities

                *Increases ACCURACY of distance

                *Following code only applicable in POSITIVE Cycles

                * TIME: O(nNodes*(nEdges-1))= O(nNodes*nEdges)
                * */

                if (totalWeight[tree.nodes.indexOf(edge.source)]+ edge.weight
                        < (totalWeight[tree.nodes.indexOf(edge.destination)]))
                    totalWeight[tree.nodes.indexOf(edge.destination)]= totalWeight[tree.nodes.indexOf(edge.source)]+ edge.weight;
            }
        }

        //FINAL RUN TIME: O(nNodes + nNodes*nEdges) = O(nNodes*nEdges)

        return totalWeight;
    }
}
