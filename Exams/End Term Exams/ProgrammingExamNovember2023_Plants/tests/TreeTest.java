import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void testRead() {
        String data = "TREE: Oshima cherry; Prunus speciosa; (400, 1200)\n" +
                "FLOWER DETAILS: white; small; 5 petals";
        Tree tree = Tree.read(data);

        Tree tree2 = new Tree(
                "Oshima cherry",
                "Prunus speciosa",
                new Range(400, 1200),
                new FlowerDetails("white", FlowerSize.small, 5)
        );

        assertEquals(tree2, tree);
    }
    @Test
    void testToString() {
        String data = "Tree named Pine (latin: Pinus), typical size between 800cm and 8000cm.\n" +
                "This plant does not have flowers.";
        String name = "Pine";
        String latin = "Pinus";
        Range range = new Range(800, 8000);
        FlowerDetails fd = null;

        Tree tree = new Tree(
                name,
                latin,
                range,
                fd
        );

        assertEquals(data, tree.toString());
    }
}