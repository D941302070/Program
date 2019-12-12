package LanQiaoYuSai.yusai;

import PersonalLibrary.SuShu;

public class text {

    public static void main(String[] args) {
        SuShu obj = new SuShu();
        for (int i = 10000; i >0 ; i--) {
            if (obj.isPrime(i)==true){
                System.out.println(i);
                break;
            }
        }

        System.out.println(2019/3/2*2018*2017);

    }

}
