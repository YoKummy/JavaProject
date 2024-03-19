package Blockchain;

import java.security.*;
public class TransactionOutput {
    public String id;
    public PublicKey reciepient;//aka the new owner of the coin
    public float value;//the amount they own
    public String parentTransactionId;//the id of the transaction this output was created in

    //Constructor
    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId){
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = StringUtil.applySha256(StringUtil.getStringFromKey(reciepient) 
        + Float.toString(value)
        + parentTransactionId);
    }

    //check if coin belongs to you
    public boolean isMine(PublicKey publicKey){
        return (publicKey == reciepient);
    }
}
