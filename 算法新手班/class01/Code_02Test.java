package class01;

public class Code_02Test {
    //��Ŀ��
    //����1��+2��+3��+4��+����������+N���Ľ��
    public static long method1(int N){
        long ans = 0;
        for(int i=1;i<=N;i++){
            ans = ans + factorial(i);
        }
        return ans;
    }
    public static long factorial(int N){
        long ans = 1;
        for(int i =1;i<=N;i++){
            ans =  ans * i;
        }
        return ans;
    }

    public static long method2(int N){
        long ans  = 0;//�ܺ�
        long temp = 1;//ÿһ�������ֵ
        for(int i=1;i<=N;i++){
            temp = temp * i;
            ans = ans + temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 10;
        System.out.println(method1(N));
        System.out.println(method2(N));
    }
}
