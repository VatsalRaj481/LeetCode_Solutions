class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int training=0;
        int sumEnergy=0;
        for(int e:energy){
            sumEnergy+=e;
        }
        if(initialEnergy<=sumEnergy){
            training+=sumEnergy+1-initialEnergy;
        }
        for(int i=0;i<experience.length;i++){
            if(initialExperience<=experience[i]){
                int needed=experience[i]-initialExperience+1;
                training+=needed;
                initialExperience+=needed;
            }
            initialExperience+=experience[i];
        }
        return training;
    }
}