import java.util.ArrayList;

/*cities and their connections form a tree
 * tree example from: http://ycpcs.github.io/cs360-spring2015/lectures/lecture21.html
 */
public class Tree {

    /*
    *nodes correspond to the total of entities in the Tree
    *in C3_PROJECT: correspond to the cities
     */

    //number of nodes
    int nNodes;

    //List of nodes: coresponds to list of entities in study
    ArrayList<Character> nodes = new ArrayList<Character>();

    //Edge: corresponds to a branch; in C3_PROJECT corresponds to a "path" (connection between two nodes )
    //number of edges
    int nEdges;

    static class Edge {

        /*
        * source: correspond to the SOURCE node
        * destination: corresponds to the DESTINATION node
        */
        char source, destination;

        //WEIGHT: corresponds to parameter in analysis (ex: cost, time, distance in C3_PROJECT )
        double weight;

        //constructor Edge
        Edge(char source, char destination, double weight) {
            this.source=source;
            this.destination=destination;
            this.weight=weight;
        }
    }

    ArrayList<Edge> edgesList = new ArrayList<Edge>();

    //Tree constructor
    Tree(int nNodes, ArrayList<Character> nodes,int nEdges, ArrayList<Edge> edgesList ){
        this.nNodes=nNodes;
        this.nodes=nodes;
        this.nEdges=nEdges;
        this.edgesList=edgesList;
    }

}
