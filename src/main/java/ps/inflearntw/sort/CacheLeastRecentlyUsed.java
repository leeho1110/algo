package ps.inflearntw.sort;

public class CacheLeastRecentlyUsed {
    private final int[] tasks;
    private final int[] cache;

    public CacheLeastRecentlyUsed(int[] tasks, int cacheSize) {
        this.tasks = tasks;
        this.cache = new int[cacheSize];
    }

    public int[] printHistory() {
        for(int i=0; i< tasks.length; i++){
            boolean isCached = false;
            int cachingIdx = -1;

            for(int j=0; j< cache.length; j++){
                if(isExistInCache(i, j)){
                    isCached = true;
                    cachingIdx = j;
                    break;
                }
            }

            if(isCached){
                cacheHitProcess(cachingIdx);
            } else {
                cacheMissProcess(i);
            }
        }

        return cache;
    }

    private void cacheHitProcess(int cachingIdx) {
        pushIndexToRight(cachingIdx);
        cache[0] = tasks[cachingIdx];
    }

    private void cacheMissProcess(int i) {
        pushIndexToRight(cache.length - 1);
        cache[0] = tasks[i];
    }

    private boolean isExistInCache(int i, int j) {
        return tasks[i] == cache[j];
    }

    private void pushIndexToRight(int startingPoint) {
        for(int k = startingPoint; k>0; k--){
            cache[k] = cache[k-1];
        }
    }
}
