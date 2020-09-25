import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;


class Ct2
{


    static String one[] = { "", "one ", "two ", "three ", "four ",
            "five ", "six ", "seven ", "eight ",
            "nine ", "ten ", "eleven ", "twelve ",
            "thirteen ", "fourteen ", "fifteen ",
            "sixteen ", "seventeen ", "eighteen ",
            "nineteen " };
    static String ten[] = { "", "", "twenty ", "thirty ", "forty ",
            "fifty ", "sixty ", "seventy ", "eighty ",
            "ninety " };

    private static final String EMPTY = "";

    private static final String[] X =
            {
                    EMPTY, "One", "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Eleven","Twelve",
        "Thirteen", "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
        };

private static final String[] Y =
        {
        EMPTY, EMPTY,"Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"
        };

private static String convertToDigit(int n, String suffix)
        {
        if (n == 0) {
        return EMPTY;
        }

        if (n > 19) {
        return Y[n / 10] + X[n % 10] + suffix;
        }
        else {
        return X[n] + suffix;
        }
        }

    public static String convert(int n)
        {
        StringBuilder res = new StringBuilder();

            res.append(convertToDigit(((n / 100000) % 100), "Lakh, "));

        res.append(convertToDigit(((n / 1000) % 100), "Thousand "));

        res.append(convertToDigit(((n / 100) % 10), "Hundred "));

        if ((n > 100) && (n % 100 != 0)) {
        res.append("and ");
        }

        res.append(convertToDigit((n % 100), ""));

        return res.toString();
        }




public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String,String> currency=new HashMap<>();
        HashMap<String,Integer> nums=new HashMap<>();
        currency.put("dollars","$");currency.put("euros","€");
        currency.put("rupees","₹");currency.put("yens","¥");
        currency.put("dinars","د.ك");currency.put("Ringgit","RM");

        nums.put("double",2);nums.put("triple",3);nums.put("quadraple",4);



        String A[]=br.readLine().split(" ");
        if(A.length==1){
            String oneWord=A[0];
            for(int i=0;i<one.length;i++){
                if(one[i].equals(oneWord)){
                    bw.write(i+"\n");
                    System.exit(0);
                }
            }
            for(int i=0;i<ten.length;i++){
                if(ten[i].equals(oneWord)){
                    bw.write((10+i)+"\n");
                    System.exit(1);
                }
            }
            if(currency.containsKey(oneWord)){
                bw.write(currency.get(oneWord)+"\n");
                System.exit(2);
            }
            oneWord=oneWord.substring(0,oneWord.length()-1);
            if(currency.containsKey(oneWord)){
                bw.write(currency.get(oneWord)+"\n");
                System.exit(3);
            }
        }
        for(int i=0;i<A.length-1;i++){
            String currWord=A[i];
            String nextWord=A[i+1];
            if(nums.containsKey(currWord)){
                for(int j=0;j<nums.get(currWord);j++){
                    bw.write(nextWord+"");
                }
                i++;
            }else if(currency.containsKey(nextWord)){
                bw.write(currency.get(nextWord)+"");
                int num=Integer.parseInt(currWord);
                String ans=convert(num);
                bw.write(ans);
            }
        }

        bw.flush();
    }
}
