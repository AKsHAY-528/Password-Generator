import java.util.Random;

public class Generator {

    public static final String LOWERCASE_CHARACTERS ="abcdefghijklmnopqrstuvwxyz";
    public static final  String UPPERCASE_CHARATERS ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS="0123456789";
    public static final String SPECIAL_SYMBOLS ="!@#$%^&*()_[]{}-+=';,./<>?|";

    private final Random random;
    public Generator(){
        random = new Random();
    }
    public String generatePassword(int length,boolean includeUppercase , boolean includeLowercase,boolean includeNumbers,boolean includeSpecialSymbols) {
        StringBuilder passwordBuilder = new StringBuilder();

        String validCharacters = "";
        if (includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if (includeNumbers) validCharacters += NUMBERS;
        if (includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;
        if (includeUppercase) validCharacters += UPPERCASE_CHARATERS;

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            char randomChar = validCharacters.charAt(randomIndex);
            passwordBuilder.append(randomChar);

        }
        return passwordBuilder.toString();
    }
}

