class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        List<List<Integer>> graph = new ArrayList<>();

        int[] arr = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites){

            int course = edge[0];
            int prereq = edge[1];


            graph.get(prereq).add(course);
            arr[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int course = 0; course < numCourses; course++){
            if(arr[course] == 0){
                queue.offer(course);
            }
        }

        int completed = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            completed++;


            for(int nextCourse: graph.get(course)){
                arr[nextCourse]--;


                if(arr[nextCourse] == 0){
                    queue.offer(nextCourse);
                }
            }
        }

        return completed == numCourses;


        
    }
}
