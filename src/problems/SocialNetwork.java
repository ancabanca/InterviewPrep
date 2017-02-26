package com.github.ancabanca.interviewprep.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.github.ancabanca.interviewprep.util.UnionFind;

/** Social network connectivity. Given a social network containing n members
 * and a log file containing m timestamps at which times pairs of members 
 * formed friendships, design an algorithm to determine the earliest time 
 * at which all members are connected. Assume that the log file is sorted
 * by timestamp and that friendship is an equivalence relation. The running
 * time of your algorithm should be mlogn or better and use extra space proportional to n.
 */
public class SocialNetwork {
    /*
        Reads a social network's connections from a file. Format:
            N
            T id1 id2
        where N is the total number of members of the social network, and
        T is the time at which id1 and id2 became friends. Example:
            100
            5 34 48
            9 12 9
        Then it checks at what time T0 all members of the social network
        are connected to each other
    */
    public int checkWhenConnected(String logFileName) {
        try {
            Scanner s = new Scanner(new File(logFileName));
            int N = Integer.parseInt(s.nextLine().trim());
            UnionFind uf = new UnionFind(N);
            while(s.hasNextLine()) {
                String[] tokens = s.nextLine().split("\t");
                uf.union(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                if(uf.connectedComponents() == 1) {
                    //System.out.println(String.format("All social network members connected at time %s.",tokens[0]));
                    return Integer.parseInt(tokens[0]);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return -1;
    }
}