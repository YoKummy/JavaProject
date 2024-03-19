package Blockchain;
import java.util.*;
public class Block {
    
    public String hash;//hold digital signature
    public String previousHash;
    private String data;//block data
    private long timeStamp;//as number of millisecinds since 1/1/1970
    private int nonce;

    //Block Constructor
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();//Put this in the end after we set all of the values
    }
    
    public String calculateHash(){
        String calculatehash = StringUtil.applySha256(
            previousHash + Long.toString(timeStamp) + data
        );
        return calculatehash;
    }
}
