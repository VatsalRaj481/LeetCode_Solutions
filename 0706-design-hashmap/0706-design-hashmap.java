class MyHashMap {
    private final static int SIZE=1_000_001;
    List<Node>[] bucket;
    static class Node{
        int key;
        int value;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    public MyHashMap() {
        bucket = new ArrayList[SIZE];
        for(int i=0;i<SIZE;i++){
            bucket[i]=new ArrayList<>();
        }
    }

    private int hash(int key){
        return key%SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        for(Node node:bucket[index]){
            if(node.key==key){
                node.value=value;
                return;
            }
        }
        bucket[index].add(new Node(key,value));
    }
    
    public int get(int key) {
        int index = hash(key);
        for(Node node:bucket[index]){
            if(node.key==key){
                return node.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        for(int i=0;i<bucket[index].size();i++){
            if(bucket[index].get(i).key==key){
                bucket[index].remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */