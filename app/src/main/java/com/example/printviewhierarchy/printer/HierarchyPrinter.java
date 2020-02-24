package com.example.printviewhierarchy.printer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class HierarchyPrinter {

    /**
     * Should print out the formatted tree.
     *
     * @param root
     * @return String.
     */
    static String printViewTreeHierarchy(Node root) {
        final List<StringBuilder> lines = renderTree(root);

        String lineBreak = System.getProperty("line.separator");

        StringBuilder results = new StringBuilder();
        for (final StringBuilder line : lines) {
            results.append(line);
            results.append(lineBreak);
        }

        return results.toString();
    }

    private static List<StringBuilder> renderTree(final Node root) {
        final List<StringBuilder> lines = new ArrayList<>();
        StringBuilder rootLine = new StringBuilder(root.getName());
        lines.add(rootLine); // Add the root;

        for (int i = 0; i < root.getChildren().size(); i++) {
            final Node child = root.getChildren().get(i);

            final List<StringBuilder> subTreeLines = renderTree(child); // Get the subtree lines;

            if (i == root.getChildren().size() - 1) {
                // Adds lines of the last subtree
                addSubtree(subTreeLines, lines, "└── ", "    ");
            } else {
                // Adds lines of a subtree that's not the last one.
                addSubtree(subTreeLines, lines, "├── ", "│   ");
            }
        }

        return lines;
    }

    /**
     * Merge the subtree into results, as well as adding guidelines.
     *
     * @param subTreeLines
     * @param lines
     * @param rootLine
     * @param leafLine
     */
    private static void addSubtree(
            final List<StringBuilder> subTreeLines,
            final List<StringBuilder> lines,
            final String rootLine,
            final String leafLine) {
        final Iterator<StringBuilder> subIterator = subTreeLines.iterator();

        final StringBuilder topLine = subIterator.next();
        topLine.insert(0, rootLine);
        lines.add(topLine);

        while (subIterator.hasNext()) {
            lines.add(subIterator.next().insert(0, leafLine));
        }
    }
}
