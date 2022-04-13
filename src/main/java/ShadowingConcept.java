public class ShadowingConcept {


    private static int num = 10;


    public static void main(String[] args) {

        System.out.println(num);
        num = 8;
        System.out.println(num);
        int num;
//        System.out.println(num);
        num = 30;
        System.out.println(num);
        System.out.println(ShadowingConcept.num);


    }
}
