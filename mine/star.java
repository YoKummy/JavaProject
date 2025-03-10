public class star {
    public static void main(String[] args) {
        int star = 5;
        for (int i = 0; i <= star; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}