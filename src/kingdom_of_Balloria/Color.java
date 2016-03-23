package kingdom_of_Balloria;

public enum Color {
    RED('R'),
    BLUE('B'),
    GREEN('G'),
    YELLOW('Y');


    private char firstLetterOfColor;

    Color(char FirstLetterOfColor) {
        firstLetterOfColor = FirstLetterOfColor;
    }

    public char represent() {
        return firstLetterOfColor;
    }
}
