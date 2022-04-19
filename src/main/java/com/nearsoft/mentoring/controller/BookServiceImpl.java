package com.nearsoft.mentoring.controller;


import com.nearsoft.mentoring.model.Book;
import com.nearsoft.mentoring.tree.BinarySearchTree;
import com.nearsoft.mentoring.tree.Tree;
import org.springframework.stereotype.Service;

@Service
class BookServiceImpl implements BookService {

    private final Tree<Book> tree;

    public BookServiceImpl() {
        tree = new BinarySearchTree<>();
        Book hopscotch = new Book("Hopscotch", "Cortázar", "9788437604572", 1963);
        Book love = new Book("Love in the Time of Cholera", "García Márquez", "9780307387264", 1985);
        Book hundredYears = new Book("One Hundred Years of Solitude", "García Márquez", "9788420471839", 1967);
        Book paramo = new Book("Pedro Páramo", "Rulfo", "9780802133908", 1955);
        Book badGirl = new Book("The Bad Girl", "Vargas Llosa", "9789707704664", 2006);
        Book labyrinth = new Book("The Labyrinth of Solitude", "Paz", "9780802150424", 1950);
        Book littlePrince = new Book("The Little Prince", "Saint-Exupéry", "9789871165070", 1915);
        Book metamorphosis = new Book("The Metamorphosis", "Kafka", "9789871165070", 1915);
        tree.add(badGirl);
        tree.add(hundredYears);
        tree.add(littlePrince);

        tree.add(love);
        tree.add(hopscotch);
        tree.add(paramo);

        tree.add(labyrinth);
        tree.add(metamorphosis);
    }

    @Override
    public Tree<Book> add(Book value) {
        tree.add(value);
        return tree;
    }

    @Override
    public Tree<Book> getAll() {
        return tree;
    }
}
