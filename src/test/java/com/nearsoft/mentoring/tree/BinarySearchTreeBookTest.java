package com.nearsoft.mentoring.tree;

import com.nearsoft.mentoring.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BinarySearchTreeBookTest {

    private final Book hopscotch = new Book("Hopscotch", "Cortázar", "9788437604572", 1963);
    private final Book love = new Book("Love in the Time of Cholera", "García Márquez", "9780307387264", 1985);
    private final Book hundredYears = new Book("One Hundred Years of Solitude", "García Márquez", "9788420471839", 1967);
    private final Book paramo = new Book("Pedro Páramo", "Rulfo", "9780802133908", 1955);
    private final Book badGirl = new Book("The Bad Girl", "Vargas Llosa", "9789707704664", 2006);
    private final Book labyrinth = new Book("The Labyrinth of Solitude", "Paz", "9780802150424", 1950);
    private final Book littlePrince = new Book("The Little Prince", "Saint-Exupéry", "9789871165070", 1915);
    private final Book metamorphosis = new Book("The Metamorphosis", "Kafka", "9789871165070", 1915);
    private Tree<Book> tree;

    @BeforeEach
    void setUp() {
        /*
         * Set up a tree this way:
         * - The Bad Girl
         *   -L One Hundred Years of Solitude
         *       -L Love in the Time of Cholera
         *           -L Hopscotch
         *       -R Pedro Páramo
         *   -R The Little Prince
         *       -L The Labyrinth of Solitude
         *       -R The Metamorphosis
         * */
        tree = new BinarySearchTree<>();
        tree.add(badGirl);
        tree.add(hundredYears);
        tree.add(littlePrince);

        tree.add(love);
        tree.add(hopscotch);
        tree.add(paramo);

        tree.add(labyrinth);
        tree.add(metamorphosis);
    }

    @Test
    void testToStringInOrder() {
        Tree<Book> tree = new BinarySearchTree<>();
        tree.add(badGirl);
        tree.add(hundredYears);
        tree.add(littlePrince);
        assertThat(tree.toString()).isEqualTo("Book(title=One Hundred Years of Solitude, author=García Márquez, isbn=9788420471839, year=1967) Book(title=The Bad Girl, author=Vargas Llosa, isbn=9789707704664, year=2006) Book(title=The Little Prince, author=Saint-Exupéry, isbn=9789871165070, year=1915)");
    }

    @Test
    void testDeleteLeaf() {
//        First assert everything is fine on the right branch
        assertThat(tree.contains(labyrinth)).isTrue();
        assertThat(tree.contains(metamorphosis)).isTrue();
        assertThat(tree.contains(littlePrince)).isTrue();

//        Delete one of the leaves. Parent and the other leaf should be still there
        tree.delete(labyrinth);
        assertThat(tree.contains(labyrinth)).isFalse();
        assertThat(tree.contains(metamorphosis)).isTrue();
        assertThat(tree.contains(littlePrince)).isTrue();

//        Delete the last leaf. Only parent should be there
        tree.delete(metamorphosis);
        assertThat(tree.contains(labyrinth)).isFalse();
        assertThat(tree.contains(metamorphosis)).isFalse();
        assertThat(tree.contains(littlePrince)).isTrue();
    }

    @Test
    void testDeleteOneChild() {
//        Verify branch of the left
        /*
         * One Hundred Years of Solitude
         *  -L Love in the Time of Cholera
         *      -L Hopscotch
         *  -R Pedro Páramo
         * */
        assertThat(tree.contains(hundredYears)).isTrue();
        assertThat(tree.contains(love)).isTrue();
        assertThat(tree.contains(hopscotch)).isTrue();
        assertThat(tree.contains(paramo)).isTrue();

//        Delete the node with one child on the left
        tree.delete(love);
        /*
         * One Hundred Years of Solitude
         *  -L Hopscotch
         *  -R Pedro Páramo
         * */
        assertThat(tree.contains(hundredYears)).isTrue();
        assertThat(tree.contains(love)).isFalse();
        assertThat(tree.contains(hopscotch)).isTrue();
        assertThat(tree.contains(paramo)).isTrue();

//        Delete left side
        tree.delete(hopscotch);
        /*
         * One Hundred Years of Solitude
         *  -R Pedro Páramo
         * */
        assertThat(tree.contains(hundredYears)).isTrue();
        assertThat(tree.contains(hopscotch)).isFalse();
        assertThat(tree.contains(paramo)).isTrue();

//        Now delete the node with one child on the right
        tree.delete(hundredYears);
        assertThat(tree.contains(hundredYears)).isFalse();
        assertThat(tree.contains(paramo)).isTrue();
        assertThat(tree.contains(badGirl)).isTrue();


    }

    @Test
    void testDeleteTwoChildren() {
        assertThat(tree.contains(badGirl)).isTrue();
        assertThat(tree.contains(littlePrince)).isTrue();
        assertThat(tree.contains(labyrinth)).isTrue();
        assertThat(tree.contains(metamorphosis)).isTrue();
        tree.delete(littlePrince);

        assertThat(tree.contains(badGirl)).isTrue();
        assertThat(tree.contains(littlePrince)).isFalse();
        assertThat(tree.contains(labyrinth)).isTrue();
        assertThat(tree.contains(metamorphosis)).isTrue();
    }


}
