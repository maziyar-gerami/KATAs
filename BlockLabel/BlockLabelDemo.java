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

        final int k =10;

        String s = switch (k) {
            case 10 -> "10";               
            case 11 -> "11";    
            default -> {
                int x =0;
                yield "other";
            }

        };

        String s1 = switch (k) {
            case 10 : yield "10";               
            case 11 : yield "11";    
            default :
                int x =0;
                yield "other";
        
        };

        System.out.println(s1);
    }

}
