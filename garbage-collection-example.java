class User {
    private int id;

    public User(int id) {
        this.id = id;
    }
}

class GarbageCollectionExample {

    private static void printUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Used memory : %d\n",usedMemory);
    }

    public static void main(String[] args) {
        printUsedMemory();

        for (int i = 0; i < 1_000_000; i++) {
            new User(i);
        }

        printUsedMemory();

        System.gc();

        printUsedMemory();
    }
}