package com.github.ancabanca.interviewprep.ood.ems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DatabaseConnectionManager {
    private static final int MAX_CONNECTIONS = 32;

    private static DatabaseConnectionManager instance = new DatabaseConnectionManager();

    private int currentlyOpenConnections;
    private List<Integer> openConnections;
    private Set<Integer> connectionsInUse;

    private DatabaseConnectionManager() {
        openConnections  = new LinkedList<Integer>();
        for(int id = 0; id < MAX_CONNECTIONS; id++){
            openConnection(id);
            openConnections.add(id);
        }
        connectionsInUse = new HashSet<Integer>();
    }

    public static DatabaseConnectionManager getInstance() {
        return instance;
    }

    public int getConnection() {
        if(connectionsInUse.size() == MAX_CONNECTIONS)
            throw new IllegalStateException("Reached maximum number of connections: " + MAX_CONNECTIONS);
        if(openConnections.size() > 0) {
            int connection = openConnections.remove(0);
            connectionsInUse.add(connection);
            return connection;
        }
        else
            throw new IllegalStateException("No open connections in the pool, " + 
                "but maximum number of connections not reached");
    }

    private void openConnection(int id) {

    }

    public void closeConnection(int id) {
        connectionsInUse.remove(new Integer(id));
        openConnections.add(id);
    }
}