package kingdom_of_Balloria;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderedByColorSummary implements SummaryFormat {
    @Override
    public HashMap<String, Integer> summarizeBagData(ArrayList<Character> bagData) {
        HashMap<String,Integer> summary= new HashMap<>();
        summary.put("Bag",bagData.size());
        summary.put("Blue",countBalls('B',bagData));
        summary.put("Green",countBalls('G',bagData));
        summary.put("Red",countBalls('R',bagData));
        summary.put("Yellow",countBalls('Y',bagData));
        return summary;
    }

    private Integer countBalls(char color,ArrayList<Character> bagData) {
        int counter = 0;
        for (Character character : bagData) {
            if(character == color)
                counter++;
        }
        return counter;

    }
}
