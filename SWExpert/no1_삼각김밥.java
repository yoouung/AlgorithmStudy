package solving.SWExpert;

import java.util.*;

public class no1_삼각김밥 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            if (s > e) {
                int temp = s;
                s = e;
                e = temp;
            } else if (s == e) {
                System.out.println("#" + (i + 1) + " " + 0);
                continue;
            } 

            Position start = getPosition(s);
            Position end = getPosition(e);

            System.out.println("#" + (i + 1) + " " + count(start, end));
        }
    }
    
    private static int count(Position start, Position end) {
        int result;

        if (start.level == end.level) {
            result = end.index - start.index;
        } else {
            int levelDiff = end.level - start.level;
            int maxRange = start.index + (levelDiff);
            if (start.index <= end.index && end.index <= maxRange) {
                result = levelDiff;
            } else if (end.index > maxRange) {
                result = levelDiff + (end.index - maxRange);
            } else { // end.index < start.index
                result = levelDiff + (start.index - end.index);
            }
        }

        return result;
    }

    private static Position getPosition(int point) {
        int level = 0;
        int index;
        int num = 0;

        while (num < point) {
            num += level;
            level++;
        }

        level--;
        index = point - num + level ;

        return new Position(level, index);
    }

    static class Position {
        int level;
        int index;

        Position(int level, int index) {
            this.level = level;
            this.index = index;
        }
    }

}
