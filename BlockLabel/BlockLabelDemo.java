public class BlockLabelDemo {
    
    public static void main(String[] args) {
        outer: {
            for (int i = 0; i < 10; i++){
                for (int j= 0; j < 10; j++){
                    if (i==2)
                        break outer;
                        
                    System.out.println("i: " + i +"  "+ "j: "+ j);
                }
            }
        }
    }

}
