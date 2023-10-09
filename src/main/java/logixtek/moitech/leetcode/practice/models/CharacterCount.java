package logixtek.moitech.leetcode.practice.models;

public class CharacterCount {
    public char character;
    public int count;

    public CharacterCount(char character, int count) {
        this.character = character;
        this.count = count;
    }

    public static CharacterCount of(char character) {
        return new CharacterCount(character, 1);
    }

    @Override
    public String toString() {
        return Character.toString(character).repeat(count);
    }
}
