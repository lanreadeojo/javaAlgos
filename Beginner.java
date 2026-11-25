import java.util.Arrays;

public class Beginner{
    public static void main(String[] args){
        Object[] whateverThisIs = Arrays.asList("Hello World").toArray();
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
}

