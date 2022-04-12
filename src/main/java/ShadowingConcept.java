public class ShadowingConcept {


    private static int num=10;


    public static void main(String[] args) {

        int num=20;
        System.out.println(num);

        num=30;
        System.out.println(ShadowingConcept.num);
        System.out.println(num);


    }
}
