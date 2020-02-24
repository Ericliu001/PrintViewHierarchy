package com.example.printviewhierarchy.printer;

import android.view.View;
import android.view.ViewGroup;

final class ViewTreeBuilder {

    static Node buildViewTree(ViewGroup parent) {
        Node dummy = new Node("Dummy");

        buildTree(parent, dummy);

        return dummy.getChildren().get(0);
    }

    private static void buildTree(View view, Node parent) {
        Node current = new Node(view.getClass().getSimpleName());
        parent.getChildren().add(current);

        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                final View childView = viewGroup.getChildAt(i);

                buildTree(childView, current);
            }
        }
    }
}
