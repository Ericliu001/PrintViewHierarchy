package com.example.printviewhierarchy.printer;

import java.util.ArrayList;
import java.util.List;

class Node {

    private final String name;
    private final List<Node> children = new ArrayList<>();

    Node(final String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    List<Node> getChildren() {
        return children;
    }
}
