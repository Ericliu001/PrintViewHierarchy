package com.example.printviewhierarchy.printer;

import android.app.Activity;
import android.view.ViewGroup;

public class ViewTreePrinter {

    public String printActivityViewTree(Activity activity) {
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();

        Node root = ViewTreeBuilder.buildViewTree(decorView);
        return HierarchyPrinter.printViewTreeHierarchy(root);
    }
}
