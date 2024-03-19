package Blockchain;

import java.util.*;
import com.google.gson.GsonBuilder;
public class TestChain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();


    public static Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes
        for(int i = 1; i < blockchain.size(); i++){
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList
        blockchain.add(new Block("This first block is for testing", "0"));
        blockchain.add(new Block("Yo second block here", blockchain.get(blockchain.size() - 1).hash));
        blockchain.add(new Block("Hey Im the thrid one", blockchain.get(blockchain.size() - 1).hash));
        
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }
}