package threads.producerconsumer;

public class SingleBuffer {
    public static final int MAX_LIMIT = 30;
    private Integer buffer =null;
    
    public Integer getBuffer() {
        return buffer;
    }
    
    public void setBuffer(Integer count) {
        this.buffer = count;
    }
    
    public void setBufferEmpty() {
        buffer = null;
    }
    
    
    
}