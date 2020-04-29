package mid;

public class Multiply {
	/* ��ͨ��ʽ
	 * public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
			return "";
		}
        if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
        if (num1.length() < num2.length()) {
        	String tmp = num1;
    		num1 = num2;
    		num2 = tmp;
		}
        char[] base = num1.toCharArray();
        char[] mu = num2.toCharArray();
        int offset = 0;
        String a1 = multi(base, mu[mu.length-1], offset++);
        String a2;
        for (int i = mu.length-2; i >= 0; i--) {
			a2 = multi(base, mu[i], offset++);
			a1 = add(a1.toCharArray(), a2.toCharArray());
		}
        return reverse(a1);
    }
	public String reverse(String str) {
		char[] chs = str.toCharArray();
		for (int i = 0; i < chs.length/2; i++) {
			swap(chs, i, chs.length-i-1);
		}
		return new String(chs);
	}
	public void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}
	public String multi(char[] base, char mul, int offset) {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		while(offset>0) {
			sb.append(0);
			offset--;
		}
		for (int i = base.length-1; i >=0; i--) {
			int tmp = (mul-'0') * (base[i]-'0') + flag;
			sb.append(tmp%10);
			flag = tmp/10;
		}
		while(flag != 0) {
			sb.append(flag%10);
			flag /= 10;
		}
		return sb.toString();
	}
	public String add(char[] str1, char[] str2) {
		int flag = 0;
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < str2.length && i< str1.length; i++) {
			int tmp = (str1[i]-'0' + str2[i]-'0') + flag;
			sb.append(tmp%10);
			flag = tmp/10;
		}
		while(i<str1.length) {
			int tmp = (str1[i]-'0' + flag);
			sb.append(tmp%10);
			flag = tmp/10;
			i++;
		}
		while(i<str2.length) {
			int tmp = (str2[i]-'0' + flag);
			sb.append(tmp%10);
			flag = tmp/10;
			i++;
		}
		if (flag != 0) {
			sb.append(flag);
		}
		return sb.toString();
	}*/

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Multiply().multiply("0", "1244125125151"));

    }

    // �Ż���
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

}
