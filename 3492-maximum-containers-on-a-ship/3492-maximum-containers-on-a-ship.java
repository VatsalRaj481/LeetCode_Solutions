// class Solution {
//     public int maxContainers(int n, int w, int maxWeight) {
//         int containers=0,totalWeight=0;
//         for(int i=0;i<n*n;i++){
//             totalWeight+=w;
//             if(totalWeight<=maxWeight){
//                 containers++;
//             }
//         }
//         return containers;
//     }
// }
class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n, maxWeight / w);
    }
}