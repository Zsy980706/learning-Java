package class01;

public class Code_01Test {
    //位运算相关
    //打印int数字32进制数
    public static void print(int num){
        for(int i = 31;i>=0;i--){
            System.out.print( (num & (1<<i)) ==0?"0":"1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        print(5);
//        print(-5);
//        print(~5+1);
        print(5);
        print(8);
        print(5&8);
        print(5|8);
        print(5^8);//相同为0不同为1，异或

    }

}
