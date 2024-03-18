package Blockchain;
import java.util.*;
public class Block {
    
    public String hash;//hold digital signature
    public String previousHash;
    private String data;//block data
    private long timeStamp;//as number of millisecinds since 1/1/1970

    //Block Constructor
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }
    
    public String calculateHash(){
        String calculatehash = StringUtil.applySha256(
            previousHash + Long.toString(timeStamp) + data
        );
        return calculatehash;
    }
}
