package be.tim.recycled;

/**
 *
 * @author Tim Boeckstaens
 * @version 1.0
 */
public class Recycler {
    public String process(String line) {
        String[] split = line.split(" ");

        if(split.length != 2){
            throw new IllegalArgumentException("Foute regel");
        }

        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);

        int counter = 0;

        for(int i = a ; i < b; i++){

            for(int j = i + 1; j <= b; j++){
                String s = i + "";
                String t = j + "";
                char[] chars = s.toCharArray();

                for(int x = 1; x < chars.length; x++){
                    char[] result = new char[chars.length];
                    int index = 0;
                    int start = chars.length - x;
                    for(int copy = start; copy < chars.length; copy++){
                        result[index++] = chars[copy];
                    }
                    for(int end = 0; end < start; end++){
                        result[index++] = chars[end];
                    }
                    if(new String(result).equals(t)){
                        counter++;
                        break;
                    }
                }

            }

        }

        return counter + "";
    }
}

