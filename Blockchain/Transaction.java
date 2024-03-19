package Blockchain;

import java.security.*;
import java.util.*;
public class Transaction {
    public String transactionId;// this is also the hash of the transaction
    public PublicKey sender;
    public PublicKey reciepient;
    public float value;
    public byte[] signature;// this is to prevent anybody else from spending funds in our wallet

    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();

    private static int sequence = 0;// rough count of how many transaction have been generated

    //Construtor
    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs){
        this.sender = from;
        this.reciepient = to;
        this.value = value;
        this.inputs = inputs;
    }

    //This calculates the transaction hash(which will be used as its Id)
    private String calculateHash(){
        sequence ++;
        return StringUtil.applySha256(
            StringUtil.getStringFromKey(sender) + StringUtil.getStringFromKey(reciepient) + 
            Float.toString(value) + sequence
        );
    }
}
