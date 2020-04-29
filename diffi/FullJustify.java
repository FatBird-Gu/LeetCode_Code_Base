package diffi;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new FullJustify().fullJustify(new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"}
                , 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int wordCnt = 0;// ��¼�ַ����ĳ��ȣ����ж��Ƿ�Խ��
        int len = 0; //��¼��һ���ַ����а������ʵ�����
        int start = 0; //��¼��һ���ַ����Ŀ�ʼλ��(��words�е��±�)
        while (i < words.length) {
            wordCnt += words[i].length(); //���ϵ�ǰ�ĵ��ʳ���
            if (wordCnt <= maxWidth) { //���Դ����������
                i++;
                len++;
                wordCnt++; //ÿ���������һ�����ʺ�Ҫ��һ���ո�
            } else {
                if (i == words.length) {//��������һ������
                    res.add(addLastString(words, start, len, maxWidth));//���һ�����⴦��
                } else {
                    res.add(addString(words, start, len, maxWidth));//�ô�start��ʼ����len�����ʽ��н���ƴ��
                }
                len = 0; //���ø���������������һ���ַ����ļ���
                wordCnt = 0;
                start = i;
            }
        }
        if (len != 0)   //������е���û�м��룬�Ͱ�ʣ�µ��ʷ������һ��
            res.add(addLastString(words, start, len, maxWidth));
        return res;
    }

    //�������һ��
    private String addLastString(String[] words, int start, int len, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int spaceCnt = maxWidth;
        //�����ÿ�����ʺ��Ǹ��ո��ʣ��ո���
        for (int i = 0; i < len; i++) {
            spaceCnt -= (words[start + i].length() + 1);
        }
        if (spaceCnt >= 0) {
            for (int i = 0; i < len; i++) {
                sb.append(words[start + i] + " ");
            }
            sb.append(nSpace(spaceCnt));
        }
        // <0������������һ��������û�пո��
        else {
            for (int i = 0; i < len - 1; i++) {
                sb.append(words[start + i] + " ");
            }
            sb.append(words[start + len - 1]);
        }

        return sb.toString();
    }

    //��������һ�е�������
    private String addString(String[] words, int start, int len, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int spaceCnt = maxWidth;
        // ����ո������������ʺ���Ŀո�
        for (int i = 0; i < len; i++) {
            spaceCnt -= words[start + i].length();
        }
        if (len > 1) {
            for (int i = 0; i < len; i++) {
                sb.append(words[start + i]);
                int numSpace = (int) Math.ceil(1.0 * spaceCnt / (len - 1 - i));//��Ϊ��ո�>=�ҿո�������ȡ��
                sb.append(nSpace(numSpace));
                spaceCnt -= numSpace;
            }
            // len==1������¼��㣬������ķ�������ո��/0,���Ե�������
        } else {
            sb.append(words[start]);
            sb.append(nSpace(spaceCnt));
        }
        return sb.toString();
    }

    //����n���ո���ַ���
    private String nSpace(int numSpace) {
        String res = "";
        for (int i = 0; i < numSpace; i++) {
            res += " ";
        }
        return res;
    }

}
