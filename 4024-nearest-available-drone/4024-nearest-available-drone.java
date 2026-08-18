class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int targetX=target[0],targetY=target[1];
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int nearest=-1;
        for(int i=0;i<drones.length;i++){
            int x=drones[i][0],y=drones[i][1],range=drones[i][2];
            int manhattan = Math.abs(x-targetX)+Math.abs(y-targetY);
            if(range>=manhattan && min>manhattan){
                min=manhattan;
                nearest=i;
            }
        }
        return nearest;
    }
}