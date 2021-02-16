package string.splitAndRegex;

import java.util.Arrays;

public class Split1 {

	public static void main(String[] args) {
		
		String str = "1,огурцы,20.05;2,помидоры,123.45;3,зайцы,0.50";
        String[] words = str.split(";");
        double[] num = new double[words.length];
        for (int i = 0; i< words.length; i++) {
            String[] temp = words[i].split(",");
            num[i] = Double.parseDouble(temp[temp.length-1]);
        }
       double sum =  Arrays.stream(num).sum();
       System.out.println(sum);
	}

}
