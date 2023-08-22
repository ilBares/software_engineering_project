package it.unibs.se_project.view.utilities;

/**
 * {@code MenuItem} represent a required class for
 * {@code Menu} class.
 *
 * @author Baresi Marco
 * @see MyMenu
 */
public class MyMenuItem {
    private String text;
    private Runnable function;

    /**
     * {@code MenuItem} constructor.
     *
     * @param text of the option
     * @param function associated to the item
     */
    public MyMenuItem(String text, Runnable function) {
        this.text = text;
        this.function = function;
    }

    /**
     * @return {@link #text}
     */
    public String getText() {
        return text;
    }

    /**
     * @return {@link #function}
     */
    public Runnable getFunction() {
        return function;
    }
}