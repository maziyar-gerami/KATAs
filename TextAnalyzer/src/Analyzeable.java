public interface Analyzeable {

    long count();

    long words();

    String reverse();

    String upercase();

    String lowercase();

    void stats();
    
    void saveHistory(String str);
} 
