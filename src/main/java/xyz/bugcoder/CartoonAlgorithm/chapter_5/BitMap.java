package xyz.bugcoder.CartoonAlgorithm.chapter_5;

/**
 * @Package: xyz.bugcoder.CartoonAlgorithm.chapter_5
 * @author: Weiyj
 * @Description: BitMap的使用
 * @createTime 2020-09-22 08:27
 */
public class BitMap {

    private long[] words;
    // bitmap的位数
    private int size;

    public BitMap(int size) {
        this.size = size;
        this.words = new long[getWordIndex(size - 1) + 1];
    }

    public boolean getBit(int bitIndex){
        if (bitIndex < 0 || bitIndex > size - 1){
            throw new IndexOutOfBoundsException("超出bitmap范围");
        }

        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1l << bitIndex)) != 0;
    }

    public void setBit(int bitIndex){
        if (bitIndex < 0 || bitIndex > size - 1){
            throw new IndexOutOfBoundsException("超出bitmap范围");
        }

        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1l << bitIndex);
    }

    private int getWordIndex(int bitIndex){
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(128);
        bitMap.setBit(126);
        bitMap.setBit(75);
        System.out.println(bitMap.getWordIndex(126));
        System.out.println(bitMap.getWordIndex(70));
    }

}
