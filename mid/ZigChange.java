package mid;

import java.util.HashMap;

public class ZigChange {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution s = new Solution();
        System.out.println(s.convert1("LEET", 2));
        System.out.println(s.convert2("LEET", 2));
    }

    public static class Solution {
        public String convert2(String s, int numRows) {
            if (numRows == 0) {
                return "";
            }
            if (numRows == 1) {
                return s;
            }
            String res = "";
            int k = 2 * numRows - 2;
            char[] chs = s.toCharArray();
            for (int i = 0; i < numRows; i++) {
                int index = i;
                int index2 = k - index;
                while (index < chs.length) {
                    if (i == 0 || i == numRows - 1) {
                        res = res + String.valueOf(chs[index]);
                        index = index + k;
                        continue;
                    }
                    res = res + String.valueOf(chs[index]);
                    if (index2 < chs.length) {
                        res = res + String.valueOf(chs[index2]);
                    }
                    index = index + k;
                    index2 = index2 + k;
                }
            }
            return res;
        }

        public String convert1(String s, int numRows) {
            if (s == null || s == "") {
                return "";
            }
            if (numRows == 1) {
                return s;
            }
            String res = "";
            char[] chs = s.toCharArray();
            int index = 0;
            HashMap<Integer, Node> matrixMap = new HashMap<>();
            int row = 0;
            boolean isUp = false;
            for (int i = 0; i < chs.length; ) {
                if (!matrixMap.containsKey(index)) {
                    matrixMap.put(index, new Node(new char[numRows]));
                }
                Node n = matrixMap.get(index);
                if (!isUp) {
                    if (row == numRows) {
                        row -= 2;
                        isUp = !isUp;
                        matrixMap.put(index, new Node(n.array));
                        index++;
                    } else {
                        n.array[row++] = chs[i++];
                    }
                } else {
                    if (row == 0) {
                        isUp = !isUp;
                    } else {

                        n.array[row] = chs[i++];
                        matrixMap.put(index, new Node(n.array));
                        index++;
                        row--;
                    }
                }
            }
            for (int j = 0; j < numRows; j++) {

                for (int i = 0; i <= index; i++) {
                    Node n;
                    if (matrixMap.containsKey(i)) {
                        n = matrixMap.get(i);
                    } else {
                        break;
                    }

                    if (n.array[j] != 0) {
                        res = res + n.array[j];
                    }
                    System.out.print(n.array[j]);
                }
                System.out.println();
            }
            return res;
        }

        class Node {
            public char[] array;

            public Node(char[] row) {
                array = row;
            }
        }
    }

}
