import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Beginner{

    Hashtable<Character, Character> openCloseMap = new Hashtable<Character, Character>();
    public static void main(String[] args){
        Object[] whateverThisIs = Arrays.asList("Hello World",2,1.5).toArray();
        whatsAllThis(whateverThisIs);
    }
    
    private static void whatsThis(Object whateverThisIs) {
        System.out.println(whateverThisIs + "\n");
    }

    private static void whatsAllThis(Object[] list){
        if(list.length != 0)
        for(Object crap : list){
            whatsThis(crap);
        }
    }

    public boolean isValid(String s) {
        openCloseMap();
        return naiveSolution(s);
    }

    private boolean isEven(String s) {
        return s.length() % 2 == 0;
    }

    private boolean validateStringSizeTwo(String s) {
        return findPair(s.charAt(0), s.charAt(s.length() - 1));
    }

    private boolean checkFirstIsOpenandLastIsClosed(String s) {
        return isOpen(s.charAt(0)) && isClose(s.charAt(s.length() - 1));
    }

    private boolean isOpen(Character c) {
        return openCloseMap.containsKey(c);
    }

    private boolean isClose(Character c) {
        return !isOpen(c);
    }

    private boolean findPair(Character open, Character close) {
        return isOpen(open) && openCloseMap.get(open).equals(close);
    }

    private boolean naiveSolution(String s) {
        boolean isValid = false;
        int current = 0;
        int next = 0;
        Character charAtCurrent;
        Character charAtNext;
        int windowLength = current;
        boolean isValidForLengthTwo = s.length() == 2 && validateStringSizeTwo(s);
        // if (!isEven(s) && checkFirstIsOpenandLastIsClosed(s)) {
        // return false;
        // }
        // isValid = validateStringSizeTwo(s);
        if (isValid == false && s.length() != 2) {
            for (int i = 0; i < s.length() - 1; i++) {
                next = current + 1;
                charAtCurrent = s.charAt(current);
                charAtNext = s.charAt(next);
                isValid = isOpen(charAtCurrent) && isOpen(charAtNext);
                windowLength++;
                if (!isValid && findPair(charAtCurrent, charAtNext)) {
                    isValid = validateInWindow(current, windowLength, s);
                    if (!isValid) {
                        break;
                    }
                    windowLength = 0;
                }

            }
        }
        return isValid;
    }

    private boolean validateInWindow(int current, int windowLength, String s) {
        int previousWindowIndex = 0;
        int nextWindowIndex = 0;
        boolean isValid = false;
        previousWindowIndex = current;
        nextWindowIndex = current + 1;

        for (int i = 0; i < windowLength && nextWindowIndex < s.length(); i++) {
            isValid = findPair(s.charAt(previousWindowIndex), s.charAt(nextWindowIndex));
            if (!isValid) {
                break;
            }
            previousWindowIndex--;
            nextWindowIndex++;
        }
        return isValid;
    }

    private void openCloseMap() {
        if (openCloseMap.size() == 0) {
            List<Character> open = Arrays.asList('(', '{', '[');
            List<Character> close = Arrays.asList(')', '}', ']');
            int count = 0;
            for (Character bracket : open) {
                openCloseMap.put(bracket, close.get(count));
                count++;
            }
        }
    }
}

