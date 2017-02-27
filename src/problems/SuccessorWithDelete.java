package com.github.ancabanca.interviewprep.problems;

/**
 * Sequence 1...N that supports two operations:
 *  - delete element
 *  - successor of element
 * Both operations take amortized constant time.
 */
public class SuccessorWithDelete {
    private UnionFindCanonicalElement uf;

    public SuccessorWithDelete(int n) {
        uf = new UnionFindCanonicalElement(n);
    }

    public void delete(int i) {
        if(i > 0)
            uf.union(i, i-1);
    }

    public int successor(int i) {
        return uf.find(i) + 1;
    }
}