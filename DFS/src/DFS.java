import java.util.Scanner;

/**
 * Created by mac on 2020/1/8.
 *
 * Print all paths from a certain node.
 */
public class DFS {

    int m[][];
    int startNode;
    int rows, width;


    /**
     * Read inputs and construct an adjacency matrix.
     *
     * Inputs like :
     * rows width
     * start1 end1
     * statt2 end2
     * ...
     * StartNode
     *
     * Nodes like 1, 2, 3, 4 and don't contain zero.
     *
     */
    void input() {
        Scanner sc = new Scanner(System.in);

        rows = sc.nextInt() + 1;
        width = sc.nextInt() + 1;

        m= new int[rows][width];
        sc.nextLine();

        int start, end;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (!line.contains(" ")) {
                startNode = Integer.parseInt(line);
                break;
            }
            String[] two = line.split(" ");
            m[Integer.parseInt(two[0])][Integer.parseInt(two[1])] = 1;

        }


    }

    /**
     * Print all paths from a certain node.
     */
    void mainF() {

        input();

        for (int i = 0; i < width; i++) {



            if (m[startNode][i] == 1){
//                System.out.println( startNode+"-" + i + "=1");
                System.out.print(startNode+"->"+i);
                dfs(i);

            }
        }

    }

    void dfs(int n) {



        int hasNext = 0;
        for (int i = 0; i < width; i++) {
            if ( m[n][i] == 1) {
//                 System.out.println( n+"-" + i + "=1");

                hasNext = 1;
                System.out.print("->"+i);
                dfs(i);
            }
        }

        if (hasNext == 0)
            System.out.println();

    }


}
